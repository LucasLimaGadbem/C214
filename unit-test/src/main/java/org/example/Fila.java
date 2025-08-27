package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Fila<T> {

    List<T> fila = new ArrayList<>();
    int tamanho = 0;

    public void enfileirar(T elemento){
        fila.add(elemento);
        tamanho++;
    }

    public T removerFila(){
        if(filaVazia())
            throw new EmptyStackException();

        T elemento = fila.remove(0);
        tamanho--;
        return elemento;
    }

    public int size(){
        return tamanho;
    }

    public boolean filaVazia(){
        return (tamanho == 0);
    }
}
