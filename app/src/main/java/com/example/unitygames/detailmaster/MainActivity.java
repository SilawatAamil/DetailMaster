package com.example.unitygames.detailmaster;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView sv;

    //DATA SOURCE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Team", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //REFERENCE RECYCLER

        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);

        //SET ITS PROPETRIES

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER

        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });



    }
    private ArrayList<Player> getPlayers()
    {

        ArrayList<Player> players=new ArrayList<>();
        Player p=new Player();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setImg(R.drawable.herera);
        players.add(p);

        p=new Player();
        p.setName("David De Geaa");
        p.setPos("Goalkeeper");
        p.setImg(R.drawable.degea);
        players.add(p);

        p=new Player();
        p.setName("Michael Carrick");
        p.setPos("Midfielder");
        p.setImg(R.drawable.carrick);
        players.add(p);

        p=new Player();
        p.setName("Juan Mata");
        p.setPos("Playmaker");
        p.setImg(R.drawable.mata);
        players.add(p);

        p=new Player();
        p.setName("Diego Costa");
        p.setPos("Striker");
        p.setImg(R.drawable.costa);
        players.add(p);

        p=new Player();
        p.setName("Oscar");
        p.setPos("Playmaker");
        p.setImg(R.drawable.oscar);
        players.add(p);


        return players;

    }
}
