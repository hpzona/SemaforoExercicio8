package semaforoexercicio8;


import java.util.concurrent.Semaphore;

public class Carro {

    private static final int CARRO_TAMANHO = 9; // máximo 10 passageiros
    private Object[] carro;
    private int entra, sai;
    private Semaphore mutex;
    private Semaphore slotsVazios;
    private Semaphore slotsOcupados;
    private boolean carroCheio;

    public Carro() {
        entra = 0;
        sai = 0;
        carro = new Object[CARRO_TAMANHO];
        mutex = new Semaphore(1);
        slotsVazios = new Semaphore(CARRO_TAMANHO);
        slotsOcupados = new Semaphore(0);
        carroCheio = false;
    }

    public void embarcar(Object item) throws InterruptedException {
        if (!isCarroCheio()) {
            slotsVazios.acquire();
            carro[entra] = item;
            entra = (entra + 1) % CARRO_TAMANHO;
            if (entra == 0) {
                entra = CARRO_TAMANHO;
            }
            System.out.println(item.toString() + " " + entra + " embarcou.");
        } else {
            slotsOcupados.release();
        }
    }

    public Object remove() throws InterruptedException {
        Object item = null;
        slotsOcupados.acquire();

        if (isCarroCheio()) {
            for (int i = 0; i < CARRO_TAMANHO; i++) {
                item = carro[sai];
                sai = (sai + 1) % CARRO_TAMANHO;
                if (sai == 0) {
                    sai = CARRO_TAMANHO;
                }
                System.out.println(item.toString() + " " + sai + " desembarcou.");
                slotsVazios.release();
            }
            entra = 0;
            sai = 0;
            carroCheio = false;
        }
        System.out.println();
        return item;
    }

    public boolean isCarroCheio() {
        return carroCheio;
    }

    public void setCarroCheio(boolean carroLiberado) {
        this.carroCheio = carroLiberado;
    }
}
