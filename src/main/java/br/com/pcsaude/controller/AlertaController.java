package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Alerta;
import br.com.pcsaude.mappers.AlertaMapper;
import br.com.pcsaude.records.AlertaOutDto;
import br.com.pcsaude.services.AlertaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaOutDto> findById(@PathVariable Long id) {
        Alerta alerta = service.findById(id);
        return ResponseEntity.ok(AlertaMapper.toDto(alerta));
    }

    @GetMapping
    public ResponseEntity<Page<AlertaOutDto>> findAllByUsuario(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        Page<AlertaOutDto> pagina = this.service
                                        .findAll(page, size)
                                        .map(AlertaMapper::toDto);

        if (pagina.getTotalElements() > 0) {
            return ResponseEntity.ok(pagina);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}
