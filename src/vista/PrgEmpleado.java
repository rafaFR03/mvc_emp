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
    
    public void menu(){
        int op = 0;
        String menu = "--MENU--\n";
        menu += """
                [1] Ingresar datos
                [2] Mostrar datos
                [3] Mostrar datos del empleado
                [4] Ordenar
                [5] Modificar
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
    
    public void mostrarDatos(){
        String mostrar = objArray.obtenerDatos();
        if (mostrar != "") {
            //JOptionPane.showMessageDialog(null, mostrar);
            JOptionPane.showMessageDialog(null, mostrar, "Datos", 0);
        }else{
            JOptionPane.showMessageDialog(null, "No hay datos que mostrar");
        }
    }
    
    public void mostrarDatosEmpleado(){      
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del empleado que desee buscar"));
        String mostrar = objArray.obtenerDatosEmpleado(codigo);        
        if (mostrar != "") {
            JOptionPane.showMessageDialog(null, mostrar);
        }else{
            JOptionPane.showMessageDialog(null, "El codigo no se encuentra registrado");
        }
    }
    
    public void modificarDatos(){
        
    }
    
    public void eliminarDatos(){
        
    }
    
    public void ordenarDatos(){
        
    }
}
