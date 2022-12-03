package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPassword2Binding;

public class ForgetPasswordActivity2 extends AppCompatActivity {

    ActivityForgetPassword2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forget_password2);

        //hide status and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityForgetPassword2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        goBack();
        toForget3();
    }

    private void goBack() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void toForget3() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validatePassword() | !validateRetypePassword()){
                    return;
                }

                String _newPassword = binding.edtNewPassword.getEditText().getText().toString().trim();
                String _phone = getIntent().getStringExtra("phone");

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                reference.child(_phone).child("password").setValue(_newPassword);

                startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity3.class));
                finish();
            }
        });
    }

    private boolean validatePassword() {
        String val = binding.edtNewPassword.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            binding.edtNewPassword.setError("Không được bỏ trống vùng này");
            return false;
        }
        else{
            binding.edtNewPassword.setError(null);
            binding.edtNewPassword.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateRetypePassword() {
        String retypeP = binding.edtRetypePassword.getEditText().getText().toString().trim();
        String newP = binding.edtNewPassword.getEditText().getText().toString().trim();
        if (retypeP.isEmpty()){
            binding.edtRetypePassword.setError("Không được bỏ trống vùng này");
            return false;
        }
        else if (!retypeP.matches(newP)){
            binding.edtRetypePassword.setError("Mật khẩu chưa khớp");
            return false;
        }
        else{
            binding.edtRetypePassword.setError(null);
            binding.edtRetypePassword.setErrorEnabled(false);
            return true;
        }
    }
}