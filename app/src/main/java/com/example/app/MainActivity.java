package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user,password;
    private RadioButton hombre,mujer;
    private CheckBox root;
    private Spinner dia,mes,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        hombre = (RadioButton) findViewById(R.id.rb_hombre);
        mujer = (RadioButton) findViewById(R.id.rb_mujer);
        root = (CheckBox) findViewById(R.id.root);
        dia = (Spinner) findViewById(R.id.dia);
        mes = (Spinner) findViewById(R.id.mes);
        year = (Spinner) findViewById(R.id.año);

        String []dia= new String [20];
        String []mes= new String [12];
        String []year= new String [100];
        for (int i=0;i<100;i++ ){
            year[i]= String.valueOf(i+1921);
            if(i<31){
                dia[i]= String.valueOf(i+1);
                if(i<12){
                    mes[i]= String.valueOf(i+1);
                }
            }
        }
        ArrayAdapter<String> adapterDia = new ArrayAdapter<String>(this,R.layout.spinner_item_dia,dia);
        ArrayAdapter<String> adapterMes = new ArrayAdapter<String>(this,R.layout.spinner_item_dia,mes);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,R.layout.spinner_item_dia,year);

        this.dia.setAdapter(adapterDia);
        this.mes.setAdapter(adapterMes);
        this.year.setAdapter(adapterYear);

        Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show();
        // La actividad se ha creado
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_LONG).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_LONG).show();
        // La actividad está a punto de ser destruida.
    }
    public void guardarDatos(View view){

        String dato = user.getText().toString()+" "+password.getText().toString();
        String fecha = dia.getSelectedItem().toString()+"/"+mes.getSelectedItem().toString()+"/"+year.getSelectedItem().toString();
        Toast.makeText(this, fecha, Toast.LENGTH_LONG).show();
        if(hombre.isChecked()){
            if(root.isChecked()){
                Toast.makeText(this, dato+" hombre + root", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, dato+" hombre + no root", Toast.LENGTH_LONG).show();
            }
        }else if(mujer.isChecked()){
            if(root.isChecked()){
                Toast.makeText(this, dato+" mujer + root", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, dato+" mujer + no root", Toast.LENGTH_LONG).show();
            }
        }

    }
}
