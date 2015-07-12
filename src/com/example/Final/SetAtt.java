package com.example.Final;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by e11438 on 7/11/2015.
 */
public class SetAtt extends Activity{
	public static String ds="";
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button b= (Button) findViewById(R.id.button_submit);
        Button b_exit= (Button) findViewById(R.id.btn_exit);


        SharedPreferences settings1 = getSharedPreferences("myPref", 0);

        final EditText et_pass= (EditText) findViewById(R.id.et_pass2);
        final EditText et_number= (EditText) findViewById(R.id.et_number);
        final EditText et_code= (EditText) findViewById(R.id.et_code);

        et_pass.setText(settings1.getString("pass", ""));
        et_number.setText(settings1.getString("number", ""));
        et_code.setText(settings1.getString("code", ""));
       // public String gd = "";

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     String pass=et_pass.getText().toString();
                                     String number=et_number.getText().toString();
                                     String code=et_code.getText().toString();
ds=code;
                                     SharedPreferences settings = getSharedPreferences("myPref", 0);
                                     SharedPreferences.Editor editor = settings.edit();
                                     editor.putString("pass",pass);
                                     editor.putString("number",number);
                                     editor.putString("code",code);
                                     editor.commit();
                                     
                                    /* Intent i= new Intent(SetAtt.this,SmsReceiver.class); 
                                     Bundle b = new Bundle();
                                     //b.putString("code",cod                                     i.putExtra("code",code);
//                                     startService(i);
                                     sendBroadcast(i);*/
                                     
                                     finish();
                                 }
                             }

        );

        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}
