package cl.darkcity.vv.juntacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetalleJuntaActivity extends AppCompatActivity {

    ArrayList<String> amigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_junta);

        Button btnInvitar = (Button) findViewById(R.id.btn_invitar);
        btnInvitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DetalleJuntaActivity.this,InvitacionEnviadaActivity.class);
                DetalleJuntaActivity.this.startActivity(myIntent);
            }
        });

        Intent intent = getIntent();

        String juntacionSeleccionada = intent.getStringExtra("juntacionSelecconada");

        if(juntacionSeleccionada != "")
        {
            TextView tituloJuntacion = (TextView) findViewById(R.id.txt_tit);
            tituloJuntacion.setText(juntacionSeleccionada);
            TextView lugarJuntacion = (TextView) findViewById(R.id.lugar_junta);
            lugarJuntacion.setText("Nuevo Lugar");
            TextView fechaJuntacion = (TextView) findViewById(R.id.fecha_junta);
            fechaJuntacion.setText("25/10/2017");
        }

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
