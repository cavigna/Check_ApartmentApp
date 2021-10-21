package com.example.checkapartment.fragments.ui;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.R;
import com.example.checkapartment.databinding.FragmentListBinding;


public class ListFragment extends Fragment {

    FragmentListBinding binding;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        img = binding.imageViewPrueba;
        String url = "https://http2.mlstatic.com/D_NQ_NP_852648-MLC41532980127_042020-O.webp";
        Glide.with(this).load(url).into(img);

        return binding.getRoot();
    }
}