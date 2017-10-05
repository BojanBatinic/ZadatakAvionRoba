package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;
import java.util.List;
import java.io.IOException;

public class Zadatak3IzmenaVrednosti {

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

            List<Roba> zaIzmenu = robaDao.queryForEq(Roba.POLJE_OPIS,"Plasticna stolica");
            zaIzmenu.get(0).setOpis("Drvena stolica");
            robaDao.update(zaIzmenu.get(0));

            //drugi nacin za izmenu vrenosti
            /* Roba izmena = robaDao.queryForEq(Roba.POLJE_NAZIV, "Stolica").get(0);

            izmena.setOpis("Drvena stoica");
            robaDao.update(izmena);*/

            robe = robaDao.queryForAll();
            System.out.println("Prikaz sve robe da " +
                    "proverimo da je  " +
                    "sva roba uneta.");
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
