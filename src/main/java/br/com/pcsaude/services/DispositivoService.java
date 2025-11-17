package br.com.pcsaude.services;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.repositories.DispositivoRepository;

public class DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoService(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo findById(String uuid) {
        return this.repository.findById(uuid).orElseThrow();
    }

    public Dispositivo save(Dispositivo dispositivo) {
        return this.repository.save(dispositivo);
    }
}
