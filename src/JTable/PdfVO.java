package JTable;

import java.sql.Date;

        public class PdfVO {

    /*Todo los atributos*/
    int Codigo;
    int Cedula;
    String Documento;
    byte[] Archivo;
    Date Fecha;

    public PdfVO() {
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public byte[] getArchivo() {
        return Archivo;
    }

    public void setArchivo(byte[] Archivo) {
        this.Archivo = Archivo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

}
