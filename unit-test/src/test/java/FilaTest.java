import org.example.Fila;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilaTest {
    @Test
    public void testeFilaVazia(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        boolean vazia = filaInteiros.filaVazia();
        assertTrue(vazia);
    }

    @Test
    public void testeFilaPush(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.enfileirar(13);
        int tamanho = filaInteiros.size();
        assertEquals(1, tamanho);
    }

    @Test
    public void testeFilaPop(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.enfileirar(13);
        filaInteiros.removerFila();
        int tamanho = filaInteiros.size();

        assertEquals(0, tamanho);
    }

    @Test(expected = EmptyStackException.class)
    public void testePilhaPopException(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.removerFila();
    }

    @Test
    public void testeFilaRetorno(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        int valor = 13;
        filaInteiros.enfileirar(valor);
        int retorno = filaInteiros.removerFila();

        assertEquals(valor, retorno);
    }
}
