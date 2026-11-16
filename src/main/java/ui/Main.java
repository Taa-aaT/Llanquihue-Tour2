package ui;

import data.GestorDatos;
import model.Tour;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args){

        Path rutaArchivo = Path.of("src/main/resources/tours.txt");
        GestorDatos gestor = new GestorDatos();

        try{
            ArrayList<Tour> tours = gestor.cargarTours(rutaArchivo);
            //Recorrido
            System.out.println("******LISTA DE TOURS DISPONIBLES******\n");
            for (Tour tour : tours) {
                System.out.println(tour);
            }

            //Filtro 1
            System.out.println("\nTOURS DE ¨NATURALEZA¨:");
            for (Tour tour : tours) {
                if (tour.getTipo().equalsIgnoreCase("Naturaleza")) {
                    System.out.println(tour);
                }
            }

            //Filtro 2

            System.out.println("\nTOURS POR MENOS DE $35.000 PESOS");
            boolean tourMenos35000 = false;
            for (Tour tour : tours){
                if (tour.getPrecio() < 35000){
                    System.out.println(tour);
                    tourMenos35000 = true;
                }
            }
            if (!tourMenos35000){
                System.out.println("No tenemos tours disponibles en este momento");
            }

        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        }

    }

}
