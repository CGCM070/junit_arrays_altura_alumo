package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class AlturaAlumnoTest{



     @Test void aniadeNombre() {
          String [] array = new String[0];
          String nombre = "Jose";

          String [] arrayActual = AlturaAlumno.aniadeNombre(array, nombre);

          assertTrue (arrayActual.length == array.length+1);

          assertEquals(nombre, arrayActual[arrayActual.length-1]);

          String [] actual = Arrays.copyOfRange(arrayActual , 0 , array.length );
          assertArrayEquals(array , actual);

     }


    @Test void aniadeNombreFalla() {
        String[] array = new String[0];
        String nombre = "";

        String[] arrayActual = AlturaAlumno.aniadeNombre(array, nombre);

        assertTrue (arrayActual.length == array.length+1);

        assertEquals(nombre, arrayActual[arrayActual.length-1]);

        String[] actual = Arrays.copyOfRange(arrayActual , 0 , array.length );
        assertArrayEquals(array , actual);

    }

      @Test void modificAltura () {

          int posicion =2;
          double altura = 174.12;

          double [] nuevo = {174, 180, 166, 170, 176};
          AlturaAlumno.modificaAltura(nuevo , posicion , altura );
          assertEquals(altura , nuevo[posicion]);
      }

    @Test void modificAlturaFalla() {
        double[] array = new double[3];
        double alturaPorDefecto = 1.5;
        int indiceFueradeRango= 3;

        double[] arrayEsperado = new double[3];
        AlturaAlumno.modificaAltura(array, indiceFueradeRango, alturaPorDefecto);
        assertArrayEquals(arrayEsperado, array);



    }

    @Test void aniadeAltura () {

        double alturaDefecto = 1.5;
        double [] original =  {160.0,170.0, 171.0 };
        double [] nuevo = AlturaAlumno.aniadeAltura(original);


        assertEquals(alturaDefecto, nuevo[nuevo.length-1]);

         double [] nuevo2= Arrays.copyOfRange(original, 0 , original.length);
        assertArrayEquals(nuevo2, original);

        //comprobamos los valores si han sido copiado correctamente
        /*for (int i =0 ; i<original.length; i++ ) {
            assertEquals(original[i] , nuevo[i]);
        }*/
    }




    @Test void buscaNomreEncontrado () {
        int indiceEsperado =1;
        String [] nombres = {"cesar", "jose" , "gabriel" };
        String nombre = "jose";

       int indice = AlturaAlumno.buscaNombre(nombres, nombre);
        assertEquals(indiceEsperado,indice );
    }

    @Test void buscaNombreNoEncontrado () {
        int indiceEsperado =-1;
        String [] nombres = {"cesar", "jose" , "gabriel" };
        String nombre = "ruben";

        int indice = AlturaAlumno.buscaNombre(nombres, nombre);
        assertEquals(indiceEsperado,indice );
    }



        /*Profe estuve averiguando para el caso de imprimir
        * el ByteArrayOutputStream fue lo que encontré */
      /*  @Test void mostrarValores () {
            String [] nombres = {"cesar", "jose" , "gabriel", "nombre_extra" };
            double [] alturas = {174, 180, 166, 170};

            ByteArrayOutputStream salida = new ByteArrayOutputStream();
            System.setOut(new PrintStream(salida));

            AlturaAlumno.mostrar(nombres,alturas);
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

            String salidaEsperada = "cesar\t|   174.0\njose\t|   180.0\ngabriel\t|   166.0\nnombre_extra\t|   170.0\n";
            assertEquals(salidaEsperada, salida.toString());
        }*/


    @Test void calculaMaximo (){
        double[] array ={2.0,3.0,4.0};
        double indiceEsperado =2;
        double valorEsperado=4.0;

        double [] resultadoEsperado = {indiceEsperado, valorEsperado};
        double [] resultado = AlturaAlumno.calculaMaximo(array);

        assertArrayEquals(resultadoEsperado, resultado);

    }
    @Test void calculaMaximoFalla (){
        double[] array ={};
        double indiceEsperado =0;
        double valorEsperado=0;

        double [] resultadoEsperado = {indiceEsperado, valorEsperado};
        double [] resultado = AlturaAlumno.calculaMaximo(array);

        assertArrayEquals(resultadoEsperado, resultado);

    }



    @Test void calculaMedia (){
        double[] array ={2.0,2.0,2.0};
        double mediaEsperada=2.0;

        double media = AlturaAlumno.calculaMedia(array);
        assertEquals(mediaEsperada, media);

    }
    @Test void calculaMediaFalla (){
        double[] array ={};
        double mediaEsperada=0.0;

        double media = AlturaAlumno.calculaMedia(array);
        assertEquals(mediaEsperada, media);

    }




}





