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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.Models.CompletedOrder;
import com.nhom6.davidsonfurniture.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReviewActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> launcherImage;

    TextView txtReviewName,txtReviewType, txtReviewColor;
    ImageView imvReviewThumb, imvReviewPhoto;
    Button btnUploadReview, btnBackToPlacedOrder, btnAddImageReview, btnOpenCamera, btnOpenLibrary;
    Toolbar toolbarReview, toolbarImageResource;
    RatingBar rtbReviewRating;
    EditText edtReview;

    BottomSheetDialog sheetDialogImageResource;

    boolean isCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

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
        addEvents();
        createUploadImageDialog();

//        launcherImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
//            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
//                imvReviewPhoto.setImageBitmap(bitmap);
//            }
//        });

        launcherImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (isCamera && result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                    imvReviewPhoto.setImageBitmap(bitmap);
                } else {
                    Uri uri = result.getData().getData();
                    if (uri != null) {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imvReviewPhoto.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void goBack() {
        toolbarReview.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void linkViews() {
        toolbarReview = findViewById(R.id.toolbarReview);

        btnUploadReview = findViewById(R.id.btnUploadReview);
        btnAddImageReview = findViewById(R.id.btnAddImageReview);

        imvReviewPhoto = findViewById(R.id.imvReviewPhoto);
        imvReviewThumb = findViewById(R.id.imvReviewThumb);
        txtReviewName = findViewById(R.id.txtReviewName);
        txtReviewType = findViewById(R.id.txtReviewType);
        txtReviewColor = findViewById(R.id.txtReviewColor);

        rtbReviewRating = findViewById(R.id.rtbReviewRating);
        edtReview = findViewById(R.id.edtReview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //nhận dữ liệu
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CompletedOrder completedOrder = (CompletedOrder) bundle.get("object_completed");

            imvReviewThumb.setImageResource(completedOrder.getCompletedThumb());
            txtReviewName.setText(completedOrder.getCompletedName());
            txtReviewType.setText(completedOrder.getCompletedType());
            txtReviewColor.setText(completedOrder.getCompletedColor());
        }
    }

    private void addEvents(){
        btnUploadReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double rating = rtbReviewRating.getRating();
                String review = edtReview.getText().toString();
                review = review.replace(" ", "");
                BitmapDrawable image = (BitmapDrawable) imvReviewPhoto.getDrawable();

                if(review != "" && image != null){
                    openDialogUploadedReview();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đánh giá và đăng tải hình ảnh", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btnAddImageReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialogImageResource.show();
            }
        });
    }

    private void openDialogUploadedReview(){
        Dialog dialog = new Dialog(ReviewActivity.this);
        dialog.setContentView(R.layout.dialog_uploaded_review);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnBackToPlacedOrder = dialog.findViewById(R.id.btnBackToPlacedOrder);
        btnBackToPlacedOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this, OrderStatusActivity.class);
                startActivity(intent);
                //đổ dữ liệu sang màn hình đánh giá và xóa data bên này
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @SuppressLint("MissingInflatedId")
    private void createUploadImageDialog(){
        sheetDialogImageResource = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_upload_image_review, null);

        sheetDialogImageResource.setContentView(view);
        sheetDialogImageResource.setCancelable(false);
        sheetDialogImageResource.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnOpenCamera = view.findViewById(R.id.btnOpenCamera);
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCamera = true;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                launcherImage.launch(intent);
                sheetDialogImageResource.dismiss();
            }
        });

        btnOpenLibrary = view.findViewById(R.id.btnOpenLibrary);
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

        toolbarImageResource = view.findViewById(R.id.toolbarImageResource);
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