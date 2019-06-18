package com.example.unitygames.detailmaster;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    //FIELDS TO STORE PASSED IN VALUES

    Context c;
    ArrayList<Player> players,filterList;
    CustomFilter filter;

    public MyAdapter(Context c, ArrayList<Player> players) {
        this.c = c;
        this.players = players;
        this.filterList = players;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //INFLATE A VIEW FROM XML
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);

        //HOLDER
        MyHolder holder=new MyHolder(v);

        return holder;
    }


    //DATA IS BEING BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {


        holder.posTxt.setText(players.get(position).getPos());
        holder.nameTxt.setText(players.get(position).getName());
        holder.img.setImageResource(players.get(position).getImg());



        //WHEN ITEM IS CLICKED
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                Snackbar.make(v,players.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(c,DetailActivity.class);
                intent.putExtra("Players",filterList.get(pos));
                c.startActivity(intent);

            }
        });
    }
    //TOTAL PLAYERS

    @Override
    public int getItemCount() {
        return players.size();
    }
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}
