package org.example;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    //Construtor
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    //Getter e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Método para calcular o valor total do produto
    public double calcularValorTotal() {
        return quantidade * preco;
    }

    //Método para exibir informações do produto
    @Override
    public String toString() {
        return "Produto: " + nome +
                " | Quantidade: " + quantidade +
                " | Preço: " + String.format("%.2f", preco) +
                " | Valor total: R$" + String.format("%.2f", calcularValorTotal());
    }
}
