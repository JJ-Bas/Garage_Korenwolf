package com.novi.garage_korenwolf.mappers;


import com.novi.garage_korenwolf.dto.WorkPerformedDto;
import com.novi.garage_korenwolf.models.MaintenanceJob;
import com.novi.garage_korenwolf.models.WorkPerformed;

public class WorkPerformedMapper {

    public static WorkPerformedDto toDto(WorkPerformed entity) {
        if (entity == null) return null;

        WorkPerformedDto dto = new WorkPerformedDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPriceExclusiveTax(entity.getPriceExclusiveTax());
        dto.setTaxPercentage(entity.getTaxPercentage());
        dto.setMaintenanceJobId(entity.getMaintenanceJob() != null ? entity.getMaintenanceJob().getId() : null);

        dto.setWorkTimeInMinutes(entity.getWorkTimeInMinutes());
        dto.setNotes(entity.getNotes());
        dto.setWarranty(entity.isWarranty());

        return dto;
    }

    public static WorkPerformed toEntity(WorkPerformedDto dto) {
        if (dto == null) return null;

        WorkPerformed entity = new WorkPerformed();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPriceExclusiveTax(dto.getPriceExclusiveTax());
        entity.setTaxPercentage(dto.getTaxPercentage());

        //TODO: MaintenanceJob oplossen

        entity.setWorkTimeInMinutes(dto.getWorkTimeInMinutes());
        entity.setNotes(dto.getNotes());
        entity.setWarranty(dto.isWarranty());

        return entity;
    }
}