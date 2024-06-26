package br.com.roedelsperb.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper(); //serve como um desserializador do json.

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        }
    }
}
