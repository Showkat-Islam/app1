package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BDE_Name extends AppCompatActivity {


    String[] st = {"BDE-1", "BDE-2", "BDE-3", "BDE-4", "BDE-5", "BDE-6", "BDE-7", "BDE-8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfo_division);
        ListView l1 = (ListView) findViewById(R.id.l1);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, st);
        l1.setAdapter(ad);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                Toast.makeText(getApplicationContext(), BDE_Name.this.st[paramAnonymousInt] + "\tYou cliked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(BDE_Name.this.getApplicationContext(), Unit_Name.class);
                startActivity(i);
            }
        });
    }
}