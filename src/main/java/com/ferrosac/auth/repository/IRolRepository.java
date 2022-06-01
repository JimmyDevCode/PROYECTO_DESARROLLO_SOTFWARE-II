package com.ferrosac.auth.repository;

import com.ferrosac.auth.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String name);
}
