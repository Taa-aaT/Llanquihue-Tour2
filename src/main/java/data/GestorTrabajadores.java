package data;

import model.Trabajadores;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class GestorTrabajadores {
    public ArrayList<Trabajadores> cargarTrabajadores(Path rutaLista2) throws IOException {

        ArrayList<Trabajadores> listaTrabajadores = new ArrayList<>();

        try (BufferedReader lector = Files.newBufferedReader(rutaLista2)) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }
                String[] campos = linea.split(";", -1);

                if (campos.length != 3) {
                    System.err.println("Datos incompletos en linea: " + numeroLinea + ". Se continua con la siguiente");
                    continue;
                }

                try {
                    String nombre = campos[0].trim();
                    String rol = campos[1].trim();
                    String rut = campos[2].trim();

                    Trabajadores trabajadores = new Trabajadores(nombre, rol, rut);
                    listaTrabajadores.add(trabajadores);
                } catch (IllegalArgumentException e) {
                    System.err.println("Omitiendo linea: " + numeroLinea + e.getMessage());
                }
            }
        }
        return listaTrabajadores;

    }

    public void guardarTrabajador(Path ruta, Trabajadores trabajador) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();

        if (Files.exists(ruta)) {
            lineas.addAll(Files.readAllLines(ruta, StandardCharsets.UTF_8));
        }

        String nuevaLinea = trabajador.getNombre() + ";"
                + trabajador.getRol() + ";"
                + trabajador.getRut();

        lineas.add(nuevaLinea);
        Files.write(ruta, lineas, StandardCharsets.UTF_8);
    }

    public boolean eliminarTrabajador(Path ruta, String rutBuscado) throws IOException {
        if (!Files.exists(ruta)) {
            return false;
        }

        ArrayList<String> lineas =
                new ArrayList<>(Files.readAllLines(ruta, StandardCharsets.UTF_8));

        boolean eliminado = false;
        Iterator<String> iterador = lineas.iterator();

        while (iterador.hasNext()) {
            String linea = iterador.next();
            String[] campos = linea.split(";", -1);

            if (campos.length == 3
                    && campos[2].trim().equalsIgnoreCase(rutBuscado.trim())) {
                iterador.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
        }

        return eliminado;
    }
}
