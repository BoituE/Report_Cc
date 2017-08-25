package com.example.admin.report_cc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    private UserModel userModel;

    private EditText etname, ethobby, etcity;

    private Button btnupdate, btndelete;

    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



            Intent intent = getIntent();

            userModel = (UserModel) intent.getSerializableExtra("user");



            databaseHelper = new DatabaseHelper(this);



            etname = (EditText) findViewById(R.id.etname);

            ethobby = (EditText) findViewById(R.id.ethobby);

            etcity = (EditText) findViewById(R.id.etcity);

            btndelete = (Button) findViewById(R.id.btndelete);

            btnupdate = (Button) findViewById(R.id.btnupdate);



            etname.setText(userModel.getName());

            ethobby.setText(userModel.getHobby());

            etcity.setText(userModel.getCity());



            btnupdate.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    databaseHelper.updateUser(userModel.getId(),etname.getText().toString(),ethobby.
                            getText().toString(),etcity.getText().toString());

                    Toast.makeText(Update.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Update.this,MainActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }

            });



            btndelete.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    databaseHelper.deleteUSer(userModel.getId());

                    Toast.makeText(Update.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Update.this,MainActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }

            });



        }



}




