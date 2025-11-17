package br.com.pcsaude.repositories;

import br.com.pcsaude.entities.Alerta;
import br.com.pcsaude.entities.Medicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    Page<Alerta> findAllByUsuario_Id(Long id, Pageable pageable);
}
