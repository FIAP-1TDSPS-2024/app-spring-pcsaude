package br.com.pcsaude.records;

import br.com.pcsaude.entities.Medicao;
import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.enums.GrauAlertaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlertaOutDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        // Usuário associado ao alerta
        @ManyToOne(optional = false)
        @JoinColumn(name = "usuario_id", nullable = false)
        Usuario usuario,

        // Medição relacionada ao alerta (opcional)
        @ManyToOne
        @JoinColumn(name = "medicao_id")
        Medicao medicao,

        @NotNull(message = "O título do alerta é obrigatório")
        @Size(min = 3, max = 50, message = "O título deve ter entre 3 e 50 caracteres")
        String titulo,

        @NotNull(message = "A descrição é obrigatória")
        @Size(min = 5, max = 150, message = "A descrição deve ter entre 5 e 150 caracteres")
        String descricao,

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        GrauAlertaEnum grau,

        @Column(name = "momento_alerta", nullable = false)
        LocalDate momentoAlerta
)
{}
