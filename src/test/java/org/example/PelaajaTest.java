package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PelaajaTest {

        @Test
        void testPelaajanValinta() {
            Pelaaja pelaaja = new Pelaaja();
            String valinta = pelaaja.pelaajanValinta();
            assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
        }

        @Test
        void testKasvataJaHaeVoitot() {
            Pelaaja pelaaja = new Pelaaja();
            pelaaja.kasvataVoittoja();
            assertEquals(1, pelaaja.getVoitot());
        }

}
