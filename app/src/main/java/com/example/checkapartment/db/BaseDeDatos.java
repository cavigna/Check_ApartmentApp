package com.example.checkapartment.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.checkapartment.dao.DepartamentoDao;
import com.example.checkapartment.model.Departamento;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Departamento.class, version = 1, exportSchema = false)
public abstract class BaseDeDatos extends RoomDatabase {

    private static volatile BaseDeDatos instance;

    public abstract DepartamentoDao departamentoDao();

    private static final String DB_NAME = "departamentos_db";

    private static int NUMBER_OF_THREADS = 4;

    public static final ExecutorService ejecutorDeEscrituraDB =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BaseDeDatos getBaseDeDatos(final Context context) {
        if (instance == null) {
            synchronized (BaseDeDatos.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BaseDeDatos.class,
                            DB_NAME
                    ).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
