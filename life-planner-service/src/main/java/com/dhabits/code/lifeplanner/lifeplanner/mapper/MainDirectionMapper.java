package com.dhabits.code.lifeplanner.lifeplanner.mapper;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import com.dhabits.code.lifeplanner.lifeplanner.db.model.Subdirection;
import com.dhabits.code.lifeplanner.lifeplanner.dto.MainDirectionDto;
import com.dhabits.code.lifeplanner.lifeplanner.dto.SubdirectionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainDirectionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subdirections", ignore = true)
    MainDirection toMapDirection(MainDirectionDto mapDirectionDto);

    List<MainDirectionDto> toMapDirectionDtoList(Iterable<MainDirection> mapDirection);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mainDirection", ignore = true)
    Subdirection toSubdirection(SubdirectionDto subdirectionDto);


//    default String getManufacturingDate(MainDirection mainDirection) {
//        Date d = manufacturingDate.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat( "dd.MM.yyyy" );
//        return sdf.format( d );
//    }

}
