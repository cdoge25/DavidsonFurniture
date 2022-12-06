package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityChangeAddress2Binding;

public class ChangeAddressActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private ActivityChangeAddress2Binding binding;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_address2);

        binding = ActivityChangeAddress2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        toMapsActivity();
        addEvent();
        goBack();
    }

    private void addEvent() {
        binding.btnConfirmLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ChangeAddressActivity2.this);
                dialog.setContentView(R.layout.dialog_update_success);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);

                Button btnClose = dialog.findViewById(R.id.btn_Close);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog.show();
            }
        });

        binding.btnDeleteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ChangeAddressActivity2.this);
                dialog.setContentView(R.layout.dialog_delete_address);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btnCanCelLogout = dialog.findViewById(R.id.btn_CancelDel);
                btnCanCelLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button btnConfirmLogout = dialog.findViewById(R.id.btn_ConfirmDel);
                btnConfirmLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog = new Dialog(ChangeAddressActivity2.this);
                        dialog.setContentView(R.layout.dialog_update_success);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.setCancelable(false);

                        Button btnClose = dialog.findViewById(R.id.btn_Close);
                        btnClose.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });
                        dialog.show();
                    }
                });
                dialog.show();
            }
        });
    }

    private void toMapsActivity() {
        binding.edtChooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeAddressActivity2.this,MapsActivity.class );
                startActivity(intent);
            }
        });
    }

    private void goBack() {
        binding.toolbarChangeAddress2.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        //Lấy vị trí hiện tại
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


        //Bật nút Zoomout/Zoomin
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in UEL and move the camera
        LatLng UEL = new LatLng(10.871880365649952, 106.7783411306927);
        mMap.addMarker(new MarkerOptions().position(UEL).title("Trường ĐH Kinh tế - Luật"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UEL));

        //Phóng to bản đồ
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UEL, 15));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}