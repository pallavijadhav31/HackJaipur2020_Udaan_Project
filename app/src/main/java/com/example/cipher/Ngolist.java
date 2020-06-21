package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ngolist extends AppCompatActivity {
    String schemes[]={"SEWA","Snehalaya","North east network","Azad Foundation","CREA","Centre for reaseach","Vimochan","Swaniti"," Mahila Kissan Adhikar Manch ","Janodaya"};
    String url[]={"http://www.sewa.org/","https://www.snehalaya.org/","http://northeastnetwork.org/","http://azadfoundation.com/","http://www.creaworld.org/who-we-are/about-us","https://www.csrindia.org/","http://www.indiatogether.org/manushi/issue110/vimochana.htm","http://www.swaniti.com/our-work/","http://makaam.in/","http://janodaya.org/"};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngolist);

        list=findViewById(R.id.list2);
        ArrayAdapter<String> arr;
        arr=new ArrayAdapter<String>(Ngolist.this,R.layout.support_simple_spinner_dropdown_item,schemes);
        list.setAdapter(arr);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str1=schemes[position];
                String str2=url[position];
                Intent obj3=new Intent(Ngolist.this,ngoweb.class);
                obj3.putExtra("key_url2",str2);
                obj3.putExtra("key_scheme1",str1);
                startActivity(obj3);
            }
        });

    }
}
