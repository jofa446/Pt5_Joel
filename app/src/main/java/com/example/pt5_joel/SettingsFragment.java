package com.example.pt5_joel;

import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import java.util.Set;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        findPreference("saveButton").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                // Obtener el valor del EditTextPreference
                String nombreCognoms = ((EditTextPreference) findPreference("editTextPreference")).getText();

                // Guardar en las preferencias
                SettingsActivity.savePreferencesString(requireContext(), "nom_cognoms", nombreCognoms);

                // Obtener los valores del MultiSelectListPreference
                Set<String> razasSeleccionadas = ((MultiSelectListPreference) findPreference("racePreference")).getValues();

                // Guardar en las preferencias
                SettingsActivity.savePreferencesSet(requireContext(), "razas_seleccionadas", razasSeleccionadas);

                // Obtener el estado del SwitchPreference
                boolean notificacionActivada = ((SwitchPreference) findPreference("notificationPreference")).isChecked();

                // Guardar en las preferencias
                SettingsActivity.savePreferencesBoolean(requireContext(), "notificacion_activada", notificacionActivada);

                // Obtener la película seleccionada del ListPreference
                String peliculaSeleccionada = ((ListPreference) findPreference("moviePreference")).getValue();

                // Guardar en las preferencias
                SettingsActivity.savePreferencesString(requireContext(), "pelicula_seleccionada", peliculaSeleccionada);

                // Mostrar un mensaje de confirmación
                Toast.makeText(requireContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
