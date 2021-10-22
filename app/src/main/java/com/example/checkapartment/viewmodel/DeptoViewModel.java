package com.example.checkapartment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.checkapartment.model.Departamento;
import com.example.checkapartment.repository.DeptoRepository;

import java.util.List;

public class DeptoViewModel extends AndroidViewModel {
    private DeptoRepository repository;
    private LiveData<List<Departamento>> allDeptos;
    private LiveData<Departamento> deptoById;
    private int deptoId;
    private String campo;



    public DeptoViewModel(@NonNull Application application) {
        super(application);
        repository = new DeptoRepository(application);
        allDeptos = repository.getAllDeptos();
        //deptoById = repository.getDepartamentoById(deptoId);
    }

    public LiveData<List<Departamento>> getAllDeptos() {
        return allDeptos;
    }

    public void actualizarDepartamento(Departamento depto){repository.actualizarDepartamento(depto);}


    public void actualizarLuces(int id, int score){
        repository.actualizarLuces(id, score);
    }

    public void actualizarCampo(int score){
        repository.actualizarCampo(score);
    }


    public LiveData<Departamento> deptoById(int id){
        return repository.DepartamentoById(id);
    }

    public LiveData<Departamento> getDeptoById() {
        return deptoById;
    }

    public int getDeptoId() {
        return deptoId;
    }

    public void setDeptoId(int deptoId) {
        this.deptoId = deptoId;
    }
}
