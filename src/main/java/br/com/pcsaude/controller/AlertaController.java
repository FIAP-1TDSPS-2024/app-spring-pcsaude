package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Alerta;
import br.com.pcsaude.mappers.AlertaMapper;
import br.com.pcsaude.records.AlertaOutDto;
import br.com.pcsaude.services.AlertaService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public AlertaOutDto findById(@PathVariable Long id) {
        Alerta alerta = service.findById(id);
        return AlertaMapper.toDto(alerta);
    }

    @GetMapping
    public Page<AlertaOutDto> findAllByUsuario(int page, int size) {
        return this.service
                .findAll(page, size)
                .map(AlertaMapper::toDto);
    }
}
