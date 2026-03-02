package com.inube.college_schedule.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "USUARIOS_CA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "usuario_seq",sequenceName = "SEQ_ID_USUARIO_CA",allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "CORREO", nullable = false, length = 100)
    private String correo;

    @Column(name = "ESTATUS")
    private Integer estatus = 1;

    @Column(name = "IP_CREACION")
    private String ipCreacion;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude //evita bucles infinitos
    @EqualsAndHashCode.Exclude //evita bucles infinitos
    private List<Actividad> actividades;
}
