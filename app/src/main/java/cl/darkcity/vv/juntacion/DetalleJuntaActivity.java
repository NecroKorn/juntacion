package cl.darkcity.vv.juntacion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences appJuntacion = DetalleJuntaActivity.this.getSharedPreferences("appJuntacion", Context.MODE_PRIVATE);
        String appLoguin = appJuntacion.getString("email", null);

        setTitle("Juntacion - " + appLoguin);

        Intent intent = getIntent();

        String juntacionSeleccionada = intent.getStringExtra("juntacionSelecconada");

        amigos = new ArrayList<String>();
        getAmigos(juntacionSeleccionada);

        if(juntacionSeleccionada != "")
        {
            TextView tituloJuntacion = (TextView) findViewById(R.id.txt_tit);
            tituloJuntacion.setText(juntacionSeleccionada);
            TextView lugarJuntacion = (TextView) findViewById(R.id.lugar_junta);
            lugarJuntacion.setText(getLugar(juntacionSeleccionada));
            TextView fechaJuntacion = (TextView) findViewById(R.id.fecha_junta);
            fechaJuntacion.setText(getFecha(juntacionSeleccionada));
        }

        Button btnInvitar = (Button) findViewById(R.id.btn_invitar);
        btnInvitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String juntacionSeleccionada = intent.getStringExtra("juntacionSelecconada");

                Intent myIntent = new Intent(DetalleJuntaActivity.this,InvitacionEnviadaActivity.class);
                myIntent.putExtra("juntacionSelecconada", juntacionSeleccionada);
                DetalleJuntaActivity.this.startActivity(myIntent);
            }
        });

        ListView lsvAmigos = (ListView)findViewById(R.id.contactos_junta);

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

        Button btnAtras = (Button) findViewById(R.id.btn_atras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DetalleJuntaActivity.this,MainActivity.class);
                DetalleJuntaActivity.this.startActivity(myIntent);
            }
        });
    }

    void getAmigos(String invitacion_seleccionada)
    {
        amigos.clear();

        switch (invitacion_seleccionada)
        {
            case "Cumple mama":
                amigos.add("Adrian");
                amigos.add("Mr chef");
                amigos.add("Juan");
                amigos.add("Carla");
                amigos.add("Carlita");
                amigos.add("Jose Donoso");
                amigos.add("Angel Parra");
                amigos.add("Aleister Crowley");
                break;
            case "Orrego Luco":
                amigos.add("Pedro");
                amigos.add("Antonio");
                amigos.add("Juan");
                amigos.add("Alberto");
                amigos.add("Pedrito");
                break;
            case "Bella on Flames":
                amigos.add("Martin");
                amigos.add("Marcelo");
                amigos.add("Macabeo");
                amigos.add("Dolores");
                amigos.add("Juan");
                break;
            case "3er Tiempo":
                amigos.add("Andres");
                amigos.add("Jaime");
                amigos.add("Jazmin");
                amigos.add("Tia Pepa");
                amigos.add("Tio Pepe");
                break;
            case "Oficina":
                amigos.add("Cabezon");
                amigos.add("El Llegua");
                amigos.add("Juan Palestro");
                amigos.add("Enrique");
                amigos.add("Maria");
                break;
            case "Comida tia":
                amigos.add("Pedro");
                amigos.add("Antonio");
                amigos.add("Juan");
                amigos.add("Alberto");
                amigos.add("Pedrito");
                break;
            case "18 Sept":
                amigos.add("Martin");
                amigos.add("Marcelo");
                amigos.add("Macabeo");
                amigos.add("Dolores");
                amigos.add("Juan");
                break;
            case "Familia":
                amigos.add("Andres");
                amigos.add("Jaime");
                amigos.add("Jazmin");
                amigos.add("Tia Pepa");
                amigos.add("Tio Pepe");
                break;
            case "Rusia 2017":
                amigos.add("Cabezon");
                amigos.add("El Llegua");
                amigos.add("Juan Palestro");
                amigos.add("Enrique");
                amigos.add("Maria");
                break;
        }
    }

    String getFecha(String invitacion_seleccionada)
    {
        String resultado = "";

        switch (invitacion_seleccionada)
        {
            case "Cumple mama":
                resultado = "25/10/2017";
                break;
            case "Orrego Luco":
                resultado = "15/05/2016";
                break;
            case "Bella on Flames":
                resultado = "01/08/2017";
                break;
            case "3er Tiempo":
                resultado = "15/06/2017";
                break;
            case "Oficina":
                resultado = "13/12/2016";
                break;
            case "Comida tia":
                resultado = "25/09/2017";
                break;
            case "18 Sept":
                resultado = "16/09/2016";
                break;
            case "Familia":
                resultado = "02/02/2017";
                break;
            case "Rusia 2017":
                resultado = "01/01/2017";
                break;
        }

        return resultado;
    }

    String getLugar(String invitacion_seleccionada)
    {
        String resultado = "";

        switch (invitacion_seleccionada)
        {
            case "Cumple mama":
                resultado = "Casa MaMa";
                break;
            case "Orrego Luco":
                resultado = "Orrego Luco";
                break;
            case "Bella on Flames":
                resultado = "Metro";
                break;
            case "3er Tiempo":
                resultado = "Bar la lleva";
                break;
            case "Oficina":
                resultado = "Casino";
                break;
            case "Comida tia":
                resultado = "Casa Tía";
                break;
            case "18 Sept":
                resultado = "Parque O´Higgins";
                break;
            case "Familia":
                resultado = "Casa Mama";
                break;
            case "Rusia 2017":
                resultado = "Europa";
                break;
        }

        return resultado;
    }
}
