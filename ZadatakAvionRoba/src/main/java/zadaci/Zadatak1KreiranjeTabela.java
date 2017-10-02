package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;

public class Zadatak1KreiranjeTabela {

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);


            TableUtils.dropTable(connectionSource, Avion.class,true);
            TableUtils.dropTable(connectionSource, Roba.class,true);


            TableUtils.createTable(connectionSource,Roba.class);
            TableUtils.createTable(connectionSource,Avion.class);

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

