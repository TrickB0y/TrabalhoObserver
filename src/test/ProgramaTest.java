package test;

import main.Programa;
import main.ServicoDeAtualizacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramaTest {

    @Test
    public void deveNotificarPrograma() {
        ServicoDeAtualizacao servico = new ServicoDeAtualizacao("1.0");
        Programa programa = new Programa("1.0");
        programa.conectarAoServico(servico);
        servico.atualizar("2.0");
        assertEquals("Nova Atualização disponível. 1.0 -> 2.0", programa.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarProgramas() {
        ServicoDeAtualizacao servico = new ServicoDeAtualizacao("1.0");
        Programa programa1 = new Programa("1.0");
        Programa programa2 = new Programa("1.5");
        programa1.conectarAoServico(servico);
        programa2.conectarAoServico(servico);
        servico.atualizar("2.0");
        assertEquals("Nova Atualização disponível. 1.0 -> 2.0", programa1.getUltimaNotificacao());
        assertEquals("Nova Atualização disponível. 1.5 -> 2.0", programa2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarPrograma() {
        ServicoDeAtualizacao servico = new ServicoDeAtualizacao("1.0");
        Programa programa = new Programa("1.0");
        servico.atualizar("2.0");
        assertEquals(null, programa.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarPrograma1() {
        ServicoDeAtualizacao servico = new ServicoDeAtualizacao("1.0");
        Programa programa1 = new Programa("1.0");
        Programa programa2 = new Programa("1.5");
        programa2.conectarAoServico(servico);
        servico.atualizar("2.0");
        assertEquals(null, programa1.getUltimaNotificacao());
        assertEquals("Nova Atualização disponível. 1.5 -> 2.0", programa2.getUltimaNotificacao());
    }
}
