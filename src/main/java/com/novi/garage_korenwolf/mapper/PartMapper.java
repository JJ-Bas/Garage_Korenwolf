package com.novi.garage_korenwolf.mapper;

import com.novi.garage_korenwolf.dto.PartDto;
import com.novi.garage_korenwolf.models.Part;

public class PartMapper {

    public static PartDto toDto(Part part) {
        if (part == null) {
            return null;
        }

        PartDto dto = new PartDto();
        dto.setId(part.getId());
        dto.setName(part.getName());
        dto.setDescription(part.getDescription());
        dto.setPriceExclusiveTax(part.getPriceExclusiveTax());
        dto.setTaxPercentage(part.getTaxPercentage());
        dto.setMaintenanceJobId(part.getMaintenanceJob() != null ? part.getMaintenanceJob().getId() : null);

        dto.setItemsInStock(part.getItemsInStock());
        dto.setSuppliers(part.getSuppliers());
        dto.setBrand(part.getBrand());
        dto.setCategory(part.getCategory());

        return dto;
    }

    public static Part toEntity(PartDto dto) {
        if (dto == null) {
            return null;
        }

        Part part = new Part();
        part.setId(dto.getId());
        part.setName(dto.getName());
        part.setDescription(dto.getDescription());
        part.setPriceExclusiveTax(dto.getPriceExclusiveTax());
        part.setTaxPercentage(dto.getTaxPercentage());

        // geen maintenanceJob

        part.setItemsInStock(dto.getItemsInStock());
        part.setSuppliers(dto.getSuppliers());
        part.setBrand(dto.getBrand());
        part.setCategory(dto.getCategory());

        return part;
    }
}
