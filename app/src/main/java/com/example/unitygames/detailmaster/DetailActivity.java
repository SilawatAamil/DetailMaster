package com.example.unitygames.detailmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity{

    TextView nameTxt,posTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RECEIVE OUR DATA
        Intent i= getIntent();
        Player player = i.getParcelableExtra("Players");
        final String name = player.getName();
        String pos = player.getPos();
        int img = player.getImg();

        //REFERENCE VIEWS FROM XML
        ImageView imageView = (ImageView) findViewById(R.id.playerImage);
        //ASSIGN DATA TO THOSE VIEWS
        imageView.setImageResource(img);

        //REFERENCE VIEWS FROM XML
        TextView nmtxt = (TextView)findViewById(R.id.nameTxt);
        //ASSIGN DATA TO THOSE VIEWS
        nmtxt.setText("Name : "+name);

        //REFERENCE VIEWS FROM XML
        TextView postxt =(TextView) findViewById(R.id.posTxt);
        //ASSIGN DATA TO THOSE VIEWS
        postxt.setText("Position : "+pos);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, name, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

}
