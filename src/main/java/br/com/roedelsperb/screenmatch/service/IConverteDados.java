package br.com.roedelsperb.screenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String json,Class <T> classe);
}
