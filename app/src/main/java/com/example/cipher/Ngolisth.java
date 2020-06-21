package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ngolisth extends AppCompatActivity {
    ListView li;
    String schemes[]={"सेवा ","स्नेहालय","नॉर्थ ईस्ट नेटवर्क","आजाद फाउंडेशन","सीआरईए","सेंटर फॉर सोशल रिसर्च (सीएसआर)","विमोचना ","स्वेती"," महिला किसान अधिष्ठाता मंच"," जनोदय"};
    String url[]={"https://en.wikipedia.org/wiki/Self_Employed_Women%27s_Association","https://www.snehalaya.org/about","http://northeastnetwork.org/","https://hindi.indiawaterportal.org/content/ajaada-indaiyaa-phaaundaesana/org/44900","http://www.creaworld.org/who-we-are/about-us","https://www.jagran.com/uttar-pradesh/varanasi-city-kashi-daughter-dr-ranjana-famous-in-world-19275943.html","http://www.indiatogether.org/manushi/issue110/vimochana.htm","http://www.swaniti.com/our-work/","http://makaam.in/about/","http://janodaya.org/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngolisth);


        li=findViewById(R.id.li);
        ArrayAdapter<String> arr;
        arr=new ArrayAdapter<String>(Ngolisth.this,R.layout.support_simple_spinner_dropdown_item,schemes);
        li.setAdapter(arr);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str1=schemes[position];
                String str2=url[position];
                Intent obj3=new Intent(Ngolisth.this,ngowebh.class);
                obj3.putExtra("key_url2h",str2);
                obj3.putExtra("key_scheme1",str1);
                startActivity(obj3);


            }
        });

    }
}
