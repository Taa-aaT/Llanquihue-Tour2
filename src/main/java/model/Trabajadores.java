package model;

public class Trabajadores {

    private String nombre;
    private String rol;
    private String rut;

    public Trabajadores(){
    }

    public Trabajadores(String nombre, String rol, String rut){
        setNombre(nombre);
        setRol(rol);
        setRut(rut);
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank() || nombre.isEmpty()){
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacio.");}
        this.nombre = nombre;
    }

    public String getRol() {return rol;}

    public void setRol(String rol) {
        if (rol == null || rol.isBlank() || rol.isEmpty()){
            throw new IllegalArgumentException(
                    "El rol no puede estar vacio.");}
        this.rol = rol;
    }

    public String getRut() {return rut;}

    public void setRut(String rut) {
        if(!rut.matches("[0-9]+-[0-9kK]")){
            throw new IllegalArgumentException("Rut Invalido.");
        }
        this.rut = rut.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return "Trabajadores: {" +
                "Nombre ='" + nombre + '\'' +
                ", Rol ='" + rol + '\'' +
                ", RUT ='" + rut + '\'' +
                '}';
    }
}