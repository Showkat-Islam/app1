package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    public Button btnSignIn;
    public Button btnSignUp;
    public LoginActivity loginDataBaseAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDataBaseAdapter = new LoginActivity(this);
        loginDataBaseAdapter = this.loginDataBaseAdapter.open();
        btnSignIn = findViewById(R.id.b1);
        btnSignUp = findViewById(R.id.b2);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View m) {
                Intent i=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(i);
                //paramAnonymousView = new View(MainActivity.this.getApplicationContext(), SignUPActivity.class);
                //MainActivity.this.startActivity(paramAnonymousView);
            }
        });
    }



    protected void onDestroy() {
        super.onDestroy();
        this.loginDataBaseAdapter.close();
    }

    public void signIn(View p) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_main);
        dialog.setTitle("Login");
        //paramView = new View(this);
        //paramView.setContentView(2130968621);
        //paramView.setTitle("Login");
        //final EditText localEditText1 = (EditText) paramView.findViewById(R.id.e1);
       // final EditText localEditText2 = (EditText) paramView.findViewById(R.id.e2);
       final EditText ed1=(EditText)findViewById(R.id.e2);
       final EditText ed2 = (EditText)findViewById(R.id.e1);
        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String st1= ed1.getText().toString();
                if (ed2.equals(MainActivity.this.loginDataBaseAdapter.getSinlgeEntry((Cursor) v))) {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(getApplicationContext(), ListfoDivision.class);
                    startActivity(i);
                    return;
                }
                Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }


}
