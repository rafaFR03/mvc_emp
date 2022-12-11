
package modelo;


public class EmpleadoX extends Persona{
    private double tarifa;
    private double horas;

 /*   public EmpleadoX(double tarifa, double horas) {
        this.tarifa = tarifa;
        this.horas = horas;
    }
*/
    
    public EmpleadoX(double tarifa, double horas, long dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.tarifa = tarifa;
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    
}
