package com.carballeira.listamultimedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MultimediaAdapter extends RecyclerView.Adapter<MultimediaAdapter.MultimediaViewHolder>{

    private ArrayList<Multimedia> listaMultimedia;

    public MultimediaAdapter(ArrayList<Multimedia> listaMultimedia) {
        this.listaMultimedia = this.listaMultimedia;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public MultimediaAdapter.MultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MultimediaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaMultimedia.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MultimediaAdapter.MultimediaViewHolder holder, int position) {
        Multimedia multimedia = listaMultimedia.get(position);

        holder.titulo.setText(multimedia.getNombre());
    }

    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;

        public MultimediaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_titulo);
        }
    }
}
