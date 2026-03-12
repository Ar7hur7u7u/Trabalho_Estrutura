import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArranjoOrdenadoTest {

    @Test
    void deveInserirOrdenadoCrescente() {
        ArranjoOrdenado arranjo = new ArranjoOrdenado(10, true);
        arranjo.insert(5);
        arranjo.insert(1);
        arranjo.insert(3);

        assertEquals("[1, 3, 5]", arranjo.toString());
    }

    @Test
    void deveInserirOrdenadoDecrescente() {
        ArranjoOrdenado arranjo = new ArranjoOrdenado(10, false);
        arranjo.insert(5);
        arranjo.insert(1);
        arranjo.insert(3);

        assertEquals("[5, 3, 1]", arranjo.toString());
    }

    @Test
    void deveRemoverCorretamente() {
        ArranjoOrdenado arranjo = new ArranjoOrdenado(10, true);
        arranjo.insert(2);
        arranjo.insert(4);
        arranjo.insert(6);

        assertTrue(arranjo.remove(4));
        assertEquals("[2, 6]", arranjo.toString());
        assertFalse(arranjo.remove(10));
    }

    @Test
    void deveBuscarElemento() {
        ArranjoOrdenado arranjo = new ArranjoOrdenado(10, true);
        arranjo.insert(10);
        arranjo.insert(20);
        arranjo.insert(30);

        int indice = arranjo.buscar(20);
        assertTrue(indice >= 0);
        assertEquals(-1, arranjo.buscar(99));
    }

    @Test
    void deveIdentificarEstruturaVaziaECheia() {
        ArranjoOrdenado arranjo = new ArranjoOrdenado(2, true);
        assertTrue(arranjo.isEmpty());
        assertFalse(arranjo.isFull());

        arranjo.insert(1);
        arranjo.insert(2);

        assertFalse(arranjo.isEmpty());
        assertTrue(arranjo.isFull());
        assertEquals(2, arranjo.size());
        assertFalse(arranjo.insert(3));
    }
}
