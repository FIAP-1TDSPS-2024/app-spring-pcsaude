package br.com.pcsaude.services;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.repositories.DispositivoRepository;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoService(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo findById(String uuid) {
        return this.repository.findById(uuid).orElseThrow();
    }

    public Dispositivo save(Dispositivo dispositivo) {

        if (this.repository.findById(dispositivo.getUuid()).isPresent()) {
            return this.repository.findById(dispositivo.getUuid()).get();
        }

        return this.repository.save(dispositivo);
    }
}
