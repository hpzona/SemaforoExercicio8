package semaforoexercicio8;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Passageiro implements Runnable {

    private Carro carro;

    public Passageiro(Carro carro) {
        this.carro = carro;
    }

    public void run() {
        while (true) {
            try {
                carro.embarcar();
                if (carro.getNumPassageiro() == 9) {
                   carro.setCarroCheio(true);
                }
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Passageiro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
