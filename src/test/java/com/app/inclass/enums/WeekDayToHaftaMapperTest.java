package com.app.inclass.enums;

import org.junit.jupiter.api.Test;

import static com.app.inclass.enums.WeekDayToHaftaMapper.WEEK_DAY_TO_HAFTA_MAPPER;

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