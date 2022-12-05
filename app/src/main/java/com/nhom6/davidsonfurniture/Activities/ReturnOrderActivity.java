package com.nhom6.davidsonfurniture.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReturnOrderActivity extends AppCompatActivity {

    ReturnOrderActivity binding;
    ActivityResultLauncher<Intent> launcherImage;

    Toolbar toolbarReturnOrder, toolbarImageResource;
    Button btnSendRequest, btnCanCelReturn, btnConfirmReturn, btnBackHome, btnAddImageReturn, btnOpenCamera, btnOpenLibrary;
    RadioGroup radGroupReturn;
    ImageView imvReturnPhoto;
    EditText edtReturnNote;

    BottomSheetDialog sheetDialogImageResource;

    boolean isCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_order);

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

        linkViews();
        addEvents();
        goBack();
        createUploadImageDialog();

//        launcherImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
//            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
//                imvReturnPhoto.setImageBitmap(bitmap);
//            }
//        });

        launcherImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (isCamera && result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                    imvReturnPhoto.setImageBitmap(bitmap);
                } else {
                    Uri uri = result.getData().getData();
                    if (uri != null) {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imvReturnPhoto.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void linkViews() {
        toolbarReturnOrder = findViewById(R.id.toolbarReturnOrder);
        btnSendRequest = findViewById(R.id.btnSendRequest);
        btnAddImageReturn = findViewById(R.id.btnAddImageReturn);
        radGroupReturn = findViewById(R.id.radGroupReturn);
        imvReturnPhoto = findViewById(R.id.imvReturnPhoto);
        edtReturnNote = findViewById(R.id.edtReturnNote);
    }

    private void goBack(){
        toolbarReturnOrder.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addEvents(){
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radId = radGroupReturn.getCheckedRadioButtonId();
                String note = edtReturnNote.getText().toString();
                int countnote = note.trim().length();
                BitmapDrawable image = (BitmapDrawable) imvReturnPhoto.getDrawable();

                if(radId != -1 && countnote != 0 && image != null){
                    openDialogReturnOrder();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn lý do trả hàng, tải hình ảnh và nhập ghi chú", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btnAddImageReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialogImageResource.show();
            }
        });
    }

    private void openDialogReturnOrder(){
        Dialog dialog = new Dialog(ReturnOrderActivity.this);
        dialog.setContentView(R.layout.dialog_return_order);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnCanCelReturn = dialog.findViewById(R.id.btnCancelReturn);
        btnCanCelReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnConfirmReturn = dialog.findViewById(R.id.btnConfirmReturn);
        btnConfirmReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogSendedRequest();
            }
        });
        dialog.show();
    }

    private void createDialogSendedRequest(){
        Dialog dialog1 = new Dialog(ReturnOrderActivity.this);
        dialog1.setContentView(R.layout.dialog_sended_request);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnBackHome = dialog1.findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReturnOrderActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        dialog1.show();
    }

    @SuppressLint("MissingInflatedId")
    private void createUploadImageDialog(){
        sheetDialogImageResource = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_upload_image_return, null);

        sheetDialogImageResource.setContentView(view);
        sheetDialogImageResource.setCancelable(false);
        sheetDialogImageResource.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnOpenCamera = view.findViewById(R.id.btnOpenCameraReturn);
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCamera = true;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                launcherImage.launch(intent);
                sheetDialogImageResource.dismiss();
            }
        });

        btnOpenLibrary = view.findViewById(R.id.btnOpenLibraryReturn);
        btnOpenLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCamera = false;
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                launcherImage.launch(intent);
                sheetDialogImageResource.dismiss();
            }
        });

        toolbarImageResource = view.findViewById(R.id.toolbarImageResourceReturn);
        toolbarImageResource.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.menuCancel){
                    sheetDialogImageResource.dismiss();
                }
                return false;
            }
        });
    }
}