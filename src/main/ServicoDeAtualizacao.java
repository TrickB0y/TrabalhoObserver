package main;

import java.util.Observable;

public class ServicoDeAtualizacao extends Observable {
    private String versao;

    public ServicoDeAtualizacao(String versao) {
        this.versao = versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public void atualizar(String novaVersao) {
        setVersao(novaVersao);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return versao;
    }
}
