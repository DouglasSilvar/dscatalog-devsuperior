package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ClienteDTO;
import com.devsuperior.dscatalog.dto.EnderecoDTO;
import com.devsuperior.dscatalog.entities.Cliente;
import com.devsuperior.dscatalog.entities.Endereco;
import com.devsuperior.dscatalog.repositories.ClienteRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> findAll() {
        List<Cliente> list = repository.findAll(Sort.by("nome"));
        return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setTelefone1(dto.getTelefone1());
        entity.setTelefone2(dto.getTelefone2());
        entity.setEndereco(dto.getEndereco());
        entity = repository.save(entity);
        return new ClienteDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    public ClienteDTO update(Long id, ClienteDTO dto) {
        try {
            Cliente entity = repository.getOne(id);
            entity.setEndereco(dto.getEndereco());
            entity.setNome(dto.getNome());
            entity.setCpfCnpj(dto.getCpfCnpj());
            entity.setTelefone1(dto.getTelefone1());
            entity.setTelefone2(dto.getTelefone2());
            entity = repository.save(entity);
            return new ClienteDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
}
