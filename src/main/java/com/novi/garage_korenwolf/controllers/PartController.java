package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.PartDto;
import com.novi.garage_korenwolf.mapper.PartMapper;
import com.novi.garage_korenwolf.models.Part;
import com.novi.garage_korenwolf.services.PartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }


    //monteur
    @GetMapping
    public List<PartDto> getAllParts() {
        List<Part> parts = partService.getAllParts();
        return parts.stream()
                .map(PartMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/id")
    public PartDto getPartById(@PathVariable long id) {
        return partService.getPartByID(id)
                .map(PartMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public ResponseEntity<PartDto> createPart(@RequestBody PartDto partDto) {
        Part part = PartMapper.toEntity(partDto);
        Part savedPart = partService.savePart(part);
        return ResponseEntity.ok(PartMapper.toDto(savedPart));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartDto> updatePart(@PathVariable Long id, @RequestBody PartDto partDto) {
        if (!id.equals(partDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Part part = PartMapper.toEntity(partDto);
        Part updatedPart = partService.updatePart(part);
        return ResponseEntity.ok(PartMapper.toDto(updatedPart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable Long id) {
        if (!partService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        partService.deletePartById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/decrease-stock")
    public ResponseEntity<PartDto> decreaseStock(@PathVariable Long id, @RequestParam int quantity) {
        Part updated = partService.decreaseStock(id, quantity);
        return ResponseEntity.ok(PartMapper.toDto(updated));
    }

    @PostMapping("/{id}/increase-stock")
    public ResponseEntity<PartDto> increaseStock(@PathVariable Long id, @RequestParam int quantity) {
        Part updated = partService.increaseStock(id, quantity);
        return ResponseEntity.ok(PartMapper.toDto(updated));
    }

}

//TODO: specefieke mapping aanmaken in part
//TODO: Workperformed controller vullen
//TODO: Workperformed service vullen
//TODO: Data.sql vullen met gevens voor part en workPerformed
//TODO: Testen met postman