package com.example.checkapartment.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment.fragments.ui.ListFragment;
import com.example.checkapartment.fragments.ui.ListFragmentDirections;
import com.example.checkapartment.model.Departamento;

public class DepListAdapter  extends ListAdapter<Departamento, DepViewHolder> {


    @NonNull
    @Override
    public DepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DepViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DepViewHolder holder, int position) {
        Departamento departamento = getItem(position);
        holder.unirDatos(departamento);
        holder.binding.card.setOnClickListener(view -> {
            NavDirections action = ListFragmentDirections.actionListFragmentToDetailsFragment(departamento.getId());
            Navigation.findNavController(view).navigate(action);
        });
    }


    public DepListAdapter(@NonNull DiffUtil.ItemCallback<Departamento> diffCallback) {
        super(diffCallback);
    }

    protected DepListAdapter(@NonNull AsyncDifferConfig<Departamento> config) {
        super(config);
    }

    public static class DepDiff extends DiffUtil.ItemCallback<Departamento>{

        @Override
        public boolean areItemsTheSame(@NonNull Departamento oldItem, @NonNull Departamento newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Departamento oldItem, @NonNull Departamento newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }
}
