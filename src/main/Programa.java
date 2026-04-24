package main;

import java.util.Observable;
import java.util.Observer;

public class Programa implements Observer {

    private String versaoAtual;
    private String ultimaNotificacao;

    public Programa(String versaoAtual) {
        this.versaoAtual = versaoAtual;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void conectarAoServico(ServicoDeAtualizacao servico) {
        servico.addObserver(this);
    }

    public void update(Observable servico, Object arg1) {
        this.ultimaNotificacao = "Nova Atualização disponível. " + this.versaoAtual + " -> " + servico.toString();
    }
}
