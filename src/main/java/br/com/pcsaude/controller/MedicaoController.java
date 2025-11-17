package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.entities.Medicao;
import br.com.pcsaude.mappers.MedicaoMapper;
import br.com.pcsaude.records.MedicaoInDto;
import br.com.pcsaude.records.MedicaoOutDto;
import br.com.pcsaude.services.DispositivoService;
import br.com.pcsaude.services.MedicaoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/medicoes")
public class MedicaoController {

    private final MedicaoService service;

    private final DispositivoService dispositivoService;

    public MedicaoController(MedicaoService service, DispositivoService dispositivoService) {
        this.service = service;
        this.dispositivoService = dispositivoService;
    }

    @PostMapping
    public MedicaoOutDto save(@RequestBody MedicaoInDto dto) {

        Dispositivo dispositivo = new Dispositivo(dto.uuidDispositivo());

        Medicao medicao = MedicaoMapper.fromDto(dispositivo, dto);

        this.dispositivoService.save(dispositivo);

        return MedicaoMapper.toDto(this.service.save(medicao));
    }

    @GetMapping("/ultima-medicao")
    public MedicaoOutDto findUltimaMedicao() {
        return MedicaoMapper.toDto(this.service.findUltimaMedicao());
    }

    @GetMapping
    public Page<MedicaoOutDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return this.service
                .findAll(page, size)
                .map(MedicaoMapper::toDto);
    }
}
