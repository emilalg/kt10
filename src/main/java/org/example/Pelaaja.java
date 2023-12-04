package org.example;

/**
 * Luokka edustaa kivi-paperi-sakset -pelin pelaajaa.
 * Pelaaja tekee satunnaisen valinnan pelissä ja pitää kirjaa voitoistaan.
 */
public class Pelaaja {
    private int voitot;

    /**
     * Suorittaa pelaajan valinnan kivi-paperi-sakset -pelissä.
     * Valinta on satunnainen.
     *
     * @return Pelaajan valinta pelissä: "kivi", "paperi" tai "sakset".
     */
    public String pelaajanValinta() {
        int valinta = (int) (Math.random() * 3);
        switch (valinta) {
            case 0: return "kivi";
            case 1: return "paperi";
            case 2: return "sakset";
            default: return "";
        }
    }

    /**
     * Kasvattaa pelaajan voittojen lukumäärää yhdellä.
     */
    public void kasvataVoittoja() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen kokonaismäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return voitot;
    }
}