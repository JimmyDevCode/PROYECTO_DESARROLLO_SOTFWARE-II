package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "telefono")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE ciudad SET telefono = true WHERE id_telefono=?")
@Where(clause = "estado = false")

public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private Long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private Timestamp fechaModificacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedor proveedor;

    @Column(name = "id_proveedor", nullable = false)
    private Long idProveedor;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
