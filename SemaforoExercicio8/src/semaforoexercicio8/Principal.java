package semaforoexercicio8;

public class Principal {

   public static void main(String args[]) {
      Carro carro = new Carro();
      Thread consumidor = new Thread(new Consumidor(carro));
      Thread produtor = new Thread(new Produtor(carro));
      
      
      produtor.start();
      consumidor.start();

   }
}
