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

      @Test void modificAltura () {
       /* When
       * tengo un array con ciertos valores
       * necesito el indice de del valor a cambiar
       * */

       /* Then:
       *  le paso un  indice y un valor a modificar y
       *  y espero ese valor en ese indice
       * */

          int posicion =2;
          double altura = 174.12;

          double [] nuevo = {174, 180, 166, 170, 176};
          AlturaAlumno.modificaAltura(nuevo , posicion , altura );
          assertEquals(altura , nuevo[posicion]);
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




    @Test void buscaNombreEncontrado () {
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

    @Test void mostrarValores () {
        String [] nombres = {"cesar", "jose" , "gabriel" };
        double [] alturas = {174, 180, 166, 170};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        AlturaAlumno.mostrar(nombres,alturas);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        String expectedOutput = "cesar\t|   174.0\njose\t|   180.0\ngabriel\t|   166.0\n";
        assertEquals(expectedOutput, outContent.toString());


    }







}





