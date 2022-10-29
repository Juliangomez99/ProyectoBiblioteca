package Conexion;


import java.sql.Date;

public class Usuario {
    private int Cedula;
    private String Nombre;
    private String Apellidos;
    private Date FechaN;
    private String Direccion;
    private String Telefono;
    private String Correo;
    private String Contra;
    private int Rol;

    public Usuario() {
    }

    public Usuario(int Cedula, String Nombre, String Apellidos, Date FechaN, String Direccion, String Telefono, String Correo, String Contra, int Rol) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.FechaN = FechaN;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Contra = Contra;
        this.Rol = Rol;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getFechaN() {
        return FechaN;
    }

    public void setFechaN(Date FechaN) {
        this.FechaN = FechaN;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
        public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }
    
    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }
}
