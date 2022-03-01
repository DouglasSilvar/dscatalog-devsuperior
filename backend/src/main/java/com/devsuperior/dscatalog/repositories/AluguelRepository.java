package com.devsuperior.dscatalog.repositories;


import com.devsuperior.dscatalog.entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
}
