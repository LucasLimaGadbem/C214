import org.example.Pilha;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PilhaTest {
    @Test
    public void testePilha_PilhaVazia(){
        Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
        boolean vazia = pilhaInteiros.pilhaVazia();
        assertTrue(vazia);
    }

    @Test
    public void testePilha_Push(){
        Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
        pilhaInteiros.push(13);
        int tamanho = pilhaInteiros.size();
        assertEquals(1, tamanho);
    }

    @Test
    public void testePilha_Pop(){
        Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
        pilhaInteiros.push(13);
        pilhaInteiros.pop();
        int tamanho = pilhaInteiros.size();

        assertEquals(0, tamanho);
    }

    @Test(expected = EmptyStackException.class)
    public void testePilha_PopException(){
        Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
        pilhaInteiros.pop();
    }

    @Test
    public void testePilha_Retorno(){
        Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
        int valor = 13;
        pilhaInteiros.push(valor);
        int retorno = pilhaInteiros.pop();

        assertEquals(valor, retorno);
    }
}
