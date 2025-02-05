package com.carballeira.listamultimedia;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoVideo extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Construimos el dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Inflamos el layout
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layoutvideo, null);


        VideoView videoView = view.findViewById(R.id.videoView);
        //Aqui le pasamos el nombre del video
        //videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.dados);
        videoView.start();

        Button cerrar =view.findViewById(R.id.btn_cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        // Asocia el layout al diálogo
        builder.setView(view);
        // Crea el diálogo y lo devuelve
        return builder.create();
    }
}
