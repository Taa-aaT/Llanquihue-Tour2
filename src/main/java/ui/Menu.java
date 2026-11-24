package ui;

import data.GestorTours;
import model.Tour;
import data.GestorTrabajadores;
import model.Trabajadores;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final ArrayList<Tour> tours;
    private final Scanner teclado;
    private final GestorTours gestorTours;
    private final Path rutaArchivo;

    private final ArrayList<Trabajadores> trabajadores;
    private final GestorTrabajadores gestorTrabajadores;
    private final Path rutaTrabajadores;

    public Menu(ArrayList<Tour> tours,
                ArrayList<Trabajadores> trabajadores,
                Scanner teclado,
                GestorTours gestorTours,
                Path rutaArchivo,
                GestorTrabajadores gestorTrabajadores,
                Path rutaTrabajadores) {

        this.tours = tours;
        this.trabajadores = trabajadores;
        this.teclado = teclado;
        this.gestorTours = gestorTours;
        this.rutaArchivo = rutaArchivo;
        this.gestorTrabajadores = gestorTrabajadores;
        this.rutaTrabajadores = rutaTrabajadores;
    }

    public void mostrarMenuPrincipal() {
        boolean continuarPrograma = true;

        while (continuarPrograma) {
            System.out.println("\n***** MENÚ PRINCIPAL *****");
            System.out.println("[1] Trabajadores y entidades relacionadas");
            System.out.println("[2] Tours");
            System.out.println("[0] Salir");

            String opcion = teclado.nextLine();

            if (opcion.equals("1")) {
                mostrarMenuTrabajadores();

            } else if (opcion.equals("2")) {
                mostrarMenuTours();

            } else if (opcion.equals("0")) {
                continuarPrograma = false;
                System.out.println("Saliendo del programa.");

            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void mostrarMenuTours() {
        boolean continuarTours = true;

        while (continuarTours) {
            System.out.println("\n***** MENÚ DE TOURS *****");
            System.out.println("[1] Ver lista completa de tours");
            System.out.println("[2] Aplicar filtro");
            System.out.println("[3] Agregar tour");
            System.out.println("[0] Volver al menú principal");

            String opcion = teclado.nextLine();

            if (opcion.equals("1")) {
                mostrarTodosLosTours();

            } else if (opcion.equals("2")) {
                mostrarMenuFiltros();

            } else if (opcion.equals("3")) {
                agregarTour();

            } else if (opcion.equals("0")) {
                continuarTours = false;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void mostrarTodosLosTours() {
        System.out.println("\n***** LISTA DE TOURS DISPONIBLES *****");

        if (tours.isEmpty()) {
            System.out.println("No hay tours registrados.");
            return;
        }

        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }

    private void mostrarMenuFiltros() {
        System.out.println("\n¿Qué tipo de filtro desea utilizar?");
        System.out.println("[1] Tipo de tour");
        System.out.println("[2] Precio");
        System.out.println("[3] Destino");

        String opcionFiltro = teclado.nextLine();

        if (opcionFiltro.equals("1")) {
            filtrarPorTipo();

        } else if (opcionFiltro.equals("2")) {
            mostrarMenuPrecio();

        } else if (opcionFiltro.equals("3")) {
            filtrarPorDestino();

        } else {
            System.out.println("Opción de filtro no válida.");
        }
    }

    private void filtrarPorTipo() {
        System.out.println("\n¿Qué tipo de tour desea buscar?");
        System.out.println("[1] Cultural");
        System.out.println("[2] Lacustre");
        System.out.println("[3] Naturaleza");
        System.out.println("[4] Gastronomico");

        String opcionTipo = teclado.nextLine();
        String tipoBuscado = "";

        if (opcionTipo.equals("1")) {
            tipoBuscado = "Cultural";
        } else if (opcionTipo.equals("2")) {
            tipoBuscado = "Lacustre";
        } else if (opcionTipo.equals("3")) {
            tipoBuscado = "Naturaleza";
        } else if (opcionTipo.equals("4")) {
            tipoBuscado = "Gastronomico";
        } else {
            System.out.println("Opción de tipo no válida.");
            return;
        }

        boolean encontrado = false;
        System.out.println("\n***** TOURS DE " + tipoBuscado.toUpperCase() + " *****");

        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase(tipoBuscado)) {
                System.out.println(tour);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron tours de ese tipo.");
        }
    }

    private void mostrarMenuPrecio() {
        System.out.println("\n¿Cómo desea buscar por precio?");
        System.out.println("[1] Buscar por rango de precios");
        System.out.println("[2] Buscar un precio exacto");

        String opcionPrecio = teclado.nextLine();

        if (opcionPrecio.equals("1")) {
            filtrarPorRangoDePrecio();

        } else if (opcionPrecio.equals("2")) {
            filtrarPorPrecioExacto();

        } else {
            System.out.println("Opción de precio no válida.");
        }
    }

    private void filtrarPorRangoDePrecio() {
        System.out.print("Ingrese el precio mínimo: ");
        Integer precioMinimo = leerEntero();

        if (precioMinimo == null || precioMinimo < 0) {
            System.out.println("Debe ingresar un numero valido mayor a 0");
            return;
        }

        System.out.print("Ingrese el precio máximo: ");
        Integer precioMaximo = leerEntero();

        if (precioMaximo == null || precioMaximo <= 0) {
            System.out.println("Debe ingresar un numero valido mayor a 0");
            return;
        }

        if (precioMinimo > precioMaximo) {
            System.out.println("El precio mínimo no puede ser mayor que el máximo.");
            return;
        }

        boolean encontrado = false;
        System.out.println("\n***** TOURS ENTRE $" + precioMinimo + " Y $" + precioMaximo + " *****");

        for (Tour tour : tours) {
            if (tour.getPrecio() >= precioMinimo
                    && tour.getPrecio() <= precioMaximo) {
                System.out.println(tour);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours en ese rango de precios.");
        }
    }

    private void filtrarPorPrecioExacto() {
        System.out.print("Ingrese el precio que desea buscar: ");
        Integer precioBuscado = leerEntero();

        if (precioBuscado == null) {
            return;
        }

        boolean encontrado = false;
        System.out.println("\n***** TOURS CON PRECIO $" + precioBuscado + " *****");

        for (Tour tour : tours) {
            if (tour.getPrecio() == precioBuscado) {
                System.out.println(tour);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours de ese precio.");
        }
    }

    private void filtrarPorDestino() {
        System.out.print("Ingrese el destino que desea buscar: ");
        String destinoBuscado = teclado.nextLine();

        boolean encontrado = false;
        System.out.println("\n***** TOURS EN " + destinoBuscado.toUpperCase() + " *****");

        for (Tour tour : tours) {
            if (tour.getCiudad().equalsIgnoreCase(destinoBuscado)) {
                System.out.println(tour);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tours con el destino deseado.");
        }
    }

    private Integer leerEntero() {
        String entrada = teclado.nextLine();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un número entero.");
            return null;
        }
    }

    private void agregarTour() {
        try {
            System.out.print("Nombre del tour: ");
            String nombre = teclado.nextLine();

            System.out.print("Ciudad o destino: ");
            String ciudad = teclado.nextLine();

            System.out.print("Tipo (Cultural, Lacustre, Naturaleza, Gastronomico): ");
            String tipo = teclado.nextLine();

            System.out.print("Precio: ");
            int precio = Integer.parseInt(teclado.nextLine());

            Tour tour = new Tour(nombre, ciudad, tipo, precio);
            gestorTours.guardarTour(rutaArchivo, tour);
            tours.add(tour);

            System.out.println("Tour agregado a la lista.");

        } catch (NumberFormatException e) {
            System.out.println("El precio debe ser un número entero.");

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo crear el tour: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("No se pudo guardar el tour: " + e.getMessage());
        }
    }
    private void mostrarMenuTrabajadores() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n***** TRABAJADORES Y ENTIDADES *****");
            System.out.println("[1] Ver listado de trabajadores y roles");
            System.out.println("[2] Añadir trabajador al sistema");
            System.out.println("[3] Borrar trabajador del sistema");
            System.out.println("[0] Volver al menú principal");

            String opcion = teclado.nextLine();

            if (opcion.equals("1")) {
                mostrarTrabajadores();

            } else if (opcion.equals("2")) {
                agregarTrabajador();

            } else if (opcion.equals("3")) {
                borrarTrabajador();

            } else if (opcion.equals("0")) {
                continuar = false;

            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void mostrarTrabajadores() {
        System.out.println("\n***** LISTADO DE TRABAJADORES *****");

        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
            return;
        }

        System.out.printf("%-25s | %-35s | %-12s%n", "NOMBRE", "ROL", "RUT");
        System.out.println("--------------------------------------------------------------------------");

        for (Trabajadores trabajador : trabajadores) {
            System.out.printf(
                    "%-25s | %-35s | %-12s%n",
                    trabajador.getNombre(),
                    trabajador.getRol(),
                    trabajador.getRut()
            );
        }
    }

    private void agregarTrabajador() {
        try {
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Rol: ");
            String rol = teclado.nextLine();

            System.out.print("RUT (formato 12345678-9): ");
            String rut = teclado.nextLine();

            Trabajadores nuevo = new Trabajadores(nombre, rol, rut);

            for (Trabajadores existente : trabajadores) {
                if (existente.getRut().equalsIgnoreCase(nuevo.getRut())) {
                    System.out.println("Ya existe un trabajador con ese RUT.");
                    return;
                }
            }

            gestorTrabajadores.guardarTrabajador(rutaTrabajadores, nuevo);
            trabajadores.add(nuevo);

            System.out.println("Trabajador agregado y guardado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo agregar: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("No se pudo guardar el trabajador: " + e.getMessage());
        }
    }

    private void borrarTrabajador() {
        System.out.print("Ingrese el RUT del trabajador que desea borrar: ");
        String rutBuscado = teclado.nextLine().trim();

        Trabajadores trabajadorEncontrado = null;

        for (Trabajadores trabajador : trabajadores) {
            if (trabajador.getRut().equalsIgnoreCase(rutBuscado)) {
                trabajadorEncontrado = trabajador;
                break;
            }
        }

        if (trabajadorEncontrado == null) {
            System.out.println("No se encontró un trabajador con ese RUT.");
            return;
        }

        try {
            boolean eliminado = gestorTrabajadores.eliminarTrabajador(
                    rutaTrabajadores,
                    rutBuscado
            );

            if (eliminado) {
                trabajadores.remove(trabajadorEncontrado);
                System.out.println("Trabajador eliminado correctamente.");
            } else {
                System.out.println("No se encontró el registro en trabajadores.txt.");
            }

        } catch (IOException e) {
            System.out.println("No se pudo actualizar el archivo: " + e.getMessage());
        }
    }
}