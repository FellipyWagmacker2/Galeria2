package silva.fellipy.galeria2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.File;

public class PhotoActivity extends AppCompatActivity {

    String photoPath; // Caminho da foto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Toolbar toolbar = findViewById(R.id.tbPhoto); // Obtendo o elemento Toolbar com id tbPhoto
        setSupportActionBar(toolbar); // Definindo tbPhoto como ActionBar

        ActionBar actionBar = getSupportActionBar(); // Obtendo a ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true); // Habilitando o botão de voltar

        Intent i = getIntent();
        photoPath = i.getStringExtra("photo_path"); // Obtendo o caminho da foto do Intent

        Bitmap bitmap = Utils.getBitmap(photoPath); // Obtendo o bitmap da foto usando o caminho
        ImageView imPhoto = findViewById(R.id.imPhoto); // Obtendo o elemento ImageView com id imPhoto
        imPhoto.setImageBitmap(bitmap); // Definindo o bitmap no ImageView para exibir a foto
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater(); // Criando um inflador de menu
        inflater.inflate(R.menu.photo_activity_tb, menu); // Inflando o menu a partir do arquivo XML
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opShare:
                sharePhoto(); // Chamando o método para compartilhar a foto
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void sharePhoto() {
        Uri photoUri = FileProvider.getUriForFile(PhotoActivity.this, "silva.fellipy.galeria2.fileprovider", new File(photoPath)); // Obtendo o URI da foto usando o FileProvider
        Intent i = new Intent(Intent.ACTION_SEND); // Criando uma intent para compartilhamento
        i.putExtra(Intent.EXTRA_STREAM, photoUri); // Definindo o URI da foto como um extra da intent
        i.setType("image/jpeg"); // Definindo o tipo do conteúdo como imagem JPEG
        startActivity(i); // Iniciando a atividade de compartilhamento
    }
}