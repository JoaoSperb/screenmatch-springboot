package br.com.roedelsperb.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> max = numeros.stream()
                                .max(Integer::compareTo);
        //pega o maior valor


        List<String> palavras = Arrays.asList("Joao","Ana","ovos","tripe","ola");
        Map<Integer,List<String>> grupoPalavras = palavras.stream()
                                    .collect(Collectors.groupingBy(String::length));

        grupoPalavras.forEach((tamanho,lista) -> System.out.println("tamanho:"+tamanho+"palavras:"+lista));
        //junta as palavras em grupos de tamanho

        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        String resultado = nomes.stream()
                            .collect(Collectors.joining(","));
        System.out.println(resultado); //concatena a lista acima, separando por virgulas.


        List<Integer> numeros1 = Arrays.asList(1,2,3,4,5,6);

        int soma = numeros1.stream()
                            .filter(n->n%2==0)
                            .mapToInt(n->n*n)
                            .sum();
        System.out.println(soma);
        //pega os numeros pares, eleva ao quadrado e soma.


        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> particionado = numeros.stream()
                                                          .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Pares: " + particionado.get(true));  // Esperado: [2, 4, 6]
        System.out.println("Ímpares: " + particionado.get(false)); // Esperado: [1, 3, 5]
        //separa os impares dos pares.


        List<Produto> produtos = Arrays.asList(
            new Produto("Smartphone", 800.0, "Eletrônicos"),
            new Produto("Notebook", 1500.0, "Eletrônicos"),
            new Produto("Teclado", 200.0, "Eletrônicos"),
            new Produto("Cadeira", 300.0, "Móveis"),
            new Produto("Monitor", 900.0, "Eletrônicos"),
            new Produto("Mesa", 700.0, "Móveis")
        );

        Map<String,List<Produto>> dividindo = produtos.stream()
                                    .collect(Collectors.groupingBy(Produto::getCategoria));
        
        Map<String,Long> somaMap = produtos.stream()
                        .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        //pega o total de cada tipo de produto

        Map<String, Optional<Produto>> maisCaroPorCategoria = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria,
        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));
        //pega o produto mais caro de cada categoria

        Map<String, Double> somaPrecoPorCategoria = produtos.stream()
        .collect(Collectors.groupingBy(Produto::getCategoria,
        Collectors.summingDouble(Produto::getPreco)));
        //soma dos valores por categoria.
        

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
