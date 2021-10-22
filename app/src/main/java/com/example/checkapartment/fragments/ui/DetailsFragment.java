package com.example.checkapartment.fragments.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.FragmentDetailsBinding;
import com.example.checkapartment.viewmodel.DeptoViewModel;


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    DeptoViewModel viewModel;
    ImageView img;
    CheckBox cbDorm, cbBath, cbLuces, cbCocina;
    RadioButton rbNormal, rbRegular, rbDef;
    TextView tvNombre, tvUnidad, tvDir, tvPuntaje;
    Button boton, botonAlerta;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        hacerBinding();
        int id = DetailsFragmentArgs.fromBundle(getArguments()).getDeptoId();

        viewModel = new ViewModelProvider(getActivity()).get(DeptoViewModel.class);

        viewModel.setDeptoId(id);

        viewModel.deptoById(id).observe(getViewLifecycleOwner(), departamento -> {
            Glide.with(this).load(departamento.getUrl()).fitCenter().into(img);
            tvNombre.setText("Nombre: " + departamento.getNombre());
            tvDir.setText("Dirección: " + departamento.getDireccion());
            tvUnidad.setText("Unidad: " + departamento.getUnidad());


        });

//        viewModel.getPuntajeMutable().observe(getViewLifecycleOwner(), integer->{
//            viewModel.setPuntajeMutable(10);
//            tvPuntaje.setText("Puntaje:" + viewModel.getPuntajeMutable().getValue().toString());
//        });

        tvPuntaje.setText("Puntaje:" + String.valueOf(viewModel.getPuntajeMutable().getValue()));

        boton.setOnClickListener(view -> {

            escribirPuntajeBD(id);

        });

        botonAlerta.setOnClickListener(view -> {
            composeEmail(new String[]{"address@mail.com"},"algo", null );
        });


        return binding.getRoot();
    }


    public void hacerBinding() {
        img = binding.imageView;
        tvNombre = binding.tvNombreD;
        tvUnidad = binding.tvUnidadD;
        tvDir = binding.tvDirD;
        cbBath = binding.cbBath;
        cbCocina = binding.cbCocina;
        cbDorm = binding.cbDormitorio;
        cbLuces = binding.cbLuces;
        rbNormal = binding.cbNormal;
        rbRegular = binding.cbRegular;
        rbDef = binding.cbDef;
        boton = binding.button;
        botonAlerta = binding.buttonAlerta;
        tvPuntaje = binding.tvPuntaje;

        botonAlerta.setEnabled(false);
        botonAlerta.setClickable(false);
    }

    public void escribirPuntajeBD(int id) {
        boolean lucesBool = cbLuces.isChecked();
        boolean bathBool = cbBath.isChecked();
        boolean dormBool = cbDorm.isChecked();
        boolean cocinaBool = cbCocina.isChecked();

        viewModel.deptoById(id).observe(getViewLifecycleOwner(), departamento -> {
            if (lucesBool) {
                departamento.setLuces(10);
                viewModel.setPuntajeMutable(10);
            } else {
                departamento.setLuces(0);
            }
            departamento.calcularPuntaje();
            viewModel.setPuntajeMutable(10);
            //  viewModel.actualizarDepartamento(departamento);

            if (bathBool) {
                departamento.setBath(40);
            } else {
                departamento.setBath(0);
            }
            // viewModel.actualizarDepartamento(departamento);

            if (dormBool) {
                departamento.setDormitorio(20);
            } else {
                departamento.setDormitorio(0);
            }
            // viewModel.actualizarDepartamento(departamento);

            if (cocinaBool) {
                departamento.setCocina(30);
            } else {
                departamento.setCocina(0);
            }
            // viewModel.actualizarDepartamento(departamento);

            if (rbNormal.isChecked() || rbRegular.isChecked() || rbDef.isChecked()) {
                if (rbNormal.isChecked()) {
                    departamento.setTerminaciones(3);
                } else if (rbRegular.isChecked()) {
                    departamento.setTerminaciones(2);
                } else {
                    departamento.setTerminaciones(1);
                }
            } else {
                departamento.setTerminaciones(0);
            }

            departamento.calcularPuntaje();
            viewModel.actualizarDepartamento(departamento);


            if(departamento.getPuntaje()<130){
                botonAlerta.setEnabled(true);
                botonAlerta.setEnabled(true);
            }
        });
    }

    public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        intent.putExtra(Intent.EXTRA_TEXT, "The email body");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}