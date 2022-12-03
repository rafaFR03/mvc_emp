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
        int pos = buscarPos(codigo);
        lista += "Codigo: " + datos[pos].getCodigo()
                + "\nNombre: " + datos[pos].getNombre()
                + "\nSueldo: " + datos[pos].getSueldo();

        return lista;
    }

    public void modificarDatos(int pos, String nombre, double sueldo) {
        datos[pos].setNombre(nombre);
        datos[pos].setCodigo(pos);
    }

    public void eliminarDatos(long codigo) {
        int pos = buscarPos(codigo);
        for (int i = pos; i < numEmp - 1; i++) {
            datos[i] = datos[i + 1];
        }
    }

    public void ordenarDatos() {
        for (int i = 0; i < numEmp - 1; i++) {
            for (int j = i + 1; j < numEmp; j++) {
                if (datos[i].getCodigo() > datos[j].getCodigo()) {
                    Empleado tmp = datos[i];
                    datos[i] = datos[j];
                    datos[i] = tmp;
                }
            }
        }
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
