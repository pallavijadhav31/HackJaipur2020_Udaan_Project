package com.example.cipher;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Homeh extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button b1, b2, b3, b4, b5, b6, b7, b8;
    Double latitude = 0.0;
    Double longitude = 0.0;
    Location gps_loc = null, network_loc=null, final_loc=null;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private final long MIN_TIME = 1000;// 1 second
    private final long MIN_DIST = 0; // meters
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeh);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button11);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);

        b6 = findViewById(R.id.button11);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},PackageManager.PERMISSION_GRANTED);

        //locationtxt=findViewById(R.id.locationtxt);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"not granted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Granted",Toast.LENGTH_SHORT).show();
        }
        try{
            gps_loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            network_loc=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(gps_loc != null){
            final_loc=gps_loc;
            latitude=final_loc.getLatitude();
            longitude=final_loc.getLongitude();
        }
        else if(network_loc != null){
            final_loc=network_loc;
            latitude=final_loc.getLatitude();
            longitude=final_loc.getLongitude();
        }
        else{
            latitude=0.0;
            longitude=0.0;
        }

        try{
            Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());
            final List<Address> addresses=geocoder.getFromLocation(latitude,longitude,1);
            if(addresses!=null && addresses.size()>0) {
                final String address = addresses.get(0).getAddressLine(0);
                final String city = addresses.get(0).getLocality();
                final String state = addresses.get(0).getAdminArea();
                final String country = addresses.get(0).getCountryName();
                final String postal_code = addresses.get(0).getPostalCode();
                final String Namu = addresses.get(0).getFeatureName();
                final Double la = addresses.get(0).getLatitude();
                final Double lo = addresses.get(0).getLongitude();


                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String p1 ="7611913206";
                        String message = "Current address =" +address+"\n" +
                                "City = " +city+"\n" +
                                "State =" +state+"\n" +
                                "Country =" +country+"\n" +
                                "Postal code=" +postal_code+"\n" +
                                "House no.=" +Namu +
                                "\n" + "longitude = " + lo +
                                "\n" + "latitude = " + la;
                        Toast.makeText(Homeh.this, "भेजा गया नंबर यू पंजीकृत है", Toast.LENGTH_LONG).show();
                       /* Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.putExtra("address", p1);
                        sendIntent.putExtra("sms_body", message );
                        sendIntent.setType("vnd.android-dir/mms-sms");
                        startActivity(sendIntent);*/
                        SmsManager smsManager = SmsManager.getDefault();
                        ArrayList<String> msg=smsManager.divideMessage(message);
                        smsManager.sendMultipartTextMessage(p1,null,msg,null,null);
                    }
                });
            }
        }

        catch (Exception e){
            e.printStackTrace();

        }
        b6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent o = new Intent(Intent.ACTION_CALL);
                o.setData(Uri.parse("tel:108"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(o);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Homeh.this,Financeh.class);
                startActivity(obj);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Homeh.this,helthcareh.class);
                startActivity(obj);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Homeh.this,Cmplnh.class);
                startActivity(obj);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Homeh.this,Ngolisth.class);
                startActivity(obj);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Homeh.this,contacth.class);
                startActivity(obj);
            }
        });
    }
}