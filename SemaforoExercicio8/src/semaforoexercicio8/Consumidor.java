package semaforoexercicio8;


import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumidor implements Runnable {

   private Carro carro;

   public Consumidor(Carro carro) {
      this.carro = carro;
   }

   public void run() {
      while (true) {
       
          try {
            carro.remove();
            Thread.sleep(1000);
         } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
}
