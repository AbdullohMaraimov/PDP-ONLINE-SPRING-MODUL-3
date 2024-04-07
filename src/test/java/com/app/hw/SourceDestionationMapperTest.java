package com.app.hw;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.app.hw.HwMapper.HW_MAPPER;

public class SourceDestionationMapperTest {

    @Test
    void toDestination(){
        Source source = new Source("Ali", "Good boy");

        Destination destination = HW_MAPPER.fromSource(source);
        System.out.println(destination);

    }

    @Test
    void toSource() {
        Destination destination = new Destination("Destination 1", "Number 1");
        Source source = HW_MAPPER.toSource(destination);
        System.out.println(source);
    }

    @Test
    void toDestinationList() {
        List<Source> sources = List.of(
                new Source("Source 1", "Source 1 desc"),
                new Source("Source 2", "Source 2 desc"),
                new Source("Source 3", "Source 3 desc")
        );

        List<Destination> destionationList = HW_MAPPER.toDestionationList(sources);
        System.out.println(destionationList);
    }

    @Test
    void fromDestinationList() {
        List<Destination> destinations = List.of(
                new Destination("Destination 1", "Destination 1 desc"),
                new Destination("Destination 2", "Destination 2 desc"),
                new Destination("Destination 3", "Destination 3 desc")
        );

        List<Source> sources1 = HW_MAPPER.fromDestionationList(destinations);
        System.out.println(sources1);
    }


}
