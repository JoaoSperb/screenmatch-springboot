

package br.com.roedelsperb.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosFIltrados = numeros2.stream()
                        .filter(n -> n%2 !=0)
                        .map(n -> n*2)
                        .toList();
        System.out.println(numerosFIltrados);     
        
        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        //palavras2.stream()      --dessa maneira é filtrada a propria lista
        //        .distinct()                   
        //        .forEach(System.out::println);  --abaixo é criada uma nova lista sem repetições

        List<String> palavrasSemRep = palavras2.stream()
                                        .distinct()
                                        .toList();

        List<List<Integer>> listaDeNumeros = Arrays.asList(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(5, 6, 7, 8),
            Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> listPrimos = listaDeNumeros.stream()
                .flatMap(List::stream)
                .filter(n -> Main.isPrimo(n))
                .toList();
        System.out.println(listPrimos);
        
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("Charlie", 22),
            new Pessoa("Bob", 17),
            new Pessoa("Alice", 19)
        );

        List<String> filtro = pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .map(Pessoa::getNome)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filtro);

        List<Produto> produtos = Arrays.asList(
            new Produto("Smartphone", 800.0, "Eletrônicos"),
            new Produto("Notebook", 1500.0, "Eletrônicos"),
            new Produto("Teclado", 200.0, "Eletrônicos"),
            new Produto("Cadeira", 300.0, "Móveis"),
            new Produto("Monitor", 900.0, "Eletrônicos"),
            new Produto("Mesa", 700.0, "Móveis")
        );
        
        List<Produto> produtosFiltrado1 = produtos.stream()
                                            .filter(p -> p.getPreco()>=1000)
                                            .filter(p -> p.getCategoria().equals("Eletrônicos"))
                                            .sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                                            .collect(Collectors.toList());//colocar um limit(x) para limitar o numero de elementos
        System.out.println(produtosFiltrado1);

        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        List<Integer> numeros3 = Arrays.asList(1, 2, 3, 4, 5);

        int soma = numeros3.stream()
                .peek(n -> System.out.println("Elemento: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Conteúdo depois do map: " + n))
                .reduce(0, (total, numero) -> total + numero);

        System.out.println("A soma dos números é: " + soma);


    }

    public static boolean isPrimo(int numero) {
        if (numero <= 1) return false; // Números menores ou iguais a 1 não são primos
        return IntStream.rangeClosed(2, (int) Math.sqrt(numero)) // Checar divisores de 2 até a raiz quadrada do número
                        .allMatch(divisor -> numero % divisor != 0); // True se não houver divisores
    }

    public static class Pessoa {
        private final String nome;
        private final int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }
    }

    public static class Produto {
        private String nome;
        private double preco;
        private String categoria;
    
        public Produto(String nome, double preco, String categoria) {
            this.nome = nome;
            this.preco = preco;
            this.categoria = categoria;
        }
    
        public String getNome() {
            return nome;
        }
    
        public double getPreco() {
            return preco;
        }
    
        public String getCategoria() {
            return categoria;
        }
    
        @Override
        public String toString() {
            return "Produto{" +
                   "nome='" + nome + '\'' +
                   ", preco=" + preco +
                   ", categoria='" + categoria + '\'' +
                   '}';
        }
    }
}

