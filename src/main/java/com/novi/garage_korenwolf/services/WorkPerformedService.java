package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.models.WorkPerformed;
import com.novi.garage_korenwolf.repositories.WorkPerformedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkPerformedService {

    private final WorkPerformedRepository repository;

    public WorkPerformedService(WorkPerformedRepository repository) {
        this.repository = repository;
    }

    public List<WorkPerformed> getAllWorkPerformed() {
        return repository.findAll();
    }

    public Optional<WorkPerformed> getWorkPerformedById(Long id) {
        return repository.findById(id);
    }

    public WorkPerformed saveWorkPerformed(WorkPerformed workPerformed) {
        return repository.save(workPerformed);
    }

    public WorkPerformed updateWorkPerformed(WorkPerformed workPerformed) {
        return repository.save(workPerformed);
    }

    public void deleteWorkPerformedById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}


