package com.carballeira.listamultimedia;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoVideo extends DialogFragment {

    private Multimedia multimedia;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Construimos el dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Inflamos el layout
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layoutvideo, null);

        Bundle bundle = getArguments();
        if(bundle != null){
            multimedia = (Multimedia) bundle.getSerializable("multimedia");
        }

        TextView nombre = view.findViewById(R.id.txt_nombre);
        nombre.setText(multimedia.getNombre());
        TextView tipo = view.findViewById(R.id.txt_tipo);
        tipo.setText("Tipo de multimedia: " + multimedia.getTipo());

        VideoView videoView = view.findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + multimedia.getRuta());

        MediaController mediaController = new MediaController(getActivity());
        //mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
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
