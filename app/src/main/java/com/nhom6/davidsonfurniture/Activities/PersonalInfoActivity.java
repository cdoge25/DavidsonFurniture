package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
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
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom6.davidsonfurniture.Adapters.SexAdapter;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.Utils.SexDataUtils;
import com.nhom6.davidsonfurniture.databinding.ActivityPersonalInfoBinding;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonalInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityPersonalInfoBinding binding;
    Spinner spinner;

//    private Spinner spinnerSex;
    private EditText edtTextDate;
    private ImageButton btnDate;
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
        goback();
        //DatePickerDialog
        this.edtTextDate = (EditText) this.findViewById(R.id.edt_TextDateOfBirth);
        this.btnDate = (ImageButton) this.findViewById(R.id.btn_DateOfBirth);
        
        this.btnDate.setOnClickListener(new View.OnClickListener() {
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
        

//        this.spinnerSex = (Spinner) findViewById(R.id.spinner_sex);
//
//        SexAdapter[] sexs = SexDataUtils.getSexs();
//
//        ArrayAdapter<SexAdapter> adapter = new ArrayAdapter<SexAdapter>(this, android.R.layout.simple_spinner_item, sexs);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        this.spinnerSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                onItemSelectedHandler(adapterView, view, i, l);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
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
                edtTextDate.setText(dayOfMonth + "/" + (month +1 ) + "/" + year);

                lastSelectedYear = year;
                lastSelectedMonth = month;
                lastSelectedDayOfMonth = dayOfMonth;
            }
        };

        DatePickerDialog datePickerDialog = null;
        datePickerDialog = new DatePickerDialog(this, dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
        datePickerDialog.show();
    }

    //Show


//    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int i, long l) {
//        Adapter adapter = adapterView.getAdapter();
//        SexAdapter sex = (SexAdapter) adapter.getItem(i);
//
//        Toast.makeText(getApplicationContext(), "Giới tính: " + sex.getSex(), Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Giới tính: " + item, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}