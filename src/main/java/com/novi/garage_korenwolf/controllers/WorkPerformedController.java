package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.WorkPerformedDto;
import com.novi.garage_korenwolf.models.WorkPerformed;
import com.novi.garage_korenwolf.services.WorkPerformedService;
import com.novi.garage_korenwolf.mappers.WorkPerformedMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/work-performed")
public class WorkPerformedController {

    private final WorkPerformedService workPerformedService;

    public WorkPerformedController(WorkPerformedService workPerformedService) {
        this.workPerformedService = workPerformedService;
    }

    @GetMapping
    public List<WorkPerformedDto> getAll() {
        return workPerformedService.getAllWorkPerformed().stream()
                .map(WorkPerformedMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkPerformedDto> getById(@PathVariable Long id) {
        return workPerformedService.getWorkPerformedById(id)
                .map(WorkPerformedMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WorkPerformedDto> create(@RequestBody WorkPerformedDto dto) {
        WorkPerformed entity = WorkPerformedMapper.toEntity(dto);
        WorkPerformed saved = workPerformedService.saveWorkPerformed(entity);
        return ResponseEntity.ok(WorkPerformedMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkPerformedDto> update(@PathVariable Long id, @RequestBody WorkPerformedDto dto) {
        if (!id.equals(dto.getId())) return ResponseEntity.badRequest().build();

        WorkPerformed entity = WorkPerformedMapper.toEntity(dto);
        WorkPerformed updated = workPerformedService.updateWorkPerformed(entity);
        return ResponseEntity.ok(WorkPerformedMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!workPerformedService.existsById(id)) return ResponseEntity.notFound().build();

        workPerformedService.deleteWorkPerformedById(id);
        return ResponseEntity.noContent().build();
    }
}