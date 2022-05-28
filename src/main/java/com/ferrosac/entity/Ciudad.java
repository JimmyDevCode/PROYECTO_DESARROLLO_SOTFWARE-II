package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "ciudad")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE ciudad SET estado = true WHERE id_ciudad=?")
@Where(clause = "estado = false")

public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private Timestamp fechaModificacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_departamento", insertable = false, updatable = false)
    private Departamento departamento;

    @Column(name = "id_departamento", nullable = false)
    private Long idDepartamento;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
