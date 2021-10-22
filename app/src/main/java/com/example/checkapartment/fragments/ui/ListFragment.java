package com.example.checkapartment.fragments.ui;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.R;
import com.example.checkapartment.adapter.DepListAdapter;
import com.example.checkapartment.databinding.FragmentListBinding;
import com.example.checkapartment.viewmodel.DeptoViewModel;


public class ListFragment extends Fragment {

    FragmentListBinding binding;
    private RecyclerView recycler;
    private DeptoViewModel viewmodel;
    private DepListAdapter adapter;
    //ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        viewmodel = new ViewModelProvider(getActivity()).get(DeptoViewModel.class);

        recycler = binding.recyclerView;
        adapter =  new DepListAdapter(new DepListAdapter.DepDiff());
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);

        viewmodel.getAllDeptos().observe(getViewLifecycleOwner(), departamentos -> {
            adapter.submitList(departamentos);
        });




        return binding.getRoot();
    }
}

//        String url = "https://http2.mlstatic.com/D_NQ_NP_852648-MLC41532980127_042020-O.webp";
//        Glide.with(this).load(url).into(img);