package edu.eci.arsw.covid.servicio;

public class StatsExecption extends Exception{

    public StatsExecption(String message) {
        super(message);
    }

    public StatsExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
