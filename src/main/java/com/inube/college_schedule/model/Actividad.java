package com.inube.college_schedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ACTIVIDADES_CA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad_seq")
    @SequenceGenerator(name = "actividad_seq", sequenceName = "SEQ_ID_ACTIVIDAD_CA", allocationSize = 1)
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false, referencedColumnName = "ID_USUARIO",
        foreignKey = @ForeignKey(name="FK_ID_USUARIO_ACTIVIDAD")
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALA", nullable = false, referencedColumnName = "ID_SALA",
        foreignKey = @ForeignKey(name = "FK_ID_SALA_ACTIVIDAD")
    )
    private Sala sala;

    @Column(name = "NOMBRE_ACTIVIDAD")
    private String nombreActividad;

    @Column(name = "HORARIO_ENTRADA")
    private LocalDateTime horarioEntrada;

    @Column(name = "HORARIO_SALIDA")
    private LocalDateTime horarioSalida;

    @Column(name = "ESTATUS")
    private Integer estatus = 1;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "IP_CREACION")
    private String ipCreacion;

    @PrePersist
    public void prePersist(){
        this.fechaCreacion = LocalDateTime.now();
    }
}