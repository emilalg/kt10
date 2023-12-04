package org.example;

/**
 *
 * @author Ira Dook
 */
public class Main {

    public static void main(String args[]) {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();

        Peli peli = new Peli(pelaaja1, pelaaja2);
        peli.suoritaPeli();
    }
}
