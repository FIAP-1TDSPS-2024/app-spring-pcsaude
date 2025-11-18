package br.com.pcsaude.mappers;

import br.com.pcsaude.entities.Alerta;
import br.com.pcsaude.entities.Medicao;
import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.enums.GrauAlertaEnum;
import br.com.pcsaude.records.AlertaOutDto;
import br.com.pcsaude.records.MedicaoOutDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AlertaMapper {

    public static AlertaOutDto toDto(Alerta alerta) {
        return new AlertaOutDto(
                alerta.getId(),
                alerta.getUsuario(),
                alerta.getMedicao(),
                alerta.getTitulo(),
                alerta.getDescricao(),
                alerta.getGrau(),
                alerta.getMomentoAlerta()
        );
    }

    private AlertaMapper() {}
}
