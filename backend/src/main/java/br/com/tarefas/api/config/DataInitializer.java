package br.com.tarefas.api.config;

import br.com.tarefas.api.model.Tarefa;
import br.com.tarefas.api.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TarefaRepository repository;

    public DataInitializer(TarefaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        Tarefa t1 = new Tarefa();
        t1.setTitulo("Estudar Spring Boot");
        t1.setConcluida(false);

        Tarefa t2 = new Tarefa();
        t2.setTitulo("Estudar Vue.js");
        t2.setConcluida(false);

        repository.saveAll(Arrays.asList(t1, t2));

        System.out.println("Base de dados populada com sucesso!");
    }
}
