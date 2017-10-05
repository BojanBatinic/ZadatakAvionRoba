package model;

import model.Aerdrom;
import java.util.Random;

import static model.Aerdrom.dozvoljenoPoletanje;

public class AvionNit extends Thread {

    private Avion avion;

    public AvionNit(Avion avion) {
        this.avion = avion;
    }

   private void provera(){
        System.out.println("Pocinju provere opreme za avion " + avion.getId());
            try {
                Random random = new Random();
                sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    private void poletanje() {

        System.out.println("Avion " + avion.getId() + " je spreman za poletanje i ceka dozvolu za poletanje.");
        do {
            synchronized (dozvoljenoPoletanje) {
            if (dozvoljenoPoletanje) {
                // Citamo u synchronized bloku
                dozvoljenoPoletanje = false;
              System.out.println("Avion " + avion.getId() + " izlazi na pistu i polece.");

                }

                try {
                    this.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Pisemo u synchronized bloku

                synchronized (dozvoljenoPoletanje) {
                   // dozvoljenoPoletanje = true;
                    System.out.println("Avion " + avion.getId() + " je poleteo.");
                    dozvoljenoPoletanje = true;
                }
            }

        } while (!dozvoljenoPoletanje);

    }

        public void run () {
            provera();
            poletanje();
    }

                //System.out.println("Svi avioni su poleteli.");
            }




  /*  public void run() {

        Random random = new Random();

        System.out.println("Pocinju provere za avion " + avion.getId() + ".");

        try {
            sleep(random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Avion " + avion.getId() + " je zavrsio proveru i ceka dozvolu za poletanje.");

        do {
            synchronized (dozvoljenoPoletanje) {
                if (dozvoljenoPoletanje) {
                    System.out.println("Avion " + avion.getId() + " izlazi na pistu i polece.");
                    dozvoljenoPoletanje = false;

                    try {
                        sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (dozvoljenoPoletanje) {
                        System.out.println("Avion " + avion.getId() + " je poleteo.");
                        dozvoljenoPoletanje = true;
                    }
                }
            }
        } while (!dozvoljenoPoletanje);
    }*/


                //System.out.println("Svi avioni su poleteli.");




