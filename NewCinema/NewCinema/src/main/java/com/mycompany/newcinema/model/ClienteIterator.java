/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newcinema.model;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ClienteIterator implements Iterator<Cliente>{
    private int indiceAtual = 0;
    private List<Cliente> clientes;

    public ClienteIterator(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public boolean hasNext(){
        return indiceAtual < clientes.size();
    }
    
    @Override
    public Cliente next(){
        if (!hasNext()){
            throw new IndexOutOfBoundsException("Sem mais clientes.");
        }
        return clientes.get(indiceAtual++);
    }
}