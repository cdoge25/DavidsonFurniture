package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;
import com.nhom6.davidsonfurniture.R;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout name, mail, phone, password;
    Button send;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_on_boarding);
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

        name = findViewById(R.id.edtName);
        mail = findViewById(R.id.edtMail);
        phone = findViewById(R.id.edtPhone);
        password = findViewById(R.id.edtPassword);

        send = findViewById(R.id.btnSendOtp);
        back = findViewById(R.id.btnBack);

        backToLogin();
    }

    private void backToLogin() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        String checkMail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

        if(val.isEmpty()){
            mail.setError("Không được bỏ trống vùng này");
            return false;
        }
        else if (!val.matches(checkMail)){
            mail.setError("Email phải theo dạng user@domain");
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
        }
        else if(!val.matches(checkPhone)){
            phone.setError("Số điện thoại gồm 9 chữ số, không có số 0 ở đầu");
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

    public void toPhoneOtp(View view) {
        if (!validateName() | !validateMail() | !validatePhone() | !validatePassword()) {
            return;
        }
        String _name = name.getEditText().getText().toString().trim();
        String _mail = mail.getEditText().getText().toString().trim();
        String _phone = "+84" + phone.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();


        Intent intent = new Intent(getApplicationContext(), PhoneOtpActivity.class);

        intent.putExtra("name", _name);
        intent.putExtra("mail", _mail);
        intent.putExtra("phone", _phone);
        intent.putExtra("password", _password);
        intent.putExtra("whatTodo","storeData");

        startActivity(intent);
    }
}