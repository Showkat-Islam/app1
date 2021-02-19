package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity
        extends Activity {
    Button btnCreateAccount;
    EditText editTextConfirmPassword;
    EditText editTextPassword;
    EditText editTextUserName;
    LoginActivity loginDataBaseAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        this.loginDataBaseAdapter = new LoginActivity(this);
        this.loginDataBaseAdapter = this.loginDataBaseAdapter.open();

        this.editTextUserName = ((EditText) findViewById(R.id.e1));
        this.editTextPassword = ((EditText) findViewById(R.id.e2));
        this.editTextConfirmPassword = ((EditText) findViewById(R.id.e3));
        this.btnCreateAccount = ((Button) findViewById(R.id.b1));
        this.btnCreateAccount.setOnClickListener(new OnClickListener() {
            @Override


        public void onClick(View v) {
                String str1 = SignUPActivity.this.editTextUserName.getText().toString();
               String str2 = SignUPActivity.this.editTextPassword.getText().toString();
                String str3 = SignUPActivity.this.editTextConfirmPassword.getText().toString();
               if ((v.equals("")) || (str2.equals("")) || (str3.equals("")))
                {
                    Toast.makeText(SignUPActivity.this.getApplicationContext(), "Field Vaccant", Toast.LENGTH_SHORT).show();
                    return;
               }if (!str1.equals(str2))
               {                    Toast.makeText(SignUPActivity.this.getApplicationContext(), "Password does not match",Toast.LENGTH_SHORT).show();
                   return;
               }
                SignUPActivity.this.loginDataBaseAdapter.insertEntry(str1,str2);
               Toast.makeText(SignUPActivity.this.getApplicationContext(), "Account Successfully Created ",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
           }
       });
    }








    protected void onDestroy() {
        super.onDestroy();
        this.loginDataBaseAdapter.close();
    }
}
