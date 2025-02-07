package com.carballeira.listamultimedia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements MultimediaAdapter.OnItemClickListener {

    private ArrayList<Multimedia> archivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        archivos = new ArrayList<>();
        archivos.addAll(Arrays.asList(new Multimedia("Caminando", "audio", R.raw.caminar, String.valueOf(R.raw.caminar_audio)),
                new Multimedia("Carballeira", "web", R.raw.carballeira, "https://cifpcarballeira.com/moodle/"),
                new Multimedia("Carteles", "video", R.raw.luces_carteles, String.valueOf(R.raw.luces_carteles_video)),
                new Multimedia("Olas en la playa", "video", R.raw.playa, String.valueOf(R.raw.playa_video)),
                new Multimedia("Electricidad estatica", "web", R.raw.static_cling, "https://en.wikipedia.org/wiki/Static_cling"),
                new Multimedia("Escribiendo en un teclado", "audio", R.raw.teclado, String.valueOf(R.raw.teclado_audio))));

        RecyclerView rv_multimedia = findViewById(R.id.rv_media);
        MultimediaAdapter adaptador = new MultimediaAdapter(archivos, this);

        rv_multimedia.setLayoutManager(new LinearLayoutManager(this));
        rv_multimedia.setAdapter(adaptador);
        Log.d("MainActivity", "Total items: " + adaptador.getItemCount());
    }

    @Override
    public void onItemClick(View view, int position) {
        Multimedia multimedia = archivos.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("multimedia", multimedia);

        if(multimedia.getTipo().equals("video")){
            DialogoVideo dialogoVideo = new DialogoVideo();
            dialogoVideo.setArguments(bundle);
            dialogoVideo.show(getSupportFragmentManager(), "dialogoVideo");
        }else if(multimedia.getTipo().equals("web")){
            DialogoWeb dialogoWeb = new DialogoWeb();
            dialogoWeb.setArguments(bundle);
            dialogoWeb.show(getSupportFragmentManager(), "dialogoWeb");
        } else if (multimedia.getTipo().equals("audio")){
            DialogoAudio dialogoAudio = new DialogoAudio();
            dialogoAudio.setArguments(bundle);
            dialogoAudio.show(getSupportFragmentManager(), "dialogoAudio");
        }

    }
}