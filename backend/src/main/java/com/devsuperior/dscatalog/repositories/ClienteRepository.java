package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
