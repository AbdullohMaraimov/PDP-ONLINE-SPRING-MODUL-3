package com.app.inclass.enums;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeekDayToHaftaMapper {
    WeekDayToHaftaMapper WEEK_DAY_TO_HAFTA_MAPPER = Mappers.getMapper(WeekDayToHaftaMapper.class);

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "FRIDAY", source = "JUMA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    WeekDays from(Hafta hafta);

    @InheritInverseConfiguration
    Hafta to(WeekDays weekDays);
}