package controlador;

import modelo.Empleado;

public class ArregloEmpleado {

    Empleado datos[];
    int numEmp;

    public ArregloEmpleado() {
        datos = new Empleado[100];
        numEmp = 0;
    }

    public int agregarDatos(long codigo, String nombre, double sueldo) {

        if (datos.length == numEmp) {
            aumentar();
        }
        Empleado tmp = new Empleado(codigo, nombre, sueldo);
        datos[numEmp] = tmp;
        numEmp++;

        return 0;
    }

    public void aumentar() {
        Empleado tmp[] = new Empleado[datos.length + 10];
        for (int i = 0; i < numEmp; i++) {
            tmp[i] = datos[i];
        }
        datos = tmp;
    }

    public String obtenerDatos() {
        String lista = "";

        for (int i = 0; i < numEmp; i++) {
            lista += datos[i].getCodigo() + " - " + datos[i].getNombre() + " - " + datos[i].getSueldo() + "\n";
        }
        return lista;
    }

    public String obtenerDatosEmpleado(long codigo) {
        String lista = "-DATOS-\n";
        for (int i = 0; i < numEmp; i++) {
            lista += "Codigo: " + datos[i].getCodigo()
                    + "\nNombre: " + datos[i].getNombre()
                    + "\nSueldo: " + datos[i].getSueldo();

        }
        return lista;
    }

    public int buscarPos(long codigo) {
        for (int i = 0; i < numEmp; i++) {
            if (codigo == datos[i].getCodigo()) {
                return i;
            }
        }
        return -1;
    }

}
