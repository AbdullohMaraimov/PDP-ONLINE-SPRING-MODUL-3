package com.app.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SimpleController {

    private final DatasourceProperties datasourceProperties;
    private final PersonProperties personProperties;

    @GetMapping("/datasource")
    public Datasource datasource() {
        return datasourceProperties.getDatasource();
    }

    @GetMapping("/person")
    public Person person() {
        return personProperties.getPerson();
    }


}
