package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.models.Part;
import com.novi.garage_korenwolf.repositories.PartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    public Optional<Part> getPartByID(long id) {
        return partRepository.findById(id);
    }

    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    public Part updatePart(Part part) {
        if (part.getId() == null) {
            throw new IllegalArgumentException("Part ID mag niet null zijn bij update.");
        }

        Optional<Part> existingPart = partRepository.findById(part.getId());
        if (existingPart.isEmpty()) {
            throw new EntityNotFoundException("Part met ID " + part.getId() + " bestaat niet.");
        }
                return partRepository.save(part);
    }


    public boolean existsById(Long id) {
        return partRepository.existsById(id);
    }

    public void deletePartById(Long id) {
        partRepository.deleteById(id);
    }


}
