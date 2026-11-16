package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList<Tour> cargarTours(Path rutaLista) throws IOException {

        ArrayList<Tour> listaTours = new ArrayList<>();

        try (BufferedReader lector = Files.newBufferedReader(rutaLista)) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }
                String[] campos = linea.split(";", -1);

                if (campos.length != 4) {
                    System.err.println("Datos incompletos en linea: " + numeroLinea + ". Se continua con la siguiente");
                    continue;
                }

                try {
                    String nombre = campos[0].trim();
                    String ciudad = campos[1].trim();
                    String tipo = campos[2].trim();
                    int valor = Integer.parseInt(campos[3].trim());

                    Tour tour = new Tour(nombre, ciudad, tipo, valor);
                    listaTours.add(tour);
                } catch (IllegalArgumentException e) {
                    System.err.println("Omitiendo linea: " + numeroLinea + ". " + e.getMessage());
                }
            }
            return listaTours;
        }
    }
}
