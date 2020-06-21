package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Fh extends AppCompatActivity {
    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);b=findViewById(R.id.button);
        e=findViewById(R.id.editText);
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String j=e.getText().toString();
                Intent obj=new Intent(Intent.ACTION_CALL);
                obj.setData(Uri.parse("tel:"+j));
                startActivity(obj);
            }
        });
    }
}
