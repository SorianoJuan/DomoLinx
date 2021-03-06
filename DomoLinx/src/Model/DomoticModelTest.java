package Model;

import Controller.DomoticController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DomoticModelTest {

    private DomoticModel model=DomoticModel.getInstance();
    private DomoticController controlador=new DomoticController(model);

    @Test
    public void test_setTemperaturaDeseada_maxima(){
        model.setTemperaturaDeseada(40);
        assertEquals(40,model.getTemperaturaDeseada());
    }

    @Test
    public void test_setTemperaturaDeseada_minima(){
        model.setTemperaturaDeseada(0);
        assertEquals(0,model.getTemperaturaDeseada());
    }

    @Test
    public void test_getTemperaturaDeseada(){
        model.setTemperaturaDeseada(5);
        assertEquals(5, model.getTemperaturaDeseada());
    }

    //Este test debe fallar porque se intenta ingresar un valor de humedad no valido
    @Test
    public void test_setHumedadDeseada(){
        model.setHumedadDeseada(101);
        assertEquals(101,model.getHumedadDeseada());
    }

    @Test
    public void test_setHumedadDeseada_valor_Valido(){
        model.setHumedadDeseada(2);
        assertEquals(2,model.getHumedadDeseada());
    }

    @Test
    public void test_setHumedadDeseada_valor_maximo(){
        model.setHumedadDeseada(100);
        assertEquals(100,model.getHumedadDeseada());
     }

    @Test
    public void test_getHumedadDeseada(){
        model.setHumedadDeseada(50);
        assertEquals(50,model.getHumedadDeseada());
     }

     @Test
    public void testSetAc(){
        model.setTemperaturaSensor(30);
        model.setTemperaturaDeseada(24);
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         assertTrue(model.getAC());
     }

    @Test
    public void testSetEstufa() {
        model.setTemperaturaSensor(14);
        model.setTemperaturaDeseada(26);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(model.getEstufa());
    }

        @Test
        public void testSetHumidificador () {
            model.setTemperaturaSensor(36);
            model.setTemperaturaDeseada(70);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertTrue(model.getHumidificador());
        }
}