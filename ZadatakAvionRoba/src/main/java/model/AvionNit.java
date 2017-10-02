package model;


import java.util.Random;

public class AvionNit extends Thread {

        public boolean dozvoljenoSletanje;

    public AvionNit(boolean dozvoljenoSletanje) {
        this.dozvoljenoSletanje = dozvoljenoSletanje;
    }

    private void proveraOpreme(){

            try {
                Random random = new Random();
                long vreme = Math.round(1000 + random.nextDouble());
                Thread.currentThread().sleep(vreme);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void poletanje(){
            try {
                this.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Svi avion su poleteli.");
        }

        public void run() {
            proveraOpreme();
            poletanje();
        }
    }