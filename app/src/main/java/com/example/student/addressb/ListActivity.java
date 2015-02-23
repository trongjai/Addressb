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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView;

/// show info

public class ListActivity extends ActionBarActivity  implements AdapterView.OnItemLongClickListener {
        AddDBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        createContactList();

    }

    public void createContactList()
    {
        helper = new AddDBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, name, mobile FROM info",null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, // A textview simple_list_item_2
                cursor, // cursor to a data collection
                new String[] {"name","mobile"}, // column to be displayed
                new int[] {android.R.id.text1,android.R.id.text2}, // ID of textview to display
                0);

        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity, menu);




        return true;
    }

    public void add_clicked(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 88);
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {

                String strname = data.getStringExtra("name");
                String strlast = data.getStringExtra("last");
                String strdob = data.getStringExtra("dob");
                String strmobile = data.getStringExtra("mobile");
                String strhome = data.getStringExtra("home");
                String stremail = data.getStringExtra("email");

                System.out.println("name = " + strname);

                helper = new AddDBHelper(this);

                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues r = new ContentValues();
                r.put("name", strname);
                r.put("last", strlast);
                r.put("dob", strdob);
                r.put("mobile", strmobile);
                r.put("home", strhome);
                r.put("email", stremail);


                long new_id = db.insert("info", null, r);
                System.out.println("new id = " + new_id);


                createContactList();
            }
        }

        Log.d("info", "onActivityResult");
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

    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                   int position, long id) {

        SQLiteDatabase db = helper.getWritableDatabase();

        int n = db.delete("course",
                "_id = ?",
                new String[]{Long.toString(id)});

        if (n == 1) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Successfully deleted the selected item.",
                    Toast.LENGTH_SHORT);
            t.show();

            // retrieve a new collection of records
            Cursor cursor = db.rawQuery("SELECT _id, code, grade||' ('||credit||' credit)' g FROM course",null);

            // update the adapter
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2, // A textview
                    cursor, // cursor to a data collection
                    new String[] {"code","g"}, // column to be displayed
                    new int[] {android.R.id.text1,android.R.id.text2}, // ID of textview to display
                    0);

            adapter.changeCursor(cursor);
            ListView lv = (ListView)findViewById(R.id.listView);
            lv.setAdapter(adapter);

        }
        db.close();
        return true;
    }

}
