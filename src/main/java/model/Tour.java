package model;

public class Tour {

    private String nombre;
    private String ciudad;
    private String tipo;
    private int precio;

    public Tour() {
        this.nombre = "Sin nombre de tour";
        this.ciudad = "Sin ciudad";
        this.tipo = "Sin tipo";
        this.precio = 0;
    }

    public Tour(String nombre, String ciudad, String tipo, int precio) {
        setNombre(nombre);
        setCiudad(ciudad);
        setTipo(tipo);
        setPrecio(precio);
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del tour no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.isBlank()  || ciudad.isEmpty()) {
            throw new IllegalArgumentException(
                    "El destino no puede estar vacío.");
        }
        this.ciudad = ciudad.trim();
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank() || tipo.isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de tour no puede estar vacío.");
        }

        String tipoLimpio = tipo.trim();

        if (tipoLimpio.equalsIgnoreCase("Cultural")) {
            this.tipo = "Cultural";
        } else if (tipoLimpio.equalsIgnoreCase("Lacustre")) {
            this.tipo = "Lacustre";
        } else if (tipoLimpio.equalsIgnoreCase("Naturaleza")) {
            this.tipo = "Naturaleza";
        } else if (tipoLimpio.equalsIgnoreCase("Gastronomico")) {
            this.tipo = "Gastronomico";
        } else {
            throw new IllegalArgumentException(
                    "Este tipo de tour no es válido: " + tipo);}
    }

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser un numero positivo mayor que 0.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "Nombre del Tour ='" + nombre + '\'' +
                " || Ciudad ='" + ciudad + '\'' +
                " || Tipo de  ='" + tipo + '\'' +
                " || Precio = $" + precio +
                '}';
    }
}