package br.com.roedelsperb.screenmatch;

import br.com.roedelsperb.screenmatch.model.DadosEpisodio;
import br.com.roedelsperb.screenmatch.model.DadosSerie;
import br.com.roedelsperb.screenmatch.model.DadosTemporada;
import br.com.roedelsperb.screenmatch.principal.Principal;
import br.com.roedelsperb.screenmatch.service.ConsumoApi;
import br.com.roedelsperb.screenmatch.service.ConversorDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var consumoApi = new ConsumoApi();
//		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&apikey=3a7f6482");
//		System.out.println(json);
		Principal principal = new Principal();
		principal.exibirMenu();

		//ConversorDados conversor = new ConversorDados();
		//DadosSerie dadosSerie = conversor.obterDados(json,DadosSerie.class);
		//System.out.println(dadosSerie);

		//json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&season=1&episode=3&apikey=3a7f6482");
		//DadosEpisodio dadosEpisodio = conversor.obterDados(json,DadosEpisodio.class);
		//System.out.println(dadosEpisodio);


		//List<DadosTemporada> temporadas = new ArrayList<>();

		//for(int i = 1; i<=dadosSerie.totalTemporadas();i++){
		//	json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&season="+ i +"&apikey=3a7f6482");
		//	DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
		//	temporadas.add(dadosTemporada);
		//}
		//temporadas.forEach(System.out::println);
	}
}
