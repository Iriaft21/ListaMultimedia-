package com.carballeira.listamultimedia;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MultimediaAdapter extends RecyclerView.Adapter<MultimediaAdapter.MultimediaViewHolder>{

    private ArrayList<Multimedia> listaMultimedia;
    private OnItemClickListener itemClickListener;

    public MultimediaAdapter(ArrayList<Multimedia> listaMultimedia, OnItemClickListener itemClickListener) {
        this.listaMultimedia = listaMultimedia;
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public MultimediaAdapter.MultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MultimediaAdapter.MultimediaViewHolder multimediaViewHolder = new MultimediaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        return multimediaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MultimediaViewHolder holder, int position) {
        Multimedia multimedia = listaMultimedia.get(position);

        holder.titulo.setText(multimedia.getNombre());
        holder.thumbnail.setImageResource(multimedia.getMiniatura());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMultimedia.size();
    }

    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView thumbnail;

        public MultimediaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_titulo);
            thumbnail = itemView.findViewById(R.id.img_miniatura);
        }
    }
}