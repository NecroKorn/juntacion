package cl.darkcity.vv.juntacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetalleJuntaActivity extends AppCompatActivity {

    ArrayList<String> amigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_junta);

        Button btnNuevaJunta = (Button) findViewById(R.id.btn_nueva_junta_interior);
        btnNuevaJunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ListView lsvAmigos = (ListView)findViewById(R.id.contacto_junta);

        amigos = new ArrayList<String>();
        getAmigos();

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, amigos);
        // Set The Adapter
        lsvAmigos.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

        // register onClickListener to handle click events on each item
        lsvAmigos.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedmovie=amigos.get(position);
                Toast.makeText(getApplicationContext(), "Amigo seleccionado : "+selectedmovie,   Toast.LENGTH_LONG).show();
            }
        });

    }

    void getAmigos()
    {
        amigos.add("Adrian");
        amigos.add("Master chef");
        amigos.add("Juan");
        amigos.add("Carla");
        amigos.add("Carlita");
        amigos.add("Jose Donoso");
        amigos.add("Angel Parra");
        amigos.add("Aleister Crowley");
    }
}
