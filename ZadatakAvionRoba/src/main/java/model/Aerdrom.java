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

    static Dao<Avion,Integer> avionDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            avionDao = DaoManager.createDao(connectionSource, Avion.class);

            List<Avion> avioni = avionDao.queryForAll();
            System.out.println("Prikaz svih aviona.");
            for(Avion a : avioni)
                System.out.println(a);



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
