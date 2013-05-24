package semaforoexercicio8;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor implements Runnable {

    private Carro carro;

    public Produtor(Carro carro) {
        this.carro = carro;
    }

    public void run() {
        String passageiro = "Passageiro";
        int i = 0;
        while (true) {

            try {
                carro.embarcar(passageiro);
                i++;
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (i == 9) {
                System.out.println("Passeio iniciado...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Passeio finalizado.");
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
                i=-1;
                carro.setCarroCheio(true);
                
            }

        }
    }
}
