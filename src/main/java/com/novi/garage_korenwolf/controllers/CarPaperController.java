package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.CarDto;
import com.novi.garage_korenwolf.dto.CarPaperDto;
import com.novi.garage_korenwolf.models.CarPaper;
import com.novi.garage_korenwolf.services.CarPaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/carPapers")
public class CarPaperController {

    private final CarPaperService carPaperService;

    public CarPaperController(CarPaperService carPaperService) {
        this.carPaperService = carPaperService;
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<CarPaperDto>> getCarPapersByPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(carPaperService.getCarPapersByPerson(personId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarPaperDto> getCarPaper(@PathVariable Long id) {
        return ResponseEntity.ok(carPaperService.getCarPaper(id));
    }

    @GetMapping("/{id}/file")
    public ResponseEntity<byte[]> getCarPaperFile(@PathVariable Long id) {
        byte[] pdf = carPaperService.getCarPaperFile(id);

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "inline; filename=carpaper.pdf")
                .body(pdf);
    }

    @PostMapping("/upload/{personId}")
    public ResponseEntity<CarPaperDto> uploadCarPaper(
            @PathVariable Long personId,
            @RequestParam("file") MultipartFile file) throws IOException {

        CarPaperDto dto = carPaperService.uploadCarPaper(personId, file);
        return ResponseEntity.ok(dto);
    }
}

