package com.example.admin.report_cc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


        SQLiteOpenHelper openHelper;
        SQLiteDatabase db;
        Button _btnreg, _btnlogin;
        EditText _txtfname, _txtlname, _txtpass, _txtemail, _txtphone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            openHelper = new DatabaseHelper(this);

            _btnreg = (Button) findViewById(R.id.btnReg);
            _txtfname = (EditText) findViewById(R.id.txtfname);
            _txtlname = (EditText) findViewById(R.id.txtlname);
            _txtpass = (EditText) findViewById(R.id.txtPassword);
            _txtemail = (EditText) findViewById(R.id.txtemail);
            _txtphone = (EditText) findViewById(R.id.txtphone);
            _btnlogin = (Button) findViewById(R.id.btnlogin);

            _btnreg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = openHelper.getWritableDatabase();
                    String fname = _txtfname.getText().toString();
                    String lname = _txtlname.getText().toString();
                    String pass = _txtpass.getText().toString();
                    String email = _txtemail.getText().toString();
                    String phone = _txtphone.getText().toString();
                    insertdata(fname, lname, pass, email,phone);
                    Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();

                }
            });
            _btnlogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Main2Activity.this, Login.class);
                    startActivity(intent);
                }
            });

        }

    public void insertdata (String fname, String lname, String pass, String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, pass);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}

