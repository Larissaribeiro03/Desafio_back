package br.com.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;
import br.com.cadastro.exception.BadRequestException;


@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(this.pessoaService.findAll());
    }
    
    @PostMapping("/inserir")
    public ResponseEntity<?> inserirPessoa(@Valid @RequestBody Pessoa pessoa) throws org.apache.coyote.BadRequestException {
        try {
            Pessoa pessoaInserida = pessoaService.inserirPessoa(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaInserida);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/buscarPorCpf/{cpf}")
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf) {
    	cpf = cpf.replaceAll("[^0-9]", "");
        Optional<Pessoa> pessoa = pessoaService.findByCpf(cpf);
        return pessoa.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }


}
