package br.com.senai.ProjectApi.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
    Optional<Cliente> findByIdAndAtivoTrue(Long id);

}
