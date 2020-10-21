package edu.eci.arsw.covid.http.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid.http.HttpConectionService;
import edu.eci.arsw.covid.model.Stats;
import edu.eci.arsw.covid.servicio.StatsExecption;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HttpConectionServiceImpl implements HttpConectionService {

    public HashMap<String, Stats> getAllStats() throws UnirestException, StatsExecption {

        HttpResponse<JsonNode> response = Unirest
                .get("https://rapidapi.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "ec450aa0fbmshb11ee4426a213b5p142f5djsn556e41a3532b")
                .asJson();

        JSONObject data = (JSONObject) response.getBody().getArray().getJSONObject(0).get("data");
        JSONArray data2 = data.getJSONArray("covid19Stats");


        HashMap<String, Stats> res = new HashMap<String, Stats>();
        for (int i=0; i<data2.length(); i++){
            JSONObject ome = data2.getJSONObject(i);
            String country = (String) ome.get("country");
            if(res.containsKey(country)){
                if(!ome.get("confirmed").equals(null)){
                    res.get(country).setConfirmed((int) ome.get("confirmed"));
                }if(!ome.get("recovered").equals(null)){
                    res.get(country).setRecovered((int) ome.get("recovered"));
                }if(!ome.get("deaths").equals(null)){
                    res.get(country).setDeaths((int) ome.get("deaths"));
                }
            }else{
                res.put(country,new Stats());
                res.get(country).setCountry(country);
                if(!ome.get("confirmed").equals(null)){
                    res.get(country).setConfirmed((int) ome.get("confirmed"));
                }if(!ome.get("recovered").equals(null)){
                    res.get(country).setRecovered((int) ome.get("recovered"));
                }if(!ome.get("deaths").equals(null)){
                    res.get(country).setDeaths((int) ome.get("deaths"));
                }
            }
        }

        return res;
    }

    public ArrayList<Stats> getRegions(String count) throws UnirestException,StatsExecption {

        ArrayList<Stats> res = new ArrayList<>();
        HttpResponse<JsonNode> response = Unirest
                .get("https://rapidapi.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "ec450aa0fbmshb11ee4426a213b5p142f5djsn556e41a3532b")
                .asJson();

        JSONObject data = (JSONObject) response.getBody().getArray().getJSONObject(0).get("data");
        JSONArray data2 = data.getJSONArray("covid19Stats");

        for (int i=0; i<data2.length(); i++){
            JSONObject ome = data2.getJSONObject(i);
            String country = (String) ome.get("country");
            if(count.equals(country)){
                if(!ome.get("province").equals(null) && country.equals(count)){
                    Stats stats = new Stats();
                    stats.setCountry(country);
                    stats.setProvince((String) ome.get("province"));
                    if(!ome.get("confirmed").equals(null)){
                        stats.setConfirmed((int) ome.get("confirmed"));
                    }if(!ome.get("recovered").equals(null)){
                        stats.setRecovered((int) ome.get("recovered"));
                    }if(!ome.get("deaths").equals(null)){
                        stats.setDeaths((int) ome.get("deaths"));
                    }
                    res.add(stats);
                }
            }
        }

        return res;
    }

}
