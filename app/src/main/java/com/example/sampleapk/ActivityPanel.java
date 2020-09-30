package com.example.sampleapk;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
// made by jatin

public class ActivityPanel extends AppCompatActivity {

    RecyclerView rcv;
    DBHelper mydb;
    ArrayList<data> ilist;
    Button addUserBtn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
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

        addUserBtn2 = (Button)findViewById(R.id.addUserBtn2);

        addUserBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityPanel.this,NewUserTab.class);
                startActivity(i);
            }
        });

        ilist = new ArrayList<data>();
        mydb = new DBHelper(this);
        ilist = mydb.getListContents();

        rec_adapter radapter = new rec_adapter(ilist,this);
        rcv = (RecyclerView)findViewById(R.id.recycler);
        rcv.setAdapter(radapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        radapter.notifyDataSetChanged();
    }

}
