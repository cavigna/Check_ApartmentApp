package com.example.checkapartment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.R;
import com.example.checkapartment.databinding.ItemRowBinding;
import com.example.checkapartment.model.Departamento;

public class DepViewHolder extends RecyclerView.ViewHolder {
    ItemRowBinding binding;


    private TextView tvNombre, tvUnidad, tvDireccion, tvPuntaje;
    private ImageView imagenDpto;

    public DepViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemRowBinding.bind(itemView);
        tvNombre = binding.tvNombreRow;
        tvUnidad = binding.tvUnidadRow;
        tvDireccion = binding.tvDireccionRow;
        tvPuntaje = binding.tvPuntajeRow;
        imagenDpto =  binding.imgViewRow;

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
        Glide.with(itemView).load(departamento.getUrl()).fitCenter().into(imagenDpto);
        tvNombre.setText("Nombre: " + nombre);
        tvUnidad.setText("Unidad: " + unidad);
        tvDireccion.setText("Dirección: " +direccion);
        tvPuntaje.setText("Puntaje: " + puntaje);


    }
}
