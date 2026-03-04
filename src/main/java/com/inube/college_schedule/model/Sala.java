package com.inube.college_schedule.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "SALAS_CA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_seq")
    @SequenceGenerator(name = "sala_seq", sequenceName = "SEQ_ID_SALA_CA",allocationSize = 1)
    @Column(name = "ID_SALA")
    private Long idSala;

    @Column(name = "DISPONIBLE")
    private Integer disponible;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
    @ToString.Exclude //evita bucles infinitos
    @EqualsAndHashCode.Exclude //evita bucles infinitos
    private List<Actividad> actividades;
}