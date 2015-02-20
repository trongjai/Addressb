package com.example.student.addressb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    public void addClicked(View v) {
        EditText etname = (EditText)findViewById(R.id.name);
        EditText etlastname = (EditText)findViewById(R.id.lastname);
        EditText etdob = (EditText)findViewById(R.id.dob);
        EditText etmobile = (EditText)findViewById(R.id.mobile);
        EditText ethome = (EditText)findViewById(R.id.home);
        EditText etemail = (EditText)findViewById(R.id.email);

        String sName = etname.getText().toString();
        String sLast = etlastname.getText().toString();
        String sDob = etdob.getText().toString();
        String sMobile = etmobile.getText().toString();
        String sHome = ethome.getText().toString();
        String sEmail = etemail.getText().toString();

        Intent result = new Intent();

        result.putExtra("name", sName);
        result.putExtra("last", sLast);
        result.putExtra("dob", sDob);
        result.putExtra("mobile", sMobile);
        result.putExtra("home", sHome);
        result.putExtra("email", sEmail);

        this.setResult(RESULT_OK, result);
        this.finish();



        Toast t = Toast.makeText(this.getApplicationContext(),
                "Both course code and credit are necessary.",
                Toast.LENGTH_SHORT);
        t.show();

    }






}
