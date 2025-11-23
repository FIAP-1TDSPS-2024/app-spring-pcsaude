package br.com.pcsaude.repositories;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.entities.Medicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    @Query(value = "SELECT * FROM medicao m WHERE m.dispositivo_id = :uuid ORDER BY m.momento_medicao DESC", nativeQuery = true)
    Page<Medicao> findAllByDispositivoUuid(@Param("uuid") String uuid, Pageable pageable);

    @Query(value = "SELECT * FROM medicao WHERE dispositivo_id = :uuid ORDER BY momento_medicao DESC FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    Optional<Medicao> findFirstByDispositivoUuidOrderByMomentoMedicaoDesc(@Param("uuid") String uuid);
}
