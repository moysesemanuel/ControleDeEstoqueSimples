package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeEstoque {
    private ArrayList<Produto> produtos;
    private Scanner scanner;

    public ControleDeEstoque() {
        produtos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    //Método para exibir o menu
    public void menu() {
        int opcao;

        do {
            System.out.println("\n--- Controle de Estoque ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Protudos");
            System.out.println("3. Atualizar Estoque");
            System.out.println("4. Mostrar Valor Total do Estoque");
            System.out.println("5. Sair");
            System.out.println("Escoha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarEstoque();
                    break;
                case 4:
                    mostrarValorTotalEstoque();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    //Método para cadastrar um produto
    private void cadastrarProduto() {
        scanner.nextLine(); //Limpar buffer
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Quantidade");
        int quantidade = scanner.nextInt();
        System.out.println("Preço: R$ ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(nome, quantidade, preco);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    //Método para lsitar todos os produtos
    private void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Produtos Cadastrados ---");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    //Método para atualizar o estoque (entrada ou saída)
    private void atualizarEstoque() {
        scanner.nextLine(); //Limpat buffer
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        Produto produtoEncontrado = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println("Quantidade de entrada ou saída (negativa para saída): ");
            int quantidade = scanner.nextInt();
            int novaQuantidade = produtoEncontrado.getQuantidade() + quantidade;

            if (novaQuantidade < 0) {
                System.out.println("Quantidade insuficiente no estoque.");
            } else {
                produtoEncontrado.setQuantidade(novaQuantidade);
                System.out.println("Estoque atualizado com sucesso.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    //Método para mostrar o valor total do estoque
    private void mostrarValorTotalEstoque() {
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.calcularValorTotal();
        }
        System.out.println("Valor total do estoque: R$" + String.format("%.2f", valorTotal));
    }

    public static void main(String[] args) {
        ControleDeEstoque controle = new ControleDeEstoque();
        controle.menu(); //Chama o menu para iniciar o programa
    }
}
