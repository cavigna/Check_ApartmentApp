package com.example.checkapartment.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.checkapartment.dao.DepartamentoDao;
import com.example.checkapartment.db.BaseDeDatos;
import com.example.checkapartment.model.Departamento;

import java.util.List;

public class DeptoRepository {
    DepartamentoDao dao;
    private LiveData<List<Departamento>> allDeptos;
    private int idDpto;
    //private LiveData<Departamento> departamentoById;

    public DeptoRepository(Application application) {
        BaseDeDatos db = BaseDeDatos.getBaseDeDatos(application);
        dao = db.departamentoDao();
        allDeptos = dao.allDepartamentos();
        //departamentoById = dao.departamentoById(idDpto);
    }

    public LiveData<List<Departamento>> getAllDeptos() {
        return allDeptos;
    }

//    public LiveData<Departamento> getDepartamentoById(int deptoId) {
//        return departamentoById;
//    }

    public LiveData<Departamento> DepartamentoById(int deptoId) {
        return dao.departamentoById(deptoId);
    }



    public void actualizarDepartamento(Departamento dpto) {
        BaseDeDatos.ejecutorDeEscrituraDB.execute(() -> {
            dao.actualizarDepartamento(dpto);
        });
    }

    public void actualizarCampo(int score) { //Borrar
        BaseDeDatos.ejecutorDeEscrituraDB.execute(() -> {
            dao.updateFieldDep(score);
        });
    }


    public void actualizarLuces( int id, int socre) { //Borrar
        BaseDeDatos.ejecutorDeEscrituraDB.execute(() -> {
            dao.actualizarLuces(id, 10);
        });
    }



}
