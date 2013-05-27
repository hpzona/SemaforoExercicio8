package semaforoexercicio8;

import java.util.concurrent.Semaphore;

public class Carro {

   private static final int CARRO_TAMANHO = 9; // máximo 9 passageiros
   private Object[] carro;
   private int entra, sai;
   private int numPassageiro;
   private Semaphore slotsVazios;
   private Semaphore slotsOcupados;
   private boolean carroCheio;

   public Carro() {
      entra = 0;
      sai = 0;
      numPassageiro = 0;
      carro = new Object[CARRO_TAMANHO];
      slotsVazios = new Semaphore(CARRO_TAMANHO);
      slotsOcupados = new Semaphore(0);
      carroCheio = false;
   }

   public void embarcar() throws InterruptedException {
      setNumPassageiro(getNumPassageiro()+1);
      if (!isCarroCheio()) {
         slotsVazios.acquire();
         carro[entra] = getNumPassageiro();
         entra = (entra + 1) % CARRO_TAMANHO;
         if (entra == 0) {
            entra = CARRO_TAMANHO;
         }
         System.out.println("Passageiro " + " " + entra + " embarcou.");
      } else {
         slotsOcupados.release();
      }
   }

   public void desembarcar() throws InterruptedException {
      Object item;
      slotsOcupados.acquire();

      for (int i = 0; i < CARRO_TAMANHO; i++) {
         item = carro[sai];
         sai = (sai + 1) % CARRO_TAMANHO;
         if (sai == 0) {
            sai = CARRO_TAMANHO;
         }
         System.out.println("Passageiro " + " " + sai + " desembarcou.");
         slotsVazios.release();
      }
      setNumPassageiro(0);
      entra = 0;
      sai = 0;
      carroCheio = false;
      System.out.println();
   }
   
   public int getNumPassageiro() {
      return numPassageiro;
   }

   public void setNumPassageiro(int numPassageiro) {
      this.numPassageiro = numPassageiro;
   }

   public boolean isCarroCheio() {
      return carroCheio;
   }

   public void setCarroCheio(boolean carroLiberado) {
      this.carroCheio = carroLiberado;
   }
}
