package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "categoria")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE categoria SET estado = true WHERE id=?")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Long id;
    @Column (name= "nombre", nullable = false)
    private String nombre;
    @Column (name= "estado", nullable = false)
    private boolean estado = Boolean.FALSE;


}
