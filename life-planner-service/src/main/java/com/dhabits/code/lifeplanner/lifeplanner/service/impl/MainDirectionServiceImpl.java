package com.dhabits.code.lifeplanner.lifeplanner.service.impl;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import com.dhabits.code.lifeplanner.lifeplanner.db.model.Subdirection;
import com.dhabits.code.lifeplanner.lifeplanner.db.repository.MainDirectionRepository;
import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.dto.SubdirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.mapper.MainDirectionMapper;
import com.dhabits.code.lifeplanner.lifeplanner.service.MainDirectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainDirectionServiceImpl implements MainDirectionService {

    private final MainDirectionMapper mainDirectionMapper;
    private final MainDirectionRepository mainDirectionRepository;

    @Override
    public List<MainDirectionDto> createMainDirections(List<MainDirectionDto> mainDirectionDtos) {
        List<MainDirection> mainDirections = new ArrayList<>();
        for (MainDirectionDto mainDirectionDto : mainDirectionDtos) {
            MainDirection mainDirection = mainDirectionMapper.toMapDirection(mainDirectionDto);
            mainDirections.add(setMainDirectionToItsSubdirectionsBeforeSaving(mainDirection, mainDirectionDto));
        }
        return mainDirectionMapper.toMapDirectionDtoList(mainDirectionRepository.saveAll(mainDirections));
    }

    @Override
    public List<MainDirectionDto> updateMainDirections(@Valid List<MainDirectionDto> mainDirectionDtos) {
        List<MainDirection> mainDirectionsForUpdating = new ArrayList<>();
        for (MainDirectionDto mainDirectionDto : mainDirectionDtos) {
            Optional<MainDirection> mainDirectionOptional = mainDirectionRepository.findById(mainDirectionDto.getId());
            mainDirectionOptional.ifPresent(mainDirection -> updateAndCollectMainDirection(mainDirection, mainDirectionDto, mainDirectionsForUpdating));
        }
        return mainDirectionMapper.toMapDirectionDtoList(mainDirectionRepository.saveAll(mainDirectionsForUpdating));
    }

    private MainDirection setMainDirectionToItsSubdirectionsBeforeSaving(MainDirection mainDirection, MainDirectionDto mainDirectionDto) {
        List<SubdirectionDto> subDirectionsDto = mainDirectionDto.getSubdirections();
        Set<Subdirection> subDirections = subDirectionsDto.stream().map(mainDirectionMapper::toSubdirection).peek(subDirection -> subDirection.setMainDirection(mainDirection)).collect(Collectors.toSet());
        mainDirection.setSubdirections(subDirections);
        return mainDirection;
    }

    private void updateAndCollectMainDirection(MainDirection mainDirection, MainDirectionDto mainDirectionDto, List<MainDirection> mainDirectionsForUpdating) {
        mainDirection.setName(mainDirectionDto.getName());
        mainDirection.setIdf(mainDirectionDto.getIdf());
        List<SubdirectionDto> subdirectionDtos = mainDirectionDto.getSubdirections();
        Map<UUID, List<SubdirectionDto>> subdirectionsMap = subdirectionDtos.stream().collect(Collectors.groupingBy(SubdirectionDto::getId, Collectors.toList()));
        Set<Subdirection> subdirections = mainDirection.getSubdirections();
        for (Subdirection subdirection : subdirections) {
            //Группировка (grouping by) была сделана по id, являющемуся уникальным полем
            SubdirectionDto subdirectionDto = subdirectionsMap.get(subdirection.getId()).get(0);
            if(subdirectionDto != null) {
                updateSubDirection(subdirection, subdirectionDto);
            }
        }
        mainDirectionsForUpdating.add(mainDirection);
    }

    private Subdirection updateSubDirection(Subdirection subdirection, SubdirectionDto subdirectionDto) {
        subdirection.setName(subdirectionDto.getName());
        subdirection.setIdf(subdirectionDto.getIdf());
        subdirection.setParentIdf(subdirectionDto.getParentIdf());
        return subdirection;
    }
}