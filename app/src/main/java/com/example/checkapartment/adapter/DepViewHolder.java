package com.example.checkapartment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment.R;
import com.example.checkapartment.databinding.ItemRowBinding;
import com.example.checkapartment.model.Departamento;

public class DepViewHolder extends RecyclerView.ViewHolder {
    ItemRowBinding binding;


    private TextView tvNombre, tvUnidad, tvDireccion, tvPuntaje;

    public DepViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemRowBinding.bind(itemView);
        tvNombre = binding.tvNombreRow;
        tvUnidad = binding.tvUnidadRow;
        tvDireccion = binding.tvDireccionRow;
        tvPuntaje = binding.tvPuntajeRow;
    }

    public static DepViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new DepViewHolder(view);
    }

    public void unirDatos(Departamento departamento){
        String nombre = departamento.getNombre();
        String unidad = departamento.getUnidad();
        String direccion = departamento.getDireccion();
        String puntaje =  String.valueOf(departamento.getPuntaje());

        tvNombre.setText(nombre);
        tvUnidad.setText(unidad);
        tvDireccion.setText(direccion);
        tvPuntaje.setText(puntaje);
    }
}
