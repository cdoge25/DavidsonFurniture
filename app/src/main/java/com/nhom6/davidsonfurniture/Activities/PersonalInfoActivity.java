package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom6.davidsonfurniture.Adapters.SexAdapter;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.Utils.SexDataUtils;

public class PersonalInfoActivity extends AppCompatActivity {

    private Spinner spinnerSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        this.spinnerSex = (Spinner) findViewById(R.id.spinner_sex);

        SexAdapter[] sexs = SexDataUtils.getSexs();

        ArrayAdapter<SexAdapter> adapter = new ArrayAdapter<SexAdapter>(this, android.R.layout.simple_spinner_item, sexs);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinnerSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onItemSelectedHandler(adapterView, view, i, l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int i, long l) {
        Adapter adapter = adapterView.getAdapter();
        SexAdapter sex = (SexAdapter) adapter.getItem(i);

        Toast.makeText(getApplicationContext(), "Giới tính: " + sex.getSex(), Toast.LENGTH_SHORT).show();
    }
}