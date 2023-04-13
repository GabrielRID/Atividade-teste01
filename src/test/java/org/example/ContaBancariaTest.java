package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    private ContaBancaria contaBancaria;

    @BeforeEach
    public void setUp() {
        contaBancaria = new ContaBancaria("123", "Gabriel");
    }

    @Test
    public void test_depositar() {
        assertTrue(contaBancaria.depositar(30));
        assertFalse(contaBancaria.depositar(0));
        assertFalse(contaBancaria.depositar(-1));
    }

    @Test
    public void test_sacar() {
        test_depositar();
        assertTrue(contaBancaria.sacar(30));
        assertFalse(contaBancaria.sacar(40));
        assertFalse(contaBancaria.sacar(-1));
    }

    @Test
    public void test_transferir() {
        test_depositar();
        ContaBancaria contaBancaria2 = new ContaBancaria("456", "Aline");
        assertTrue(contaBancaria.transferir(contaBancaria2,10));
        assertFalse(contaBancaria.transferir(contaBancaria2,50));
    }

    @Test
    public void test_aplicar_juros() {
        test_depositar();
        contaBancaria.aplicarJuros();
        assertEquals(30,contaBancaria.getSaldo());
    }

    @Test
    public void test_alterar_titular() {
        assertTrue(contaBancaria.alterarTitular("gabrielzinho da quebrada"));
        assertFalse(contaBancaria.alterarTitular(" "));
        assertFalse(contaBancaria.alterarTitular(null));
    }

    @Test
    public void test_get_numero_conta() {
        assertEquals("123", contaBancaria.getNumeroConta());
    }

    @Test
    public void test_get_titular() {
        assertEquals("Gabriel", contaBancaria.getTitular());
    }

    @Test
    public void test_get_saldo() {
        test_depositar();
        assertEquals(30, contaBancaria.getSaldo());
    }

    @Test
    public void test_get_taxa_juros() {
        assertEquals(0, contaBancaria.getTaxaJuros());
    }

    @Test
    public void test_set_taxa_juros() {
        contaBancaria.setTaxaJuros(1);
        assertEquals(1, contaBancaria.getTaxaJuros());
    }

}