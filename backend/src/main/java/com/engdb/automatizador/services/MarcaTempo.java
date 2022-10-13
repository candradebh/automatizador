package com.engdb.automatizador.services;

public class MarcaTempo {

    private long tempoInicial;

    public MarcaTempo() {
        this.tempoInicial = System.currentTimeMillis();
    }

    public String getTempoTotal() {
        long tempoFinal = System.currentTimeMillis();
        Double tempo = (double) (tempoFinal - tempoInicial) / (1000);
        return Double.toString(tempo);
    }
}
