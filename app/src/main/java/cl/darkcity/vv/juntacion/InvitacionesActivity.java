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
import android.widget.Toast;

import java.util.ArrayList;

public class InvitacionesActivity extends AppCompatActivity
{

    ArrayList<String> amigos;
    ArrayList<String> invitaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitaciones);

        SharedPreferences appJuntacion = InvitacionesActivity.this.getSharedPreferences("appJuntacion", Context.MODE_PRIVATE);
        String appLoguin = appJuntacion.getString("email", null);

        setTitle("Juntacion - " + appLoguin);

        Button btnAtras = (Button) findViewById(R.id.btn_atras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InvitacionesActivity.this,MainActivity.class);
                InvitacionesActivity.this.startActivity(myIntent);
            }
        });

        ListView lsvInvitaciones = (ListView)findViewById(R.id.contacto_inv_1);

        invitaciones = new ArrayList<String>();
        getInvitaciones();

        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, invitaciones);
        // Set The Adapter
        lsvInvitaciones.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();

        // register onClickListener to handle click events on each item
        lsvInvitaciones.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String invitacion_seleccionada=invitaciones.get(position);

                ListView lsvInvitados = (ListView)findViewById(R.id.contacto_inv_2);
                amigos = new ArrayList<String>();
                getAmigos(invitacion_seleccionada);

                // Create The Adapter with passing ArrayList as 3rd parameter
                ArrayAdapter<String> arrayAdapterAmigos =
                        new ArrayAdapter<String>(InvitacionesActivity.this, android.R.layout.simple_list_item_1, amigos);
                // Set The Adapter
                lsvInvitados.setAdapter(arrayAdapterAmigos);

                arrayAdapterAmigos.notifyDataSetChanged();
            }
        });

    }

    void getInvitaciones()
    {
        invitaciones.add("Casa MAMA");
        invitaciones.add("Orregoluco 1");
        invitaciones.add("Orregoluco 2");
        invitaciones.add("Tia Pame");
        invitaciones.add("Cumple Feña");
    }

    void getAmigos(String invitacion_seleccionada)
    {
        amigos.clear();

        switch (invitacion_seleccionada)
        {
            case "Casa MAMA":
                amigos.add("Adrian");
                amigos.add("Mr chef");
                amigos.add("Juan");
                amigos.add("Carla");
                amigos.add("Carlita");
                amigos.add("Jose Donoso");
                amigos.add("Angel Parra");
                amigos.add("Aleister Crowley");
                break;
            case "Orregoluco 1":
                amigos.add("Pedro");
                amigos.add("Antonio");
                amigos.add("Juan");
                amigos.add("Alberto");
                amigos.add("Pedrito");
                break;
            case "Orregoluco 2":
                amigos.add("Martin");
                amigos.add("Marcelo");
                amigos.add("Macabeo");
                amigos.add("Dolores");
                amigos.add("Juan");
                break;
            case "Tia Pame":
                amigos.add("Andres");
                amigos.add("Jaime");
                amigos.add("Jazmin");
                amigos.add("Tia Pepa");
                amigos.add("Tio Pepe");
                break;
            case "Cumple Feña":
                amigos.add("Cabezon");
                amigos.add("El Llegua");
                amigos.add("Juan Palestro");
                amigos.add("Enrique");
                amigos.add("Maria");
                break;
        }
    }

}
