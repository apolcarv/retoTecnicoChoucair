package co.com.reto.choucair.helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataUtilities {

    public static String formatearFecha(LocalDate actualDate){
        String dia, mes;
        if(actualDate.getDayOfMonth()<10){
            dia = "0"+actualDate.getDayOfMonth();
        }else{
            dia = String.valueOf(actualDate.getDayOfMonth());
        }

        if(actualDate.getMonth().getValue()<10){
            mes = "0"+actualDate.getMonth().getValue();
        }else{
            mes = String.valueOf(actualDate.getMonth().getValue());
        }

        String fecha =  mes+"/"+dia+"/" +actualDate.getYear();
        return fecha;
    }

    public static String obtenerFechaActual(){
        Date fechaActual = new Date();
        LocalDate actualDate = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return formatearFecha(actualDate);
    }
}
