package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.models.MaintenanceJob;
import com.novi.garage_korenwolf.services.MaintenanceJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance_job")
public class MaintenanceJobController {

    private final MaintenanceJobService maintenanceJobService;

    public MaintenanceJobController(MaintenanceJobService service) {
        this.maintenanceJobService = service;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceJob>> getAllJobs() {
        return ResponseEntity.ok(maintenanceJobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceJob> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceJobService.getJobById(id));
    }

    @PostMapping
    public ResponseEntity<MaintenanceJob> createJob(@RequestBody MaintenanceJob job) {
        return ResponseEntity.ok(maintenanceJobService.createJob(job));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceJob> updateJob(
            @PathVariable Long id,
            @RequestBody MaintenanceJob updatedJob
    ) {
        return ResponseEntity.ok(maintenanceJobService.updateJob(id, updatedJob));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        maintenanceJobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/approve")
    public ResponseEntity<MaintenanceJob> approveJob(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceJobService.approveJob(id));
    }

    @PatchMapping("/{id}/reject")
    public ResponseEntity<MaintenanceJob> rejectJob(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceJobService.rejectJob(id));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<MaintenanceJob> completeJob(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceJobService.completeJob(id));
    }

    @PatchMapping("/{id}/pickup")
    public ResponseEntity<MaintenanceJob> pickupJob(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceJobService.pickupJob(id));
    }


}
