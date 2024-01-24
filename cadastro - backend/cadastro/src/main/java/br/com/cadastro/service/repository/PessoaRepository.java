package br.com.cadastro.service.repository;

import br.com.cadastro.model.Pessoa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpf(String cpf);
    // Verifica se existe uma pessoa com o mesmo CPF
    boolean existsByCpf(String cpf);

    // Verifica se existe uma pessoa com o mesmo e-mail
    boolean existsByEmail(String email);
}