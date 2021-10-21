package com.example.checkapartment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checkapartment.model.Departamento;

import java.util.List;

@Dao
public interface DepartamentoDao {
    @Insert
    void agregarDepartamento(Departamento departamento);

    @Delete
    void borrarDepartamento(Departamento departamento);

    @Update
    void actualizarDepartamento(Departamento departamento);

//    @Query("UPDATE SET COLUMN_TITLE=:text WHERE id=:id")
//    void UpdateColumnById (String text, int id);


//    @Query("SELECT nombre, unidad, direccion, puntaje  FROM departamentos")
//    LiveData<List<Departamento>> allDepartamentos();

    @Query("SELECT * FROM departamentos WHERE id = :id")
    LiveData<Departamento> departamentoById(int id);


    @Query("SELECT * FROM departamentos WHERE puntaje < 130")
    LiveData<Departamento> departamentoNotOk();


}
