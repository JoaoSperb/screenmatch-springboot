package br.com.roedelsperb.screenmatch.model;

import java.time.LocalDate;

public class Episodio {
        private Integer temporada;
        private String titulo;
        private Integer numEpisodio;
        private LocalDate data;
        private double avaliacao;

        public Episodio(Integer temporada,DadosEpisodio dadosEpisodio){
                this.temporada = temporada;
                this.titulo = dadosEpisodio.titulo();
                this.numEpisodio = dadosEpisodio.numEpisodio();
                this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());

        }

        public int getTemporada() {
                return temporada;
        }

        public void setTemporada(int temporada) {
                this.temporada = temporada;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public Integer getNumEpisodio() {
                return numEpisodio;
        }

        public void setNumEpisodio(Integer numEpisodio) {
                this.numEpisodio = numEpisodio;
        }

        public LocalDate getData() {
                return data;
        }

        public void setData(LocalDate data) {
                this.data = data;
        }

        public double getAvaliacao() {
                return avaliacao;
        }

        public void setAvaliacao(double avaliacao) {
                this.avaliacao = avaliacao;
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
