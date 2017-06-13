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
                String selectedjuntacion=juntas.get(position);
                Intent myIntent = new Intent(JuntasActivity.this,DetalleJuntaActivity.class);
                myIntent.putExtra("juntacionSelecconada", selectedjuntacion);
                JuntasActivity.this.startActivity(myIntent);
            }
        });

    }

    void getJuntas()
    {
        juntas.add("Cumple mama");
        juntas.add("Orrego Luco");
        juntas.add("Bella on Flames");
        juntas.add("3er Tiempo");
        juntas.add("Oficina");
        juntas.add("Comida tia");
        juntas.add("18 Sept");
        juntas.add("Familia");
        juntas.add("Rusia 2017");
    }

}
