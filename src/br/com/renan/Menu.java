package br.com.renan;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        int opcao;
        do {
            apresentarMenu();
            opcao = lerOpcaoMenu();
            menu(opcao, lista);
        } while (opcao != 0);
    }

    public static int lerOpcaoMenu() {
        Scanner console = new Scanner(System.in);
        System.out.print("\nDigite a opção desejada: ");
        int opcao = console.nextInt();
        return opcao;
    }

    public static void apresentarMenu() {
        System.out.println("\n========= MENU =========\n");
        System.out.println("1 - Insirar os dados do carro no ínicio");
        System.out.println("2 - Insirar os dados do carro no final");
        System.out.println("3 - Pesquisar carro por modelo");
        System.out.println("4 - Imprimir todos os elementos da lista");
        System.out.println("5 - Remover um elemento da lista");
        System.out.println("6 - Remover todos os elementos da lista");
        System.out.println("0 - Sair");
    }

    public static void menu(int opcao, ListaSimples lista) {
        Scanner console = new Scanner(System.in);
        Carros carro = new Carros();
        String modelo;
        switch (opcao) {
            case 1:
                carro = inserirDados();
                lista.inserirPrimeiro(carro);
                break;
            case 2:
                carro = inserirDados();
                lista.inserirUltimo(carro);
                break;
            case 3:
                String dados;
                System.out.println("Qual o modelo do carro a pesquisar?");
                modelo = console.nextLine();
                dados = lista.pesquisarNo(modelo);
                System.out.println("\n" + dados);
                break;
            case 4:
                String listaInteira = lista.imprimirLista();
                System.out.println(listaInteira);
                break;
            case 5:
                System.out.println("Qual o modelo do carro a excluir?");
                modelo = console.nextLine();
                boolean carroRemovido = lista.removerNo(modelo);
                if (carroRemovido) {
                    System.out.println("Carro removido!");
                } else {
                    System.out.println("Lista vazia!");
                }
                break;
            case 6:
                boolean listaLimpa = lista.removerTudo();
                if (listaLimpa) {
                    System.out.println("Lista limpa!");
                } else {
                    System.out.println("Lista vazia!");
                }
                break;
            case 0:
                break;
        }
    }

    public static Carros inserirDados() {
        Scanner console = new Scanner(System.in);
        Carros carro = new Carros();
        System.out.println("Qual é o modelo do carro?");
        String modelo = console.nextLine();
        System.out.println("Qual a marca do carro?");
        String marca = console.nextLine();
        System.out.println("Qual o ano do carro?");
        int ano = console.nextInt();

        carro.setModelo(modelo);
        carro.setMarca(marca);
        carro.setAno(ano);
        return carro;
    }

}
