
package trabajo_biblioteca;
public class Libro {
//===============================Propiedades====================================
   private String Codigo;
   private String Titulo;
   private String Autor;
   private String Editorial;
   private int A_edicion;
   private String F_devolucion;
   private int Estado;
   private int NRegistro;
//==============================Constructor=====================================

    public Libro() {
    }

    public Libro(String Codigo, String Titulo, String Autor, String Editorial, int A_edicion, String F_devolucion, int Estado, int NRegistro) {
        this.Codigo = Codigo;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.A_edicion = A_edicion;
        this.F_devolucion = F_devolucion;
        this.Estado = Estado;
        this.NRegistro = NRegistro;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getA_edicion() {
        return A_edicion;
    }

    public void setA_edicion(int A_edicion) {
        this.A_edicion = A_edicion;
    }

    public String getF_devolucion() {
        return F_devolucion;
    }

    public void setF_devolucion(String F_devolucion) {
        this.F_devolucion = F_devolucion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getNRegistro() {
        return NRegistro;
    }

    public void setNRegistro(int NRegistro) {
        this.NRegistro = NRegistro;
    }

  
}
