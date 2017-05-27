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

public class JuntasActivity extends AppCompatActivity {

    ArrayList<String> juntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juntas);

        Button btnNuevaJunta = (Button) findViewById(R.id.btn_nueva_junta_interior);
        btnNuevaJunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(JuntasActivity.this,DetalleJuntaActivity.class);
                JuntasActivity.this.startActivity(myIntent);
            }
        });

        ListView lsvJuntas = (ListView)findViewById(R.id.list_juntas);

        juntas = new ArrayList<String>();
        getJuntas();

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, juntas);
        // Set The Adapter
        lsvJuntas.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        lsvJuntas.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedmovie=juntas.get(position);
                Toast.makeText(getApplicationContext(), "Junta seleccionada : "+selectedmovie,   Toast.LENGTH_LONG).show();
            }
        });

    }

    void getJuntas()
    {
        juntas.add("Cumpleaños mama");
        juntas.add("Orrego Luco 1");
        juntas.add("Bellavista on Flames");
        juntas.add("Bellavista on Flames 2");
        juntas.add("Bellavista on Flames 3");
        juntas.add("Comida tia Juanita");
        juntas.add("Bellavista on Flames 4");
        juntas.add("Bellavista on Flames 5");
        juntas.add("Bellavista on Flames 6");
    }

}
