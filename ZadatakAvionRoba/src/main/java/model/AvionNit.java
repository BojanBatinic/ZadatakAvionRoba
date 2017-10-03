package model;

import model.Aerdrom;
import java.util.Random;

public class AvionNit extends Thread {

        private Avion avion;

    public AvionNit(Avion avion) {
        this.avion = avion;
    }

    private void provera(){
        System.out.println("Pocinju provere opreme za avion " + avion.getId());
            try {
                Random random = new Random();
                long vreme = Math.round(1000 + random.nextDouble());
                Thread.currentThread().sleep(vreme);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    private void poletanje(){

         System.out.println("Avion " + avion.getId() + " je spreman za poletanje i ceka dozvolu za poletanje.");
           do{

                 if (Aerdrom.dozvoljenoPoletanje){
                            // Citamo u synchronized bloku
                 synchronized (Aerdrom.dozvoljenoPoletanje){
                     Aerdrom.dozvoljenoPoletanje = false;
                            }

                 System.out.println("Avion " + avion.getId() + " izlazi na pistu i polece.");
                 try {
                 this.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                            // Pisemo u synchronized bloku
                 synchronized (Aerdrom.dozvoljenoPoletanje) {
                     Aerdrom.dozvoljenoPoletanje = true;
                     System.out.println("Avion " + avion.getId() + " je poleteo.");
                            }
                        }

                } while(!Aerdrom.dozvoljenoPoletanje);



                System.out.println("Svi avioni su poleteli.");
            }


        public void run() {
            provera();
            poletanje();
        }


    }