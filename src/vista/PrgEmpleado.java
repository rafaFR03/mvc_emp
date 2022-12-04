package vista;

import controlador.ArregloEmpleado;
import javax.swing.JOptionPane;


public class PrgEmpleado {

    ArregloEmpleado objArray;

    public PrgEmpleado() {
        objArray = new ArregloEmpleado();
    }

    public static void main(String[] args) {
        PrgEmpleado app = new PrgEmpleado();
        app.menu();
    }

    public void menu() {
        int op = 0;
        String menu = "--MENU--\n";
        menu += """
                [1] Ingresar datos
                [2] Mostrar datos
                [3] Mostrar datos del empleado
                [4] Ordenar
                [5] Modificar
                [6] Eliminar
                [7] Sueldos mayores que el promedio
                [8] Sueldos menores que el promedio
                [0] Salir
                """;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    mostrarDatosEmpleado();
                    break;
                case 4: 
                    ordenarDatos();
                    mostrarDatosEmpleado();
                    break;
                case 5:
                    modificarDatos();
                    break;
                case 6:
                    eliminarDatos();
                    break;
                case 7:
                    maxPromedioSueldo();
                    break;
                case 8:
                    minPromedioSueldo();
                case 0:
                    break;
                default:
                    throw new AssertionError();
            }
        } while (op != 0);
    }

    public void ingresarDatos() {
        int op = 0;
        do {

            long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingresar el codigo: "));
            String nombre = JOptionPane.showInputDialog("Ingresar el nombre: ");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el sueldo: "));
            objArray.agregarDatos(codigo, nombre, sueldo);

            op = JOptionPane.showConfirmDialog(null, "Desea continuar? ", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (op == JOptionPane.YES_OPTION);

    }

    public void mostrarDatos() {
        String mostrar = objArray.obtenerDatos();
        if (mostrar != "") {
            //JOptionPane.showMessageDialog(null, mostrar);
            JOptionPane.showMessageDialog(null, mostrar, "Datos", 0);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que mostrar");
        }
    }

    public void mostrarDatosEmpleado() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del empleado que desee buscar"));
        String mostrar = objArray.obtenerDatosEmpleado(codigo);
        if (mostrar != "") {
            JOptionPane.showMessageDialog(null, mostrar);
        } else {
            JOptionPane.showMessageDialog(null, "El codigo no se encuentra registrado");
        }
    }

    public void modificarDatos() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingresar el codigo del empleado cuyos datos deseas modificar"));
        int op = 0;
        op = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar los datos de " + objArray.obtenerDatosEmpleado(codigo), "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            String nombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre");
            double sueldo = Double.parseDouble("Ingresa el nuevo sueldo: ");
            objArray.modificarDatos(codigo, nombre, sueldo);
        }

    }

    public void eliminarDatos() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingresar el codigo del empleado cuyos datos deseas eliminar"));
        int op = 0;
        op = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar los datos de " + objArray.obtenerDatosEmpleado(codigo), "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            objArray.eliminarDatos(codigo);
        }
    }
    
    public void maxPromedioSueldo(){
        String mensaje = objArray.maxPromedioEmpleado();
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void minPromedioSueldo(){
        String mensaje = objArray.minPromedioEmpleado();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void ordenarDatos() {
        objArray.ordenarDatos();
    }
    
    
}
