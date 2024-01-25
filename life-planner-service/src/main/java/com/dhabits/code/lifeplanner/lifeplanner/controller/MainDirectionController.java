package com.dhabits.code.lifeplanner.lifeplanner.controller;

import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.service.MainDirectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/v1/repository")
@RequiredArgsConstructor
public class MainDirectionController implements MainDirectionApi {

    private final MainDirectionService mainDirectionService;

    @Override
    public ResponseEntity<List<MainDirectionDto>> createMainDirections(@Valid List<MainDirectionDto> mainDirectionDtos) {
        return ResponseEntity.ok(mainDirectionService.createMainDirections(mainDirectionDtos));
    }

    @Override
    public ResponseEntity<List<MainDirectionDto>> updateMainDirections(@Valid List<MainDirectionDto> mainDirectionDtos) {
        return ResponseEntity.ok(mainDirectionService.updateMainDirections(mainDirectionDtos));
    }
}
