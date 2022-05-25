package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "distrito")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE distrito SET estado = true WHERE id_distrito=?")
@Where(clause = "estado = false")

public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito")
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
    @JoinColumn(name = "id_ciudad", insertable = false, updatable = false)
    private Ciudad ciudad;

    @Column(name = "id_ciudad", nullable = false)
    private Long idCiudad;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
