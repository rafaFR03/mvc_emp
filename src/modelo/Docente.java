
package modelo;

public class Docente  extends EmpleadoX{
    private int categoria;

    public Docente(int categoria, double tarifa, double horas, long dni, String nombre, String apellido) {
        super(tarifa, horas, dni, nombre, apellido);
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
}
