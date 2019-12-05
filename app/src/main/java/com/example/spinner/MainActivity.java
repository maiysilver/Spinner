package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     private String[] desplegable;
     private TextView textoResultado;
     private TextView telefono;
     private Spinner spin;
     private String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        desplegable = res.getStringArray(R.array.spiner);
        spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        textoResultado = findViewById(R.id.resultado);
        telefono=findViewById(R.id.telefono);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spiner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        tel = telefono.getText().toString();
        textoResultado.setText(tel+" - "+ spin.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textoResultado.setText("telefono");
    }
}
