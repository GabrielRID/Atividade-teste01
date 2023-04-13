package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MusicaTest {

    private Musica musica;

    @BeforeEach
    public void setup(){
        musica = new Musica(
                "Flor e o Beija-Flor",
                "Henrique e Juliano feat. Marília Mendonça",
                3);
    }

    @Test
    public void test_get_titulo() {
        assertEquals("Flor e o Beija-Flor", musica.getTitulo());
    }

    @Test
    public void test_get_artista() {
        assertEquals("Henrique e Juliano feat. Marília Mendonça", musica.getArtista());
    }

    @Test
    public void test_get_duracao() {
        assertEquals(3, musica.getDuracao());
    }

    @Test
    public void test_set_titulo() {
        musica.setTitulo("a");
        assertEquals("a", musica.getTitulo());
    }

    @Test
    public void test_set_artista() {
        musica.setArtista("a");
        assertEquals("a", musica.getArtista());
    }

    @Test
    public void test_set_duracao() {
        musica.setDuracao(1);
        assertEquals(1, musica.getDuracao());
    }

}
