package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.nhom6.davidsonfurniture.R;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout name, mail, phone, password;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.edtName);
        mail = findViewById(R.id.edtMail);
        phone = findViewById(R.id.edtPhone);
        password = findViewById(R.id.edtPassword);
        send = findViewById(R.id.btnSendOtp);

    }

    private boolean validateName() {
        String val = name.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            name.setError("Không được bỏ trống vùng này");
            return false;
        }
        else{
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateMail(){
        String val = mail.getEditText().getText().toString().trim();
        String checkMail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            mail.setError("Không được bỏ trống vùng này");
            return false;
        }
        else if (!val.matches(checkMail)){
            mail.setError("Email phải theo dạng user@example.extension");
            return false;
        }
        else{
            mail.setError(null);
            mail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhone() {
        String val = phone.getEditText().getText().toString().trim();
        String checkPhone = "[0-9]{9}";
        if(val.isEmpty()){
            phone.setError("Không được bỏ trống vùng này");
            return false;
        }else if(!val.matches(checkPhone)){
            phone.setError("Số điện thoại phải gồm 9 chữ số, bắt đầu bằng số 0");
            return false;
        }
        else{
            phone.setError(null);
            phone.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String val = password.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            password.setError("Không được bỏ trống vùng này");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void toRegister2(View view) {
        if (!validateName() | !validateMail() | !validatePhone() | !validatePassword()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), RegisterActivity2.class);
        startActivity(intent);
    }
}