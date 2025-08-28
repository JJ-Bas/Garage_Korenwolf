package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.models.MaintenanceJob;
import com.novi.garage_korenwolf.repositories.MaintenanceJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceJobService {

    private MaintenanceJobRepository maintenanceJobRepository;

    public MaintenanceJobService(MaintenanceJobRepository maintenanceJobRepository) {
        this.maintenanceJobRepository = maintenanceJobRepository;
    }

    public List<MaintenanceJob> getAllJobs() {
        return maintenanceJobRepository.findAll();
    }


    public MaintenanceJob getJobById(Long id) {
        return maintenanceJobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }


    public MaintenanceJob createJob(MaintenanceJob job) {
        return maintenanceJobRepository.save(job);
    }

    public MaintenanceJob updateJob(Long id, MaintenanceJob updatedJob) {
        MaintenanceJob existing = getJobById(id);
        existing.setDescription(updatedJob.getDescription());
        existing.setCar(updatedJob.getCar());
        existing.setMechanics(updatedJob.getMechanics());
        existing.setJobItems(updatedJob.getJobItems());
        // Don’t overwrite invoice here unless intentional
        return maintenanceJobRepository.save(existing);
    }

    public void deleteJob(Long id) {
        if (!maintenanceJobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with id: " + id);
        }
        maintenanceJobRepository.deleteById(id);
    }

    public MaintenanceJob approveJob(Long id) {
        MaintenanceJob job = getJobById(id);
        job.approveJob();
        return maintenanceJobRepository.save(job);
    }

    public MaintenanceJob rejectJob(Long id) {
        MaintenanceJob job = getJobById(id);
        job.rejectJob();
        return maintenanceJobRepository.save(job);
    }

    public MaintenanceJob completeJob(Long id) {
        MaintenanceJob job = getJobById(id);
        job.completeJob();
        return maintenanceJobRepository.save(job);
    }

    public MaintenanceJob pickupJob(Long id) {
        MaintenanceJob job = getJobById(id);
        job.pickupJob();
        return maintenanceJobRepository.save(job);
    }

}
