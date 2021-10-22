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

//    @Query("UPDATE SET COLUMN_TITLE WHERE =:text WHERE id=:id")
//    void UpdateColumnById (String text, int id);

    @Query("UPDATE departamentos SET luces =:score ")
    void updateFieldDep (int score);

    @Query("UPDATE departamentos SET luces =:score WHERE id =:id ")
    void actualizarLuces (int id, int score);






    @Query("SELECT *  FROM departamentos")
    LiveData<List<Departamento>> allDepartamentos();

    @Query("SELECT * FROM departamentos WHERE id = :id")
    LiveData<Departamento> departamentoById(int id);


    @Query("SELECT * FROM departamentos WHERE puntaje < 130")
    LiveData<Departamento> departamentoNotOk();




    //    @Query("UPDATE departamentos SET luces =:luces, bath =:bath, cocina =:cocina," +
//            " dormitorio =:dorm, terminaciones =:terminaciones WHERE id =:id")
//    void actualizarTerminaciones(int id, int luces, int bath, int cocina, int dorm, int terminaciones);



//    @Query("SELECT nombre, unidad, direccion, puntaje  FROM departamentos")
//    LiveData<List<Departamento>> allDepartamentos();

    //@Query("SELECT * FROM DEP")


}


/*
    @Query("UPDATE departamentos SET bath =:score WHERE id =:id ")
    void actualizarBath (int id, int score);

    @Query("UPDATE departamentos SET cocina =:score WHERE id =:id ")
    void actualizarCocina (int id, int score);

    @Query("UPDATE departamentos SET dormitorio =:score WHERE id =:id ")
    void actualizarDormitorio (int id, int score);

    @Query("UPDATE departamentos SET terminaciones =:score WHERE id =:id ")
    void actualizarTerminaciones (int id, int score);
 */