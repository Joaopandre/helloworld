package pt.iade.helloworld.controllers;

import java.util.ArrayList;
import java.util.Scanner;

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

    @GetMapping(path = "/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CurricularUnit> getUnits() {
        logger.info("Get " + units.size() + " Units");
        return units;
    }

    @GetMapping(path = "/average", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getAverage() {
        // logger.info("Get "+units.size()+" Units");
        double result = 0;
        for (int i = 0; i < units.size(); i++) {
            result += units.get(i).getGrade() * units.get(i).getEcts();
        }
        return result / units.size();
    }

    @GetMapping(path = "/maxGrade", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getMaxGrade() {
        // logger.info("Get "+units.size()+" Units");
        double result = -1;
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getGrade() > result) {
                result = units.get(i).getGrade();
            }

        }
        return result;
    }

    @GetMapping(path = "/getGradeByUC", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getGradeByUC() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        String userName = myObj.nextLine();
        double result = -1;
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getName().equals(userName)) {
                result = units.get(i).getGrade();
            }

        }
        return result;
    }

    @GetMapping(path = "/getUCSBySemestre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<String> getUCSBySemestre() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter semestre");

        int semestre = myObj.nextInt();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getSemestre() == semestre) {
                result.add(units.get(i).getName());
            }

        }
        return result;
    }

    @GetMapping(path = "/getUCSByLimit",
     produces= MediaType.APPLICATION_JSON_VALUE)
     public double getUCSByLimit() {

    Scanner myObj = new Scanner(System.in);  

        System.out.println("Enter min");
       double min = myObj.nextDouble(); ;  

    System.out.println("Enter max");
       double max = myObj.nextDouble();  

    double result = 0;

    for ( int i = 0; i< units.size(); i++){
        if( ( units.get(i).getGrade()>= min) && (units.get(i).getGrade() <=max)){
            result ++;
        }    
        
    }
     return result;
 }
}
