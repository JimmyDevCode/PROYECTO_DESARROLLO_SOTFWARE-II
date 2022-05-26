package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "categoria")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE categoria SET estado = true WHERE id_categoria=?")
@Where(clause = "estado = false")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private Timestamp fechaModificacion;

    @Column(name = "estado", nullable = false)
    private boolean estado = Boolean.FALSE;

}
