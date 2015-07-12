package com.example.Final;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button b= (Button) findViewById(R.id.button);
        final TextView tv = (TextView) findViewById(R.id.debug);
        final EditText et = (EditText) findViewById(R.id.et_pass1);


        SharedPreferences settings = getSharedPreferences("myPref", 0);
         String pass = settings.getString("pass", "");
         String number = settings.getString("number", "");
         String code = settings.getString("code", "");


            final String myPass=pass;

        tv.setText(pass+" "+number+" "+code);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et.getText().toString().equals(myPass)) {
                    startActivity(new Intent(MyActivity.this, SetAtt.class));
                    finish();
                }else{
                    tv.setText("Your password is Wrong");
                }

            }
        });


    }
}
