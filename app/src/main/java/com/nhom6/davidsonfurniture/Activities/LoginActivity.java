package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

//        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toRegister();
        toForgetPassword();
        toHome();

//        temporaryLogin();
    }

    private void toHome() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate fields
                if (!validatePhone() | !validatePassword()) {
                    return;
                }

                //get data
                String _phone = binding.edtPhone.getEditText().getText().toString().trim();
                String _password = binding.edtPassword.getEditText().getText().toString().trim();

                if (_phone.startsWith("0")) {
                    _phone = _phone.substring(1);
                } else if (_phone.startsWith("+84")) {
                    _phone = _phone.substring(3);
                }
                String _completedPhoneNumber = "+84" + _phone;

                //Firebase Database Check
                Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phone").equalTo(_completedPhoneNumber);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            binding.edtPhone.setError(null);
                            binding.edtPhone.setErrorEnabled(false);

                            String systemPassword = snapshot.child(_completedPhoneNumber).child("password").getValue(String.class);

                            if (systemPassword.equals(_password)) {
                                binding.edtPassword.setError(null);
                                binding.edtPassword.setErrorEnabled(false);

                                String _name = snapshot.child(_completedPhoneNumber).child("name").getValue(String.class);
                                String _mail = snapshot.child(_completedPhoneNumber).child("mail").getValue(String.class);
                                String _phone = snapshot.child(_completedPhoneNumber).child("phone").getValue(String.class);
                                String _password = snapshot.child(_completedPhoneNumber).child("password").getValue(String.class);

                                //Go To Home
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(LoginActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Số điện thoại chưa được đăng ký", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void toRegister() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toForgetPassword() {
        binding.btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validatePhone() {
        String _phone = binding.edtPhone.getEditText().getText().toString().trim();
        if (_phone.isEmpty()) {
            binding.edtPhone.setError("Không được bỏ trống vùng này");
            binding.edtPhone.requestFocus();
            return false;
        } else {
            binding.edtPhone.setError(null);
            binding.edtPhone.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String _password = binding.edtPassword.getEditText().getText().toString().trim();
        if(_password.isEmpty()){
            binding.edtPassword.setError("Không được bỏ trống vùng này");
            return false;
        }
        else{
            binding.edtPassword.setError(null);
            binding.edtPassword.setErrorEnabled(false);
            return true;
        }
    }

    private void temporaryLogin() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}