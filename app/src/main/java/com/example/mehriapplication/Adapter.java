package com.example.mehriapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mehriapplication.MOVIE.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder> {

    List<Search> mylist;
    public Adapter(List<Search> list){
        this.mylist = list;

    }


    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
       AdapterHolder holder = new AdapterHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        String title = mylist.get(position).getTitle();
        holder.txtTitle.setText(title);
        String year = mylist.get(position).getYear();
        holder.txtYear.setText(year);
        String poster = mylist.get(position).getPoster();
        Picasso.get().load(poster).into(holder.imgPoster);


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class AdapterHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtYear;
        ImageView imgPoster;


        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtYear = itemView.findViewById(R.id.txtYear);
            imgPoster = itemView.findViewById(R.id.imgPoster);
        }
    }
}
