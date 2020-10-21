package edu.eci.arsw.covid.http;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid.model.Stats;
import edu.eci.arsw.covid.servicio.StatsExecption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("httpCov")
public interface HttpConectionService {

    public HashMap<String, Stats> getAllStats() throws UnirestException, StatsExecption;

    public ArrayList<Stats> getRegions(String count) throws UnirestException,StatsExecption;
}
