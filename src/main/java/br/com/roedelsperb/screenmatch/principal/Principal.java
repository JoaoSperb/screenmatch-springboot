package br.com.roedelsperb.screenmatch.principal;

import br.com.roedelsperb.screenmatch.model.DadosSerie;
import br.com.roedelsperb.screenmatch.model.DadosTemporada;
import br.com.roedelsperb.screenmatch.service.ConsumoApi;
import br.com.roedelsperb.screenmatch.service.ConversorDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConversorDados conversorDados = new ConversorDados();
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String API_KEY = "&apikey=3a7f6482";
    private final String ENDERECO = "https://www.omdbapi.com/?t=";


    public void exibirMenu(){

        System.out.println("Digite o nome da série que você deseja saber as informações: ");
        String serie = scanner.nextLine();
        serie = serie.replace(" ","+");
        var json = consumoApi.obterDados(ENDERECO + serie + API_KEY);

        int leitura = -1;

        List<DadosTemporada> temporadas = new ArrayList<>();

        while (leitura!=0){
            System.out.println("Informe o que você deseja fazer, digitando o número correspondente.");
            System.out.println("Digite 1 para dados gerais da série.");
            System.out.println("Digite 2 para dados gerais das temporadas.");
            System.out.println("Digite 3 caso queira mudar a série em questão.");
            System.out.println("Digite 0 para sair.");
            leitura = scanner.nextInt();

            DadosSerie dadosSerie = conversorDados.obterDados(json,DadosSerie.class);

            if(leitura==1){
                System.out.println(dadosSerie);
            }
            if(leitura==2){
                for(int i = 1; i<=dadosSerie.totalTemporadas();i++){
                    json = consumoApi.obterDados(ENDERECO + serie +"&season="+ i + API_KEY);
                    DadosTemporada dadosTemporada = conversorDados.obterDados(json,DadosTemporada.class);
                    temporadas.add(dadosTemporada);
                }
                temporadas.forEach(System.out::println);
            }
//            if(leitura==3){
//                System.out.println("Informe a nova série.");
//                serie = scanner.nextLine();
//                serie = serie.replace(" ","+");
//                json = consumoApi.obterDados(ENDERECO + serie + API_KEY);
//            }
        }
    }
}
