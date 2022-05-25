package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "departamento")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE departamento SET estado = true WHERE id_departamento=?")
@Where(clause = "estado = false")

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "prefijo", nullable = false)
    private String prefijo;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private Timestamp fechaModificacion;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
