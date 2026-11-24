package ui;

import data.GestorTours;
import data.GestorTrabajadores;
import model.Tour;
import model.Trabajadores;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Path rutaArchivo = Path.of("src/main/resources/tours.txt");
        Path rutaTrabajadores = Path.of("src/main/resources/trabajadores.txt");

        GestorTours gestorTours = new GestorTours();
        GestorTrabajadores gestorTrabajadores = new GestorTrabajadores();

        try {
            ArrayList<Tour> tours = gestorTours.cargarTours(rutaArchivo);
            ArrayList<Trabajadores> trabajadores =
                    gestorTrabajadores.cargarTrabajadores(rutaTrabajadores);

            Scanner teclado = new Scanner(System.in);

            Menu menu = new Menu(
                    tours,
                    trabajadores,
                    teclado,
                    gestorTours,
                    rutaArchivo,
                    gestorTrabajadores,
                    rutaTrabajadores
            );
            menu.mostrarMenuPrincipal();

        } catch (IOException e) {
            System.out.println("No se pudo leer un archivo: " + e.getMessage());
        }
    }
}