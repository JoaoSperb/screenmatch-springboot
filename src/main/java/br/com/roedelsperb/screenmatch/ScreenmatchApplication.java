package br.com.roedelsperb.screenmatch;

import br.com.roedelsperb.screenmatch.model.DadosSerie;
import br.com.roedelsperb.screenmatch.service.ConsumoApi;
import br.com.roedelsperb.screenmatch.service.ConversorDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&apikey=3a7f6482");
		System.out.println(json);

		ConversorDados conversor = new ConversorDados();
		DadosSerie serie = conversor.obterDados(json,DadosSerie.class);
		System.out.println(serie);
	}
}
