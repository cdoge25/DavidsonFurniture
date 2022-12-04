package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.nhom6.davidsonfurniture.Databases.SessionManager;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityLoginBinding;

import java.util.HashMap;

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

        //Check Shared Preferences
        SessionManager sessionManager = new SessionManager(LoginActivity.this, SessionManager.SESSION_REMEMBERME);
        if (sessionManager.checkRememberMe()){
            HashMap<String,String> rememberMeDetails = sessionManager.getRememberMeDetailFromSession();
            binding.loginPhone.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPHONE));
            binding.loginPassword.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD));
        }

        toRegister();
        toForgetPassword();
        toHome();

//        temporaryLogin();
    }

    private void toHome() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check Internet Connection
                if(!isConnected(LoginActivity.this)){
                    showConnectDialog();
                }

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

                if (binding.cbRememberMe.isChecked()){
                    SessionManager sessionManager = new SessionManager(LoginActivity.this, SessionManager.SESSION_REMEMBERME);
                    sessionManager.createRememberMeSession(_phone, _password);
                }

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

                                //Create a Session
                                SessionManager sessionManager = new SessionManager(LoginActivity.this, SessionManager.SESSION_USERSESSION);
                                sessionManager.createLoginSession(_name, _mail, _phone, _password);

                                //Go To Home
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);

                            } else {
                                binding.edtPassword.setError("Mật khẩu không đúng");
                                binding.edtPassword.requestFocus();
                            }
                        } else {
                            binding.edtPhone.setError("Số điện thoại chưa được đăng ký");
                            binding.edtPhone.requestFocus();
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

    private boolean isConnected(LoginActivity loginActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) loginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())){
            return true;
        }
        else{
            return false;
        }
    }

    private void showConnectDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Vui lòng kiểm tra lại kết nối mạng để tiếp tục")
                .setCancelable(true)
                .setPositiveButton("Cài đặt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
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