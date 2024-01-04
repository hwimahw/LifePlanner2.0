package com.dhabits.code.lifeplanner.lifeplanner.service;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;

import java.util.List;

public interface MainDirectionService {
    List<MainDirection> createMainDirections(List<MainDirectionDto> mainDirectionDtos);
}
