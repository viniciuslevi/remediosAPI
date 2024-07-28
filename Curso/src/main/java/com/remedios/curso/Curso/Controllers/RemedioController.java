package com.remedios.curso.Curso.Controllers;

import com.remedios.curso.Curso.Remedios.*;
import com.remedios.curso.Curso.Remedios.DTO.DadosAtualizarRemedio;
import com.remedios.curso.Curso.Remedios.DTO.DadosCadastroRemedio;
import com.remedios.curso.Curso.Remedios.DTO.DadosDetalhamentoRemedio;
import com.remedios.curso.Curso.Remedios.DTO.DadosListagemRemedio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {    
    @Autowired //o autowired instancia a classe automaticamente
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder builder){ //DadosCadastroRemedio é um DTO construido nu
        var remedio = repository.save(new Remedio(dados)); // função do proprio jpa
        // o DTO passado como argumento é lido no construtor, que retorna os atributos
        var uri = builder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> listar(){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList(); //função do proprio jpa
        return ResponseEntity.ok(lista);
    }
    @PutMapping
    @Transactional //@transational só salva quando tudo der certo
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar(id);
        return ResponseEntity.noContent().build();
    }

    //Criar um método ativar com put
    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.reativar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoRemedio> Detalhar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
}
