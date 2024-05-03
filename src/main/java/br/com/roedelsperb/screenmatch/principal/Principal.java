package br.com.roedelsperb.screenmatch.principal;

import br.com.roedelsperb.screenmatch.model.DadosSerie;
import br.com.roedelsperb.screenmatch.model.DadosTemporada;
import br.com.roedelsperb.screenmatch.service.ConsumoApi;
import br.com.roedelsperb.screenmatch.service.ConversorDados;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String API_KEY = "&apikey=3a7f6482";
    private ConversorDados conversorDados = new ConversorDados();

    public void exibirMenu(){

        System.out.println("Digite o nome da série que você deseja saber as informações: ");
        String serie = scanner.nextLine();

        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t="+ serie + API_KEY);


        int leitura = -1;

        while (leitura!=0){
            System.out.println("Informe o que você deseja fazer, digitando o número correspondente.");
            System.out.println("Digite 1 para dados do episódio.");
            System.out.println("Digite 2 para dados gerais da serie.");
            System.out.println("Digite 3 para dados gerais da temporada.");
            System.out.println("Digite 0 para sair.");
            leitura = scanner.nextInt();

            if(leitura==2){
                DadosSerie dadosSerie = conversorDados.obterDados(json,DadosSerie.class);
                System.out.println(dadosSerie);
                leitura = scanner.nextInt();
            }
        }
    }
}
