package com.example.checkapartment.fragments.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.R;
import com.example.checkapartment.databinding.FragmentDetailsBinding;
import com.example.checkapartment.viewmodel.DeptoViewModel;


public class DetailsFragment extends Fragment {
    FragmentDetailsBinding binding;
    DeptoViewModel viewModel;
    ImageView img;
    CheckBox cbDorm, cbBath, cbLuces, cbCocina;
    CheckBox cbNormal, cbRegular, cbDef;
    Button boton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        img = binding.imageView;
        cbBath = binding.cbBath;
        cbCocina =binding.cbCocina;
        cbDorm = binding.cbDormitorio;
        cbLuces = binding.cbLuces;
        cbNormal = binding.cbNormal;
        cbRegular = binding.cbRegular;
        cbDef = binding.cbDef;
        boton =binding.button;

        int id = DetailsFragmentArgs.fromBundle(getArguments()).getDeptoId();

        viewModel = new ViewModelProvider(getActivity()).get(DeptoViewModel.class);

        viewModel.setDeptoId(id);

        viewModel.deptoById(id).observe(getViewLifecycleOwner(), departamento -> {
            Glide.with(this).load(departamento.getUrl()).into(img);
        });




        return binding.getRoot();
    }


}