package semaforoexercicio8;

public class Principal {

   public static void main(String args[]) {
      Carro carro = new Carro();
      Thread consumidor = new Thread(new Motorista(carro));
      Thread passageiro = new Thread(new Passageiro(carro));
      
      
      passageiro.start();
      consumidor.start();

   }
}
