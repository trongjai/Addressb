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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

       /* Intent i = this.getIntent();

        String name = i.getStringExtra("name");
        String lastname = i.getStringExtra("lastname");
        String dob = i.getStringExtra("dob");
        String mobile = i.getStringExtra("mobile");
        String home = i.getStringExtra("home");
        String email = i.getStringExtra("email");*/

        //String sCode = etCode.getText().toString();

        EditText etname = (EditText)findViewById(R.id.name);
        String sName = etname.getText().toString();

        EditText etlastname = (EditText)findViewById(R.id.lastname);
        String sLast = etlastname.getText().toString();

        EditText etdob = (EditText)findViewById(R.id.dob);
        String sDob = etdob.getText().toString();

        EditText etmobile = (EditText)findViewById(R.id.mobile);
        String sMobile = etmobile.getText().toString();

        EditText ethome = (EditText)findViewById(R.id.home);
        String sHome = ethome.getText().toString();

        EditText etemail = (EditText)findViewById(R.id.email);
        String sEmail = etemail.getText().toString();



            Button btAdd = (Button)findViewById(R.id.btAdd);
            Button btShow = (Button)findViewById(R.id.btShow);

    }

    public void addClicked(View v) {
        EditText etCode = (EditText)findViewById(R.id.etCode);
        EditText etCR = (EditText)findViewById(R.id.etCR);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rgGrade);

        String sCode = etCode.getText().toString();
        String sCR = etCR.getText().toString();

        if (sCode.trim().length() == 0 || sCR.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Both course code and credit are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("code", sCode);
            result.putExtra("credit", Integer.valueOf(sCR));
            int rID = rg.getCheckedRadioButtonId();
            String grade = ((RadioButton)findViewById(rID)).getText().toString();
            result.putExtra("grade", grade);
            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
