package br.com.cadastro.service;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.repository.PessoaRepository;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }
    
    public Pessoa inserirPessoa(Pessoa pessoa) throws BadRequestException {
    	pessoa.limparCpf();
        if (pessoaRepository.existsByCpf(pessoa.getCpf()) || pessoaRepository.existsByEmail(pessoa.getEmail())) {
            throw new BadRequestException("CPF ou e-mail já cadastrados");
        }

        return pessoaRepository.save(pessoa);
    }
    
    public Optional<Pessoa> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }


}



