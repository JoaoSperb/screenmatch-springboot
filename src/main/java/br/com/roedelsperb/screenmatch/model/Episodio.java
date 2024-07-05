package br.com.roedelsperb.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
        private final Integer temporada;
        private final String titulo;
        private final Integer numEpisodio;
        private LocalDate data;
        private double avaliacao;

        public Episodio(Integer temporada,DadosEpisodio dadosEpisodio){
                this.temporada = temporada;
                this.titulo = dadosEpisodio.titulo();
                this.numEpisodio = dadosEpisodio.numEpisodio();
                try{
                        this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
                }
                catch (NumberFormatException ex){
                        this.avaliacao = 0.0;
                }
                try {
                        this.data = LocalDate.parse(dadosEpisodio.data());
                }
                catch (DateTimeParseException ex){ //pra descobrir a exceção, executar o codigo e ver quais possiveis erros podem ocorrer,
                        this.data = null;          //nesse caso foi DateTImeParse, no outro foi NumberFormatException
                }

        }

        @Override
        public String toString() {
                return "temporada=" + temporada +
                        ", titulo='" + titulo + '\'' +
                        ", numEpisodio=" + numEpisodio +
                        ", data=" + data +
                        ", avaliacao=" + avaliacao;
        }
}
