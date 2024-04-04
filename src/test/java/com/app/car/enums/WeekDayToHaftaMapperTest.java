package com.app.car.enums;

import org.junit.jupiter.api.Test;

import static com.app.car.enums.WeekDayToHaftaMapper.WEEK_DAY_TO_HAFTA_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class WeekDayToHaftaMapperTest {

    @Test
    void from() {
        WeekDays friday = WEEK_DAY_TO_HAFTA_MAPPER.from(Hafta.JUMA);
        System.out.printf(friday + "");
    }

    @Test
    void to() {
        Hafta dushanba = WEEK_DAY_TO_HAFTA_MAPPER.to(WeekDays.MONDAY);
        System.out.println(dushanba + "");
    }
}