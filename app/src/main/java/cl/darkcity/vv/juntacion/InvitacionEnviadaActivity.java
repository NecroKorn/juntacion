package cl.darkcity.vv.juntacion;

import android.content.Intent;
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
                Intent myIntent = new Intent(InvitacionEnviadaActivity.this,DetalleJuntaActivity.class);
                InvitacionEnviadaActivity.this.startActivity(myIntent);
            }
        });
    }
}
