package Controller;

import Model.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class DomoticController implements DomoticControllerInterface {

    DomoticModelInterface model;

    public DomoticController(DomoticModel model) {
        this.model = model;
    }

    @Override
    public void setearTemperatura(int t){
        if(sanitizarTemperatura(t)){
            model.setTemperaturaDeseada(t);
        }
        else{
            //PLACEHOLDER DE TIRAR ERROR
            //view.TIRAR_ERROR_DE_TEMPERATURA
        }
    }

    //Sanitizado de expresion de Temperatura
    boolean sanitizarTemperatura(int T) {
        return (T >= 0 && T <= 40);
    }


    @Override
    public void setearHumedad(int hum) {
        if(sanitizarHumedad(hum)){
            model.setHumedadDeseada(hum);
        }
        else{
            //PLACEHOLDER DE TIRAR ERROR
            //view.TIRAR_ERROR_DE_HUMEDAD
        }
    }

    //Sanitizado de expresion de Humedad
    boolean sanitizarHumedad(int H) {
        return (H >= 0 && H <= 100);
        }



    //Muestra ON u OFF en AC
    public String estadoAC() {
        if (model.getAC()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en Estufa
    public String estadoEstufa() {
        if (model.getEstufa()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en humidificador
    public String estadoHumidificador() {
        if (model.getHumidificador()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    public void generarTxt(){
        System.out.println("Generando .txt");
        new File("EstadoActual.txt");
        PrintWriter printWriter = null;
         try {
            printWriter = new PrintWriter("EstadoActual.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println("Temperatura medida por el sensor");
        printWriter.println(Integer.toString(model.getTemperaturaSensor()));
        printWriter.println("Humedad medida por el sensor");
        printWriter.println(Integer.toString(model.getHumedadSensor()));
        printWriter.println("Estado actual del AC");
        printWriter.println(estadoAC());
        printWriter.println("Estado actual de la estufa");
        printWriter.println(estadoEstufa());
        printWriter.println("Estado actual del humidificador");
        printWriter.println(estadoHumidificador());
        printWriter.close();
    }
}
