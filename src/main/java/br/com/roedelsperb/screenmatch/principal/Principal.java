package br.com.roedelsperb.screenmatch.principal;

import br.com.roedelsperb.screenmatch.model.DadosEpisodio;
import br.com.roedelsperb.screenmatch.model.DadosSerie;
import br.com.roedelsperb.screenmatch.model.DadosTemporada;
import br.com.roedelsperb.screenmatch.model.Episodio;
import br.com.roedelsperb.screenmatch.service.ConsumoApi;
import br.com.roedelsperb.screenmatch.service.ConversorDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private final ConversorDados conversorDados = new ConversorDados();
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final String API_KEY = "&apikey=3a7f6482";
    private final String ENDERECO = "https://www.omdbapi.com/?t=";


    public void exibirMenu(){

        System.out.println("Digite o nome da série que você deseja saber as informações: ");
        String serie = scanner.nextLine();
        serie = serie.replace(" ","+");
        var json = consumoApi.obterDados(ENDERECO + serie + API_KEY);

        int leitura = -1;

        DadosSerie dadosSerie = conversorDados.obterDados(json,DadosSerie.class);
        List<DadosTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i<=dadosSerie.totalTemporadas();i++){
            json = consumoApi.obterDados(ENDERECO + serie +"&season="+ i + API_KEY);
            DadosTemporada dadosTemporada = conversorDados.obterDados(json,DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }


        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())//flatMap serve para juntar elementos de vaarias listas
                .collect(Collectors.toList());//collectors serve para listas que poderao ser alteradas no futuro
                                              //toList servee para listas que nao serao alteradas.

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(),d) ))
                .collect(Collectors.toList());

        List<Episodio> episodioList = new ArrayList<>();

        while (leitura!=0){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Informe o que você deseja fazer, digitando o número correspondente.");
            System.out.println("Digite 1 para dados gerais da série.");
            System.out.println("Digite 2 para dados gerais das temporadas.");
            System.out.println("Digite 3 para receber o nome de todos os episódios das temporadas");
            System.out.println("Digite 4 para saber os 5 episodios melhor avaliados da serie.");
            System.out.println("Digite 0 para sair.");
            System.out.println("-------------------------------------------------------------------");
            leitura = scanner.nextInt();

            if(leitura==1){
                System.out.println(dadosSerie);
            }
            if(leitura==2){
                temporadas.forEach(System.out::println);
            }
            if(leitura==3) {
//                for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
//                    List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//                    for (int j = 0; j < episodiosTemporada.size(); j++) {
//                        System.out.println(episodiosTemporada.get(j).titulo());
//                    }
//                }
                temporadas.forEach(t->t.episodios().forEach(e-> System.out.println(e.titulo())));
            }
            if(leitura==4){
                dadosEpisodios.stream()
                        .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                        .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                        .limit(5)
                        .forEach(System.out::println);
            }
        }


    }
}
