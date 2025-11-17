package br.com.pcsaude.repositories;

import br.com.pcsaude.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, String> {
}
