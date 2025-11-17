package br.com.pcsaude.repositories;

import br.com.pcsaude.entities.Medicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    Page<Medicao> findAllByDispositivo_Uuid(String uuid, Pageable pageable);

    Optional<Medicao> findFisrtByDispositivo_UuidOrderByMomentoMedicaoDesc(String uuid);
}
