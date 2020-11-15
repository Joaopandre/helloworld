package pt.iade.helloworld.controllers;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.helloworld.models.CurricularUnit;

@RestController
@RequestMapping(path = "/api/java/tester")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);

    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();

    @PostMapping(path = "/units")
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
        logger.info("Added unit " + unit.getName());
        units.add(unit);
        return unit;
    }

}
