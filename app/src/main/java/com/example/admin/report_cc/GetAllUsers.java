package com.example.admin.report_cc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GetAllUsers extends AppCompatActivity {



        private ListView listView;

        private ArrayList<UserModel> userModelArrayList;

        private StudentAdapter studentAdapter;

        private DatabaseHelper databaseHelper;



        @Override

        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_get_all_users);



            listView = (ListView) findViewById(R.id.lv);



            databaseHelper = new DatabaseHelper(this);



            userModelArrayList = databaseHelper.getAllUsers();



            studentAdapter = new StudentAdapter(this,userModelArrayList);

            listView.setAdapter((ListAdapter) studentAdapter);



            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(GetAllUsers.this, Update.class);

                    intent.putExtra("user", userModelArrayList.get(position));

                    startActivity(intent);

                }

            });



        }

    }

