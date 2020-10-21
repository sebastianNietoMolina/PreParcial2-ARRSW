package edu.eci.arsw.covid.controlador;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid.servicio.StatsExecption;
import edu.eci.arsw.covid.servicio.impl.CovServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stats")
public class StatsAPIControllers {

    @Autowired
    CovServiceImpl cs;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaByName() {
        try {
            return new ResponseEntity<>(cs.getAllData(), HttpStatus.ACCEPTED);
        } catch (StatsExecption | UnirestException ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getDataByCountry(@PathVariable String name) {
        try {
            return new ResponseEntity<>(cs.getAllProvinceByCountry(name), HttpStatus.ACCEPTED);
        } catch (StatsExecption | UnirestException ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
    }



}