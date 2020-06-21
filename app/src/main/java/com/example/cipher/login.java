package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private static final String KEY_USER = "P";
    private static final String KEY_PASS = "J";
    EditText u,p;
    Button b1;
    TextView t;
    Appdb obj2;
    SharedPreferences sp;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button3);
        u = findViewById(R.id.editText);
        p = findViewById(R.id.editText2);
        t = findViewById(R.id.textView6);
        String user = u.getText().toString();
        String pass = p.getText().toString();
        sp=getSharedPreferences("dvs1", Context.MODE_PRIVATE);
        obj2 = new Appdb(login.this);
        t.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ne = new Intent(login.this, Register.class);
                startActivity(ne);
            }
        });
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String user = u.getText().toString();
                    String pass = p.getText().toString();
                    if (user.equals("") || pass.equals("")) {
                        Toast.makeText(login.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                    }else {
                        User ur = new User(login.this);
                        ur.setUser(user);
                        ur.setPass(pass);
                        Cursor cursor = obj2.user_login(user);
                        cursor.moveToFirst();
                        String password = cursor.getString(3);
                        if (password.equals(pass)) {
                            Toast.makeText(login.this, "..........", Toast.LENGTH_LONG).show();
                            if(savedInstanceState!=null){
                                String savedUser=savedInstanceState.getString(KEY_USER);
                                u.setText(savedUser);

                                String savedpass=savedInstanceState.getString(KEY_PASS);
                                p.setText(savedpass);
                            }

                            Intent obj = new Intent(login.this, Home.class);
                            startActivity(obj);
                            cln();
                        } else {
                            cln();
                            Toast.makeText(login.this, "Invalid user..", Toast.LENGTH_LONG).show();
                        }
                    }
                }catch (Exception t){
                    cln();
                    Toast.makeText(login.this, "Invalid user", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void cln(){
        u.setText(null);
        u.requestFocus();
        p.setText(null);
    }
    public void onSavedInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString(KEY_USER, u.getText().toString());
        savedInstanceState.putString(KEY_PASS, p.getText().toString());
    }
}
