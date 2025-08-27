import org.example.Fila;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilaTest {
    @Test
    public void testeFila_FilaVazia(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        boolean vazia = filaInteiros.filaVazia();
        assertTrue(vazia);
    }

    @Test
    public void testeFila_Enfileirar(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.enfileirar(13);
        int tamanho = filaInteiros.size();
        assertEquals(1, tamanho);
    }

    @Test
    public void testeFila_RemoverFila(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.enfileirar(13);
        filaInteiros.removerFila();
        int tamanho = filaInteiros.size();

        assertEquals(0, tamanho);
    }

    @Test(expected = EmptyStackException.class)
    public void testeFila_PopException(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        filaInteiros.removerFila();
    }

    @Test
    public void testeFila_Retorno(){
        Fila<Integer> filaInteiros = new Fila<Integer>();
        int valor = 13;
        filaInteiros.enfileirar(valor);
        int retorno = filaInteiros.removerFila();

        assertEquals(valor, retorno);
    }
}
