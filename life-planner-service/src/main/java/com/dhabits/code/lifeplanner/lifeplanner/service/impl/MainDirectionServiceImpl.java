package com.dhabits.code.lifeplanner.lifeplanner.service.impl;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import com.dhabits.code.lifeplanner.lifeplanner.db.model.Subdirection;
import com.dhabits.code.lifeplanner.lifeplanner.db.repository.MainDirectionRepository;
import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.dto.SubdirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.mapper.MainDirectionMapper;
import com.dhabits.code.lifeplanner.lifeplanner.service.MainDirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainDirectionServiceImpl implements MainDirectionService {

    private final MainDirectionMapper mainDirectionMapper;
    private final MainDirectionRepository mainDirectionRepository;

    @Override
    public List<MainDirection> createMainDirections(List<MainDirectionDto> mainDirectionDtos) {
        List<MainDirection> mainDirections = new ArrayList<>();
        for(MainDirectionDto mainDirectionDto : mainDirectionDtos) {
            MainDirection mainDirection = mainDirectionMapper.toMapDirection(mainDirectionDto);
            List<SubdirectionDto> subdirectionsDto = mainDirectionDto.getSubdirections();
            Set<Subdirection> subdirections = subdirectionsDto.stream().map(mainDirectionMapper::toSubdirection).peek(subdirection -> subdirection.setMainDirection(mainDirection)).collect(Collectors.toSet());
            mainDirection.setSubdirections(subdirections);
            mainDirections.add(mainDirection);
        }
        mainDirectionRepository.saveAll(mainDirections);
        return mainDirections;
    }
}
