package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListfoDivision extends AppCompatActivity {

    String[] st = { "Dhaka", "Chittagong", "Sylhet", "Rongpur", "Barisal", "Mymensingh", "Khulna", "Rajshahi" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfo_division);
        ListView l1=(ListView)findViewById(R.id.l1);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,st);
        l1.setAdapter(ad);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                Toast.makeText(ListfoDivision.this.getApplicationContext(), ListfoDivision.this.st[paramAnonymousInt] + "\tYou cliked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListfoDivision.this.getApplicationContext(), BDE_Name.class);
                startActivity(i);
            }
        });
    }
}
