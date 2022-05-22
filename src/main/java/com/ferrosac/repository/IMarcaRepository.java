package com.ferrosac.repository;

import com.ferrosac.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepository extends JpaRepository <Marca, Long> {

}
