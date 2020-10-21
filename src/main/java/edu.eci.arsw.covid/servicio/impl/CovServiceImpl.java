package edu.eci.arsw.covid.servicio.impl;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid.http.HttpConectionService;
import edu.eci.arsw.covid.model.Stats;
import edu.eci.arsw.covid.servicio.CovService;
import edu.eci.arsw.covid.servicio.StatsExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service()
public class CovServiceImpl implements CovService {

    @Autowired
    HttpConectionService hcs;

    @Override
    public List<Stats> getAllData() throws UnirestException, StatsExecption {
        List<Stats> st = new ArrayList<>();
        for(Stats stats : hcs.getAllStats().values()){
            st.add(stats);
        }
        return st;
    }

    @Override
    public List<Stats> getAllProvinceByCountry(String country) throws UnirestException, StatsExecption {
        return hcs.getRegions(country);
    }
}
