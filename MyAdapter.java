package com.example.maribelanja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList nama_id, jenis_id, harga_id;

    public MyAdapter(Context context, ArrayList nama_id, ArrayList jenis_id, ArrayList harga_id) {
        this.context = context;
        this.nama_id = nama_id;
        this.jenis_id = jenis_id;
        this.harga_id = harga_id;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adminentry,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_id.setText(String.valueOf(nama_id.get(position)));
        holder.jenis_id.setText(String.valueOf(jenis_id.get(position)));
        holder.harga_id.setText(String.valueOf(harga_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return nama_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama_id, jenis_id, harga_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_id = itemView.findViewById(R.id.textnama);
            jenis_id = itemView.findViewById(R.id.textjenis);
            harga_id = itemView.findViewById(R.id.textharga);
        }
    }
}
