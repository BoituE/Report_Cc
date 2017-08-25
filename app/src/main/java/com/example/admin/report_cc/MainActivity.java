package com.example.admin.report_cc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGetall;

    private EditText etname, etgrade, etmarks;

    private DatabaseHelper databaseHelper;
    private EditText etsubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);



        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);
        etgrade = (EditText) findViewById(R.id.etgrade);
        etmarks = (EditText) findViewById(R.id.etmarks);
        etsubject = (EditText) findViewById(R.id.etsubject);



        btnStore.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                databaseHelper.addUser(etname.getText().toString(), etgrade.getText().toString(), etmarks.getText().toString(),etsubject.getText().toString());
                etname.setText("");
                etgrade.setText("");
                etmarks.setText("");
                etsubject.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();

            }

        });



        btnGetall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, GetAllUsers.class);
                startActivity(intent);

            }

        });



    }

}


