package com.example.sampleapk;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserTab extends AppCompatActivity {

    EditText nameET, contactET, emailET;
    Button addUserBtn;

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nameET = (EditText)findViewById(R.id.nameET);
        contactET = (EditText)findViewById(R.id.contactET);
        emailET = (EditText)findViewById(R.id.emailET);
        addUserBtn = (Button)findViewById(R.id.addUserBtn);

        mydb = new DBHelper(this);

        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String contact = contactET.getText().toString();
                String email = emailET.getText().toString();

                nameET.setText("");
                contactET.setText("");
                emailET.setText("");

                AddData(name, contact, email);

            }
        });

    }

    public void AddData(String name, String contact, String email){

        boolean chk = mydb.add_data(name, contact, email);

        if(chk) {
            Toast.makeText(NewUserTab.this, "Data Inserted Successfully.", Toast.LENGTH_LONG).show();

            Intent i = new Intent(NewUserTab.this,MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(NewUserTab.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }

    }

}
