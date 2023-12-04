package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PeliTest {

    @Mock
    private Pelaaja p1;

    @Mock
    private Pelaaja p2;

    private Peli peli;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        peli = new Peli(p1, p2);
    }

    @Test
    public void testSuoritaPeli_GameEnds() {
        // Set up player choices
        when(p1.pelaajanValinta()).thenReturn("kivi", "paperi", "sakset");
        when(p2.pelaajanValinta()).thenReturn("sakset", "kivi", "paperi");

        // Simulate alternating wins
        when(p1.getVoitot()).thenReturn(0, 1, 1, 2, 2, 3);
        when(p2.getVoitot()).thenReturn(0, 0, 1, 1, 2, 2);

        peli.suoritaPeli();

        // Verify the expected number of invocations
        verify(p1, times(3)).pelaajanValinta();
        verify(p2, times(3)).pelaajanValinta();
    }

}