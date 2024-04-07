package com.app.hw;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HwMapper {

    HwMapper HW_MAPPER = Mappers.getMapper(HwMapper.class);

    Destination fromSource(Source source);

    Source toSource(Destination destination);

    List<Destination> toDestionationList(List<Source> sources);
    List<Source> fromDestionationList(List<Destination> destinations);
}
