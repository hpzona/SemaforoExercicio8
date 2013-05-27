package semaforoexercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Motorista implements Runnable {

   private Carro motorista;

   public Motorista(Carro motorista) {
      this.motorista = motorista;
   }

   public void run() {
      while (true) {

         try {
            if (motorista.getNumPassageiro() == 9) {
               System.out.println("Passeio iniciado...");
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException ex) {
                  Logger.getLogger(Passageiro.class.getName()).log(Level.SEVERE, null, ex);
               }
               System.out.println("Passeio finalizado.");
               System.out.println();
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException ex) {
                  Logger.getLogger(Passageiro.class.getName()).log(Level.SEVERE, null, ex);
               }
               motorista.desembarcar();
            }
            Thread.sleep(1);
         } catch (InterruptedException ex) {
            Logger.getLogger(Motorista.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
}
