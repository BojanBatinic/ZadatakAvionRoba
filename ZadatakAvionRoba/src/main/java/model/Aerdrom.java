package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import zadaci.Konstante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aerdrom {

    public static Boolean dozvoljenoPoletanje = true;

    static Dao<Avion,Integer> avionDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            avionDao = DaoManager.createDao(connectionSource, Avion.class);

            List<Avion> avioni = avionDao.queryForAll();

            AvionNit av1 = new AvionNit(avioni.get(0));
            AvionNit av2 = new AvionNit(avioni.get(1));


            av1.start();
            av2.start();

            av1.join();
            av2.join();

            System.out.println("Svi avioni su poleteli.");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
