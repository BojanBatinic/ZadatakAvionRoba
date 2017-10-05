package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Roba;

import java.io.IOException;
import java.util.List;

public class Zadatak4BrisanjeVrednosti {

    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            robaDao = DaoManager.createDao(connectionSource, Roba.class);

            List<Roba> robe = robaDao.queryForAll();
            System.out.println("Prikaz sve robe da " +
                    "proverimo da je  " +
                    "sva roba uneta.");
            for(Roba r : robe)
                System.out.println(r);

            Roba zaBrisanje = robaDao.queryForEq(Roba.POLJE_NAZIV,"Voda").get(0);
            robaDao.delete(zaBrisanje);


            robe = robaDao.queryForAll();
            System.out.println("Prikaz sve robe da " +
                    "proverimo da je  " +
                    "sva roba izbrisana.");
            for(Roba r : robe)
                System.out.println(r);

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
