package silva.fellipy.galeria2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Toolbar toolbar = findViewById(R.id.tbPhoto); // Obtendo elemento tbMain
        setSupportActionBar(toolbar); // Indicando que tbMain deve ser considerado uma ActionBar

        ActionBar actionBar = getSupportActionBar(); // Obtendo a ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true); // Habilitando o botão de voltar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater(); // Criando inflatador de menu
        inflater.inflate(R.menu.main_activity_tb, menu);
        return true;
    }
}