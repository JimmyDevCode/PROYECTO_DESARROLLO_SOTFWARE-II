package com.ferrosac.repository;

import com.ferrosac.entity.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Long> {

}
