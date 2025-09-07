package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.CarPaperDto;
import com.novi.garage_korenwolf.models.CarPaper;
import com.novi.garage_korenwolf.models.Person;
import com.novi.garage_korenwolf.repositories.CarPaperRepository;
import com.novi.garage_korenwolf.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarPaperService {
    private final CarPaperRepository carPaperRepository;
    private final PersonRepository personRepository;

    public CarPaperService(CarPaperRepository carPaperRepository, PersonRepository personRepository) {
        this.carPaperRepository = carPaperRepository;
        this.personRepository = personRepository;
    }

    public CarPaperDto uploadCarPaper(Long personId, MultipartFile file) throws IOException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        CarPaper carPaper = new CarPaper();
        carPaper.setFileName(file.getOriginalFilename());
        carPaper.setData(file.getBytes());
        carPaper.setPerson(person);

        carPaperRepository.save(carPaper);

        return toDto(carPaper);
    }

    public List<CarPaperDto> getCarPapersByPerson(Long personId) {
        return carPaperRepository.findByPersonId(personId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CarPaperDto getCarPaper(Long id) {
        CarPaper carPaper = carPaperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarPaper not found"));
        return toDto(carPaper);
    }

    private CarPaperDto toDto(CarPaper carPaper) {
        CarPaperDto dto = new CarPaperDto();
        dto.setId(carPaper.getId());
        dto.setFileName(carPaper.getFileName());
        dto.setPersonId(carPaper.getPerson().getId());
        dto.setData(carPaper.getData());
        return dto;
    }

    public byte[] getCarPaperFile(Long id) {
        CarPaper carPaper = carPaperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarPaper not found"));
        return carPaper.getData();
    }

}
