package model;

public class Tour {

private String nombre;
private String ciudad;
private String tipo;
private int precio;

public Tour(){

    this.nombre = "Sin nombre de tour";
    this.ciudad = "Sin ciudad";
    this.tipo = "Sin tipo";
    this.precio = 0;
}

public Tour(String nombre, String ciudad, String tipo, int precio){

    this.nombre = nombre;
    this.ciudad = ciudad;
    this.tipo = tipo;
    this.precio = precio;
}

    public String getNombre() {
        return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;}

    public String getCiudad() {
        return ciudad;}
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;}

    public String getTipo() {
        return tipo;}
    public void setTipo(String tipo) {
        this.tipo = tipo;}

    public int getPrecio() {
        return precio;}
    public void setPrecio(int precio) {
        this.precio = precio;}

    @Override
    public String toString() {
        return "Tour {" +
                "Nombre del Tour = '" + nombre + '\'' +
                "|| Ciudad = '" + ciudad + '\'' +
                "|| Tipo de Tour = '" + tipo + '\'' +
                "|| Precio = $" + precio +
                '}';
    }
}
