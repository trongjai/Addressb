package com.example.student.addressb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

////// add info

public class MainActivity extends ActionBarActivity {
 AddDBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
    }


    public void addClicked(View v) {

        EditText name = (EditText) findViewById(R.id.name);
        EditText lastname = (EditText) findViewById(R.id.lastname);
        EditText dob = (EditText) findViewById(R.id.dob);
        EditText mobile = (EditText) findViewById(R.id.mobile);
        EditText home = (EditText) findViewById(R.id.home);
        EditText email = (EditText) findViewById(R.id.email);

        String sName = name.getText().toString();
        String sLast = lastname.getText().toString();
        String sDob = dob.getText().toString();
        String sMobile = mobile.getText().toString();
        String sHome = home.getText().toString();
        String sEmail = email.getText().toString();


        if (sName.trim().length() == 0 || sLast.trim().length() == 0 || sDob.trim().length() == 0 ||
                sMobile.trim().length() == 0 || sHome.trim().length() == 0 || sEmail.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Please add all data.",
                    Toast.LENGTH_SHORT);
            t.show();
        } else {
            Intent result = new Intent();
            result.putExtra("name", sName);
            result.putExtra("last", sLast);
            result.putExtra("dob", sDob);
            result.putExtra("mobile", sMobile);
            result.putExtra("home", sHome);
            result.putExtra("email", sEmail);

            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }

    public void buttonClicked(View v) {



                Intent i = new Intent(this, ListActivity.class);
                startActivityForResult(i,88);


        }


    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 88) {
//            if (resultCode == RESULT_OK) {
//
//                String strname = data.getStringExtra("name");
//                String strlast = data.getStringExtra("last");
//                String strdob = data.getStringExtra("dob");
//                String strmobile = data.getStringExtra("mobile");
//                String strhome = data.getStringExtra("home");
//                String stremail = data.getStringExtra("email");
//
//            System.out.println(strname);
//
//                helper = new AddDBHelper(this);
//
//                SQLiteDatabase db = helper.getWritableDatabase();
//                ContentValues r = new ContentValues();
//                r.put("name", strname);
//                r.put("last", strlast);
//                r.put("dob", strdob);
//                r.put("mobile", strmobile);
//                r.put("home", strhome);
//                r.put("email", stremail);
//
//
//                long new_id = db.insert("info", null, r);
//                System.out.println(new_id);
//            }
//        }
//
//        Log.d("info", "onActivityResult");
//    }


//        Toast t = Toast.makeText(this.getApplicationContext(),
//                "Information already added.",
//                Toast.LENGTH_SHORT);





