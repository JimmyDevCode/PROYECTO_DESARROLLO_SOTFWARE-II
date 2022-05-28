package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "proveedor")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE proveedor SET estado = true WHERE id_proveedor=?")
@Where(clause = "estado = false")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(name = "razon_social", nullable = false)
    private String razon_social;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private Timestamp fechaModificacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_distrito", insertable = false, updatable = false)
    private Distrito distrito;

    @Column(name = "id_distrito", nullable = false)
    private Long idDistrito;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
