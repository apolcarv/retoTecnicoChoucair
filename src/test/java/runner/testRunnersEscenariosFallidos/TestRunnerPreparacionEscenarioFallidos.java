package runner.testRunnersEscenariosFallidos;

import co.com.reto.choucair.helpers.AssertExceptions;
import co.com.reto.choucair.helpers.ManagerLog;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestRunnerPreparacionEscenarioFallidos {
    @Test
    public void crearArchivos(){
        try{
            ManagerLog.imprimirExito("Inicio de la preparacion para ejecutar escenarios fallidos");
            List<String> escenariosFallidos = new ArrayList<>();
            escenariosFallidos.add("escenariosFallidosTestRunnerRetoPracticoFRONT.txt");
            String ruta = "target/";
            File directorio = new File("target/");
            directorio.mkdir();
            for (int i = 0; i < escenariosFallidos.size(); i++) {
                File archivo = new File(ruta.concat(escenariosFallidos.get(i)));
                BufferedWriter bw;
                if (archivo.exists()) {

                } else {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("");
                    bw.close();
                }

            }
        }catch (IOException e) {
            Assert.fail("TestRunnerPreparacionEscenariosFallidos terminó con excepción: " + AssertExceptions.getErrorStackTrace(e));
        }
    }
}
