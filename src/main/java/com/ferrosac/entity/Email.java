package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "email")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE ciudad SET email = true WHERE id_email=?")
@Where(clause = "estado = false")

public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_email")
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
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedor proveedor;

    @Column(name = "id_proveedor", nullable = false)
    private Long idProveedor;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;
}
