package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPasswordBinding;

import java.util.Objects;

public class ForgetPasswordActivity extends AppCompatActivity {

//    ActivityForgetPasswordBinding binding;

    ImageButton back;
    Button sendOtp;
    TextInputLayout phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

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

        //hooks
        back = findViewById(R.id.btnBack);
        sendOtp = findViewById(R.id.btnSendOtp);
        phone = findViewById(R.id.edtPhone);
    }

    public void toPhoneOtp(View view) {
        if (!validatePhone()) {
            return;
        }

        String _phone = phone.getEditText().getText().toString().trim();

        if (_phone.startsWith("0")) {
            _phone = _phone.substring(1);
        } else if (_phone.startsWith("+84")) {
            _phone = _phone.substring(3);
        }
        String _completedPhoneNumber = "+84" + _phone;

        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phone").equalTo(_completedPhoneNumber);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    phone.setError(null);
                    phone.setErrorEnabled(false);

                    Intent intent = new Intent(getApplicationContext(), PhoneOtpActivity.class);
                    intent.putExtra("phone", _completedPhoneNumber);
                    intent.putExtra("whatToDo", "updateData");
                    startActivity(intent);
                }else{
                    phone.setError("Số điện thoại chưa được đăng ký");
                    phone.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private boolean validatePhone() {
        String _phone = phone.getEditText().getText().toString().trim();
        if (_phone.isEmpty()) {
            phone.setError("Không được bỏ trống vùng này");
            phone.requestFocus();
            return false;
        } else {
            phone.setError(null);
            phone.setErrorEnabled(false);
            return true;
        }
    }
}