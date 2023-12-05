package com.example.pt5_joel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Button btnVerOpciones = findViewById(R.id.boto);
        btnVerOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad para ver las opciones
                startActivity(SettingsActivity.getIntent(MainActivity.this));
            }
        });

        Button btnMostrarResumen = findViewById(R.id.resultatt);
        btnMostrarResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos guardados y mostrar resumen
                showSummary();
            }
        });
    }

    private void showSummary() {
        // Obtener datos guardados
        String nombreCognoms = SettingsActivity.getPreferencesString(this, "nom_cognoms", "");
        Set<String> razasSeleccionadas = SettingsActivity.getPreferencesSet(this, "razas_seleccionadas");
        boolean notificacionActivada = SettingsActivity.getPreferencesBoolean(this, "notificacion_activada", false);
        String peliculaSeleccionada = SettingsActivity.getPreferencesString(this, "pelicula_seleccionada", "");

        // Mostrar resumen
        TextView txtResumen = findViewById(R.id.textview);
        String resumen = "Nombre y Apellidos: " + nombreCognoms + "\n" +
                "Razas Seleccionadas: " + TextUtils.join(", ", razasSeleccionadas) + "\n" +
                "Notificación Activada: " + notificacionActivada + "\n" +
                "Película Seleccionada: " + peliculaSeleccionada;
        txtResumen.setText(resumen);
    }
}
