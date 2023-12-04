package org.example;

/**
 * Luokka edustaa kivi-paperi-sakset -pelin peli-instanssia.
 * Peli sisältää kaksi pelaajaa ja logiikan pelin suorittamiseen.
 */
public class Peli {
    private Pelaaja p1;
    private Pelaaja p2;

    /**
     * Luo uuden pelin annetuille pelaajille.
     *
     * @param p1 Ensimmäinen pelaaja.
     * @param p2 Toinen pelaaja.
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Suorittaa kivi-paperi-sakset -pelin.
     * Pelaa eriä kunnes yksi pelaajista saavuttaa kolme voittoa.
     */
    public void suoritaPeli() {
        boolean peliLoppui = false;
        int pelatutPelit = 0; // Pelattujen pelien lkm
        int tasapelit = 0;    // Tasapelien lkm

        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            String p1Valinta = p1.pelaajanValinta();
            String p2Valinta = p2.pelaajanValinta();

            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");

            tarkistaVoitto(p1Valinta, p2Valinta);

            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            }
            pelatutPelit++;

            if (onPeliLoppu(p1, p2)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }

            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Tarkistaa erän voittajan ja päivittää pelaajien voittojen lukumäärää.
     *
     * @param p1Valinta Ensimmäisen pelaajan valinta.
     * @param p2Valinta Toisen pelaajan valinta.
     */
    private void tarkistaVoitto(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            System.out.println("Tasapeli!");
            return;
        }

        boolean p1Voittaa = (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) ||
                (p1Valinta.equals("sakset") && p2Valinta.equals("paperi"));

        if (p1Voittaa) {
            p1.kasvataVoittoja();
            System.out.println("Pelaaja 1 voittaa!");
        } else {
            p2.kasvataVoittoja();
            System.out.println("Pelaaja 2 voittaa!");
        }
    }

    /**
     * Tarkistaa, onko peli loppunut.
     * Peli loppuu, kun jompikumpi pelaajista saavuttaa kolme voittoa.
     *
     * @param p1 Ensimmäinen pelaaja.
     * @param p2 Toinen pelaaja.
     * @return Totuusarvo siitä, onko peli loppunut.
     */
    private boolean onPeliLoppu(Pelaaja p1, Pelaaja p2) {
        return p1.getVoitot() >= 3 || p2.getVoitot() >= 3;
    }
}