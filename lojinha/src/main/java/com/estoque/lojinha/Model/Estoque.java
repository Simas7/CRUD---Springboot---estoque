package com.estoque.lojinha.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int Codigo;

    @Column(nullable = false)
    private String Nome;

    @Column(nullable = false)
    private double Preço;
    
    @Column(nullable = false)
    private int Quantidade;
    

    
    // public Estoque(int codigo, String nome, double preço, int quantidade) {
    //     Codigo = codigo;
    //     Nome = nome;
    //     Preço = preço;
    //     Quantidade = quantidade;
    // }

    public int getCodigo() { 
        return Codigo;
    }


    public void setCodigo(int codigo) {
        Codigo = codigo;
    }


    public String getNome() {
        return Nome;
    }


    public void setNome(String nome) {
        Nome = nome;
    }


    public double getPreço() {
        return Preço;
    }


    public void setPreço(double preço) {
        Preço = preço;
    }


    public int getQuantidade() {
        return Quantidade;
    }


    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    
}
