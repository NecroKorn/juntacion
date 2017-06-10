package cl.darkcity.vv.juntacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mensajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRrepiteJunta = (Button) findViewById(R.id.btn_repite_junta);
        btnRrepiteJunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,JuntasActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        ImageButton btnInvitaciones = (ImageButton) findViewById(R.id.btn_invitaciones);
        btnInvitaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,InvitacionesActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        ListView lsvEstaPasando = (ListView)findViewById(R.id.list_esta_pasando);

        mensajes = new ArrayList<String>();
        getMensajes();

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mensajes);
        // Set The Adapter
        lsvEstaPasando.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        lsvEstaPasando.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedmovie=mensajes.get(position);
                Toast.makeText(getApplicationContext(), "Mensaje seleccionado : "+selectedmovie,   Toast.LENGTH_LONG).show();
            }
        });
    }

    void getMensajes()
    {
        mensajes.add("Como estamos");
        mensajes.add("Todos Bien");
        mensajes.add("esperando en la botilleria");
        mensajes.add("tengo sueño");
        mensajes.add("vamos a casa de la tia");
        mensajes.add("no se donde queda el local");
    }
}
