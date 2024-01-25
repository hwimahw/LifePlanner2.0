package com.dhabits.code.lifeplanner.lifeplanner.service;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;
import jakarta.validation.Valid;

import java.util.List;

public interface MainDirectionService {
    List<MainDirectionDto> createMainDirections(List<MainDirectionDto> mainDirectionDtos);

    List<MainDirectionDto> updateMainDirections(List<MainDirectionDto> mainDirectionDto);
}
