package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlaylistMusicaTest {

    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setup() {
        playlistMusica = new PlaylistMusica("Sertanejo");
    }

//    @Test
//    public void test_adicionar_musica() {
//        assertTrue(playlistMusica.adicionarMusica(
//                new Musica(
//                        "Flor e o Beija-Flor",
//                        "Henrique e Juliano feat. Marília Mendonça",
//                        3)
//        ));
//        assertFalse(playlistMusica.adicionarMusica(null));
//    }

    @Test
    public void test_adicionar_musica() {
        Musica musica1 = new Musica("Flor e o Beija-Flor",
                "Henrique e Juliano feat. Marília Mendonça", 3);

        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertEquals(1, playlistMusica.getMusicas().size());

        assertFalse(playlistMusica.adicionarMusica(null));
        assertEquals(1, playlistMusica.getMusicas().size());

        Musica musica2 = new Musica("Meu Abrigo",
                "Melim", 4);
        assertTrue(playlistMusica.adicionarMusica(musica2));
        assertEquals(2, playlistMusica.getMusicas().size());
    }

    @Test
    public void test_remover_musica() {
        test_adicionar_musica();
        assertTrue(playlistMusica.removerMusica(playlistMusica.getMusicas().get(0)));
        assertFalse(playlistMusica.removerMusica(null));
    }

    @Test
    public void test_busca_musica_titulo() {
        test_adicionar_musica();
        assertEquals(playlistMusica.getMusicas().get(0), playlistMusica.buscarMusicaPorTitulo(
                playlistMusica.getMusicas().get(0).getTitulo()
        ));
        assertNull(playlistMusica.buscarMusicaPorTitulo(""));
    }

    @Test
    public void test_busca_musica_artita() {
        test_adicionar_musica();
        List<Musica> listMusica = new ArrayList<>();
        listMusica.add(playlistMusica.getMusicas().get(0));
        assertEquals(listMusica, playlistMusica.buscarMusicasPorArtista(
                playlistMusica.getMusicas().get(0).getArtista()
        ));
        assertEquals(new ArrayList<Musica>(), playlistMusica.buscarMusicasPorArtista(""));
    }

    @Test
    public void test_quantidade_musica() {
        assertEquals(0, playlistMusica.getQuantidadeMusicas());
        test_adicionar_musica();
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }

    @Test
    public void test_ordenar_por_titulo() {
        Musica musica1 = new Musica("a","a", 3);
        Musica musica2 = new Musica("b","b", 3);
        Musica musica3 = new Musica("c","c", 3);
        Musica musica4 = new Musica("a","d", 3); // mesmo título, artista diferente

        playlistMusica.getMusicas().add(musica2);
        playlistMusica.getMusicas().add(musica4);
        playlistMusica.getMusicas().add(musica3);
        playlistMusica.getMusicas().add(musica1);

        playlistMusica.ordenarPorTitulo();

        assertEquals("a", playlistMusica.getMusicas().get(0).getTitulo());
        assertEquals("a", playlistMusica.getMusicas().get(1).getTitulo());
        assertEquals("b", playlistMusica.getMusicas().get(2).getTitulo());
        assertEquals("c", playlistMusica.getMusicas().get(3).getTitulo());
    }

//    @Test
//    public void test_ordenar_por_artista() {
//        Musica musica1 = new Musica("a","a", 3);
//        Musica musica2 = new Musica("b","b", 3);
//
//        playlistMusica.getMusicas().add(musica2);
//        playlistMusica.getMusicas().add(musica1);
//        playlistMusica.ordenarPorArtista();
//
//        assertEquals("a", playlistMusica.getMusicas().get(0).getArtista());
//        assertEquals("b", playlistMusica.getMusicas().get(1).getArtista());
//    }

    @Test
    public void test_ordenar_por_artista() {
        Musica musica1 = new Musica("a","b", 3);
        Musica musica2 = new Musica("b","a", 3);
        Musica musica3 = new Musica("c","c", 3);

        playlistMusica.getMusicas().add(musica2);
        playlistMusica.getMusicas().add(musica1);
        playlistMusica.getMusicas().add(musica3);

        playlistMusica.ordenarPorArtista();

        assertEquals("a", playlistMusica.getMusicas().get(0).getArtista());
        assertEquals("b", playlistMusica.getMusicas().get(1).getArtista());
        assertEquals("c", playlistMusica.getMusicas().get(2).getArtista());

        // assegura que a lista de musicas não foi alterada
        assertEquals(3, playlistMusica.getMusicas().size());
        assertTrue(playlistMusica.getMusicas().contains(musica1));
        assertTrue(playlistMusica.getMusicas().contains(musica2));
        assertTrue(playlistMusica.getMusicas().contains(musica3));
    }

    @Test
    public void test_get_nome() {
        assertEquals("Sertanejo", playlistMusica.getNome());
    }

    @Test
    public void test_set_nome() {
        playlistMusica.setNome("a");
        assertEquals("a", playlistMusica.getNome());
    }

    @Test
    public void test_get_musicas() {
        Musica musica1 = new Musica("a","a", 3);
        Musica musica2 = new Musica("b","b", 3);

        playlistMusica.getMusicas().add(musica2);
        playlistMusica.getMusicas().add(musica1);

        List<Musica> musicas = new ArrayList<>();
        musicas.add(musica2);
        musicas.add(musica1);

        assertEquals(musicas, playlistMusica.getMusicas());

    }



}