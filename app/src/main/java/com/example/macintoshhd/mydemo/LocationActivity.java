package com.example.macintoshhd.mydemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mLongitude, mLatitude;
    private Button mTrackLocation;
    private LocationManager locationManager;
    private NotificationLocationListener locationListener;
    private static final int PEEMISSION_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mLongitude = findViewById(R.id.etLongitude);
        mLatitude = findViewById(R.id.etLatitude);

        mTrackLocation = findViewById(R.id.btnTrackLocation);
        mTrackLocation.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationListener = new NotificationLocationListener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "Permission is denied", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, PEEMISSION_CODE);
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,1, locationListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        locationManager.removeUpdates(locationListener);
    }

    class NotificationLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            mLatitude.setText("" + location.getLatitude());
            mLongitude.setText("" + location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
