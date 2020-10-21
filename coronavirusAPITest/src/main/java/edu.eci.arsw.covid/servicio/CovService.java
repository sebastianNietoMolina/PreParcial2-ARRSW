package edu.eci.arsw.covid.servicio;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid.model.Stats;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("covSer")
public interface CovService {

    List<Stats>getAllData() throws UnirestException, StatsExecption;

    List<Stats> getAllProvinceByCountry(String country) throws UnirestException, StatsExecption;
}
