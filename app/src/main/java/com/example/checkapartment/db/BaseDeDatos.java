package com.example.checkapartment.db;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            ejecutorDeEscrituraDB.execute(()->{

                DepartamentoDao dao = instance.departamentoDao();

                Departamento depto1 = new Departamento(
                        "Edificio Link SM",
                        "505",
                        "San Martín 970",
                        "https://http2.mlstatic.com/D_NQ_NP_927221-MLC45497689153_042021-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto1);

                 Departamento depto2 = new Departamento(
                        "Barrio Zenteno",
                        "709",
                        "Zenteno 1252",
                        "https://http2.mlstatic.com/D_NQ_NP_852648-MLC41532980127_042020-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto2);

                Departamento depto3 = new Departamento(
                        "Edificio Upper Design",
                        "312",
                        "Santa Isabel 330",
                        "https://http2.mlstatic.com/D_NQ_NP_787028-MLC41467659060_042020-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto3);

                Departamento depto4 = new Departamento(
                        "Edificio My Way",
                        "202",
                        "Portugal 520",
                        "https://http2.mlstatic.com/D_NQ_NP_894708-MLC44771591334_022021-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto4);

                Departamento depto5 = new Departamento(
                        "Edificio Tradición",
                        "404",
                        "Eyzaguirre 771",
                        "https://http2.mlstatic.com/D_NQ_NP_940668-MLC45093828481_032021-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto5);


                Departamento depto6 = new Departamento(
                        "Edificio Yungay",
                        "505",
                        "Calle Yungay 2570",
                        "https://http2.mlstatic.com/D_NQ_NP_794974-MLC42347260020_062020-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto6);

                Departamento depto7 = new Departamento(
                        "Edificio Green Concept Sazié\n",
                        "606",
                        "Abate Molina 186",
                        "https://http2.mlstatic.com/D_NQ_NP_724285-MLC47681948907_092021-O.webp",
                        0,0,0,0,0
                );
                dao.agregarDepartamento(depto7);

            });
        }

    };
}
