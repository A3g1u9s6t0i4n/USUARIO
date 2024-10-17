package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3.UserViewModel;
import com.example.tp3.Usuario;
import com.example.tp3.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // View Binding
    private UserViewModel userVm; // ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userVm = new ViewModelProvider(this).get(UserViewModel.class);
        tarea();

    }

    public void tarea() {
         binding.btGuardar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String nombre = binding.tvNombre.getText().toString();
                 int edad;

                 if (!nombre.isEmpty() && !binding.tvEdad.getText().toString().isEmpty()) {

                     try {
                         edad = Integer.parseInt(binding.tvEdad.getText().toString());
                         Usuario u = new Usuario(nombre, edad);

                         userVm.addUser(u);
                         binding.tvNombre.setText("");
                         binding.tvEdad.setText("");


                     } catch (NumberFormatException e) {
                         binding.tvVerUsuario.setText("Error de formato de edad");

                     }
                 }else{
                         binding.tvVerUsuario.setText("ERROR");
                     }
                 binding.tvNombre.setText("");
                 binding.tvEdad.setText("");

             }
         });

         binding.btVer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 List<Usuario> l = userVm.getUserList();
                 String t = "";

                 for (Usuario u : l){
                     t +="Nombre : " + u.getNombre() + "Edad : " + u.getEdad() + '\n';
                 }

                 binding.btVer.setText(t);
             }
         });

    }
}