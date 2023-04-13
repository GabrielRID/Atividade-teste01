package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroTest {

    private Livro livro;

    @BeforeEach
    public void setup() {
        livro = new Livro("A cinco passos de você",
                "Rachael Lippincott",
                "Romance",
                2005);
    }

    @Test
    public void test_get_titulo() {
        assertEquals("A cinco passos de você",livro.getTitulo());
    }

    @Test
    public void test_get_autor() {
        assertEquals("Rachael Lippincott",livro.getAutor());
    }

    @Test
    public void test_get_genero() {
        assertEquals("Romance",livro.getGenero());
    }

    @Test
    public void test_get_ano_publicacao() {
        assertEquals(2005,livro.getAnoPublicacao());
    }

    @Test
    public void test_set_titulo() {
        livro.setTitulo("a");
        assertEquals("a",livro.getTitulo());
    }

    @Test
    public void test_set_autor() {
        livro.setAutor("a");
        assertEquals("a",livro.getAutor());
    }

    @Test
    public void test_set_genero() {
        livro.setGenero("a");
        assertEquals("a",livro.getGenero());
    }

    @Test
    public void test_set_ano_publicacao() {
        livro.setAnoPublicacao(1);
        assertEquals(1,livro.getAnoPublicacao());
    }
}