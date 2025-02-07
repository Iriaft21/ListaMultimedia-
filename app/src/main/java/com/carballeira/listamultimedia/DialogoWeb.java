package com.carballeira.listamultimedia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoWeb extends DialogFragment {

    private Multimedia multimedia;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //TODO pasarle el elemento multimedia
        //Construimos el dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Inflamos el layout
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layoutweb, null);

        Bundle bundle = getArguments();
        if(bundle != null){
            multimedia = (Multimedia) bundle.getSerializable("multimedia");
        }

        TextView nombre = view.findViewById(R.id.txt_nombre);
        nombre.setText(multimedia.getNombre());
        TextView tipo = view.findViewById(R.id.txt_tipo);
        tipo.setText("Tipo de multimedia: " + multimedia.getTipo());

        WebView webView = view.findViewById(R.id.webView);

        // Habilita javascript en el webview
        webView.getSettings().setJavaScriptEnabled(true);
        // Establece el cliente web para manejar las redirecciones
        webView.setWebViewClient(new WebViewClient());
        // Establece el cliente web para manejar las alertas de confirmacion
        webView.setWebChromeClient(new WebChromeClient());

        // Carga la web de Distancia en el WebView
        webView.loadUrl(multimedia.getRuta());

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
