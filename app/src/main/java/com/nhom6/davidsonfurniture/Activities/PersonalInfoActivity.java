package com.nhom6.davidsonfurniture.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.Adapters.SexAdapter;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.Utils.SexDataUtils;
import com.nhom6.davidsonfurniture.databinding.ActivityPersonalInfoBinding;
import com.nhom6.davidsonfurniture.databinding.ActivitySettingAccountBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonalInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityPersonalInfoBinding binding;
    Spinner spinner;
    ActivityResultLauncher<Intent> launcherImage;
    ImageButton btnUploadPhoto;
    Button  btnOpenCamera, btnOpenLibrary;
    BottomSheetDialog sheetDialogImageResource;
    ImageView imvAvatar;
    Toolbar toolbarImageResource;

    boolean isCamera;

    private TextView txtDateOfBirth;
    private LinearLayout llChooseDateOfBirth;
    private int lastSelectedYear;
    private int lastSelectedMonth;
    private int lastSelectedDayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        //hide status and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityPersonalInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        uploadPhoto();
        createUploadImageDialog();
        spinerSex();
        datePickerDialog();
        toChangeName();
        goback();

        imvAvatar = findViewById(R.id.imv_Avatar) ;

        launcherImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (isCamera && result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                    imvAvatar.setImageBitmap(bitmap);
                } else {
                    Uri uri = result.getData().getData();
                    if (uri != null) {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imvAvatar.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void createUploadImageDialog() {
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

    private void uploadPhoto() {
        btnUploadPhoto = findViewById(R.id.btn_uploadPhoto);
        btnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetDialogImageResource.show();

            }
        });

    }

    private void toChangeName() {
        binding.llChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalInfoActivity.this, ChangeNameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void datePickerDialog() {
        //DatePickerDialog
        this.txtDateOfBirth = (TextView) this.findViewById(R.id.txt_DateOfBirth);
        this.llChooseDateOfBirth = (LinearLayout) this.findViewById(R.id.ll_ChooseDayOfBirth);

        this.llChooseDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelectDate();
            }
        });

        //Get Current Date
        final Calendar c = Calendar.getInstance();
        this.lastSelectedYear = c.get(Calendar.YEAR);
        this.lastSelectedMonth = c.get(Calendar.MONTH);
        this.lastSelectedDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
    }

    private void spinerSex() {
        //Spinner
        spinner = (Spinner) findViewById(R.id.spinner_sex);
        spinner.setOnItemSelectedListener(this);

        ArrayList<String> sexs = new ArrayList<String>();
        sexs.add("Nam");
        sexs.add("Nữ");
        sexs.add("Khác");

        //Tạo adapter
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexs);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);


    }

    private void goback() {
        binding.toolbarPersonalInfo.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //User click on Button
    private void buttonSelectDate() {
        //Date Select Listener
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtDateOfBirth.setText(dayOfMonth + "/" + (month +1 ) + "/" + year);

                lastSelectedYear = year;
                lastSelectedMonth = month;
                lastSelectedDayOfMonth = dayOfMonth;
            }
        };

        DatePickerDialog datePickerDialog = null;
        datePickerDialog = new DatePickerDialog(this, dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String item = parent.getItemAtPosition(position).toString();
////        TextView txtSex = (TextView) findViewById(R.id.txt_Sex);
////        txtSex.setText(item);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}