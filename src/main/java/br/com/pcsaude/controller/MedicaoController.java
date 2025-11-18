package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.entities.Medicao;
import br.com.pcsaude.mappers.MedicaoMapper;
import br.com.pcsaude.records.MedicaoInDto;
import br.com.pcsaude.records.MedicaoOutDto;
import br.com.pcsaude.services.DispositivoService;
import br.com.pcsaude.services.MedicaoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MedicaoOutDto> save(@RequestBody MedicaoInDto dto) {

        Dispositivo dispositivo = new Dispositivo(dto.uuidDispositivo());

        Medicao medicao = MedicaoMapper.fromDto(dispositivo, dto);

        this.dispositivoService.save(dispositivo);

        MedicaoOutDto medicaoSalva =  MedicaoMapper.toDto(this.service.save(medicao));

        return ResponseEntity.ok(medicaoSalva);
    }

    @GetMapping("/ultima-medicao")
    public ResponseEntity<MedicaoOutDto> findUltimaMedicao() {
        MedicaoOutDto ultimaMedicao = MedicaoMapper.toDto(this.service.findUltimaMedicao());
        return ResponseEntity.ok(ultimaMedicao);
    }

    @GetMapping
    public ResponseEntity<Page<MedicaoOutDto>> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        Page<MedicaoOutDto> pagina = this.service
                                            .findAll(page, size)
                                            .map(MedicaoMapper::toDto);

        if (pagina.getTotalElements() > 0) {
            return ResponseEntity.ok(pagina);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}
