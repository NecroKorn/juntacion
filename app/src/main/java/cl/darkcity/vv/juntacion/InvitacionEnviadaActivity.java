package cl.darkcity.vv.juntacion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InvitacionEnviadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitacion_enviada);

        SharedPreferences appJuntacion = InvitacionEnviadaActivity.this.getSharedPreferences("appJuntacion", Context.MODE_PRIVATE);
        String appLoguin = appJuntacion.getString("email", null);

        setTitle("Juntacion - " + appLoguin);

        Intent intent = getIntent();

        String juntacionSeleccionada = intent.getStringExtra("juntacionSelecconada");

        if(juntacionSeleccionada != "")
        {
            TextView grupo = (TextView) findViewById(R.id.grupo_txt);
            grupo.setText(juntacionSeleccionada);
        }

        Button btnAtras = (Button) findViewById(R.id.btn_atras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InvitacionEnviadaActivity.this,JuntasActivity.class);
                InvitacionEnviadaActivity.this.startActivity(myIntent);
            }
        });

        Button btnHome = (Button) findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InvitacionEnviadaActivity.this,MainActivity.class);
                InvitacionEnviadaActivity.this.startActivity(myIntent);
            }
        });
    }
}
