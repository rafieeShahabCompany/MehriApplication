package com.example.mehriapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder> {

    List<String> mylisy;
    public Adapter(List<String> list){
        mylisy = list;

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
        String item = mylisy.get(position);
        holder.txtItem.setText(item);

    }

    @Override
    public int getItemCount() {
        return mylisy.size();
    }

    class AdapterHolder extends RecyclerView.ViewHolder{
        TextView txtItem;


        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
        }
    }
}
