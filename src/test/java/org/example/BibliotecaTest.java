package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca");
    }

    @Test
    public void test_adicionar_livro() {
        assertTrue(biblioteca.adicionarLivro(new Livro("A cinco passos de você",
                "Rachael Lippincott",
                "Romance",
                2005)));

        assertFalse(biblioteca.adicionarLivro(null));
    }

    @Test
    public void test_remover_livro() {
        test_adicionar_livro();
        assertTrue(biblioteca.removerLivro(biblioteca.getLivros().get(0)));
        assertFalse((biblioteca.removerLivro(null)));
    }

    @Test
    public void test_buscar_livro_por_titulo() {
        test_adicionar_livro();
        assertEquals(biblioteca.getLivros().get(0), biblioteca.buscarLivroPorTitulo(
                biblioteca.getLivros().get(0).getTitulo()
        ));
        assertNull(biblioteca.buscarLivroPorTitulo(""));
    }

    @Test
    public void test_buscar_livro_por_autor() {
        test_adicionar_livro();
        assertEquals(biblioteca.getLivros(), biblioteca.buscarLivrosPorAutor(
                biblioteca.getLivros().get(0).getAutor()
        ));
    }

    @Test
    public void test_buscar_livro_por_genero() {
        test_adicionar_livro();
        assertEquals(biblioteca.getLivros(), biblioteca.buscarLivrosPorGenero(
                biblioteca.getLivros().get(0).getGenero()
        ));
    }

    @Test
    public void test_get_quantidade_livro() {
        test_adicionar_livro();
        assertEquals(1, biblioteca.getQuantidadeLivros());
    }

    @Test
    public void teste_get_nome() {
        assertEquals("Biblioteca", biblioteca.getNome());
    }

    @Test
    public void teste_set_nome() {
        biblioteca.setNome("a");
        assertEquals("a", biblioteca.getNome());
    }

    @Test
    public void teste_get_musicas() {
        Livro livro1 = new Livro("a","a", "a", 1);
        Livro livro2 = new Livro("b","b", "b", 1);

        biblioteca.getLivros().add(livro2);
        biblioteca.getLivros().add(livro1);

        List<Livro> livros = new ArrayList<>();
        livros.add(livro2);
        livros.add(livro1);

        assertEquals(livros, biblioteca.getLivros());

    }

}
