package br.com.pcsaude.services;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.exceptions.ResourceNotFoundException;
import br.com.pcsaude.repositories.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoService(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo findById(String uuid) {
        try {
            return this.repository.findById(uuid).orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException("Não foi possível encontrar um Dispositivo com o uuid " + uuid);
        }
    }

    public Dispositivo save(Dispositivo dispositivo) {

        if (this.repository.findById(dispositivo.getUuid()).isPresent()) {
            return this.repository.findById(dispositivo.getUuid()).get();
        }

        return this.repository.save(dispositivo);
    }
}
