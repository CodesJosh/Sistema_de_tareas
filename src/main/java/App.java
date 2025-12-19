import service.ITareaService;
import service.TareaService;
import model.Tarea;
import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        ITareaService servicio = new TareaService();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n --- GESTOR DE TAREAS ---");
            System.out.println("1. Nueva Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Completar Tarea");
            System.out.println("4. Eliminar Tarea");
            System.out.println("5. Salir");
            System.out.print("Elige: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Prioridad (1-5): ");
                    int prio = Integer.parseInt(scanner.nextLine()); 
                    servicio.crearTarea(titulo, prio);
                    break;
                case 2:
                    for(Tarea t : servicio.listarTareas()) {
                        System.out.println(t.getResumen());
                    }
                    break;
                case 3:
                    System.out.print("ID a completar: ");
                    int idComp = Integer.parseInt(scanner.nextLine());
                    servicio.completarTarea(idComp);
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    servicio.eliminarTarea(idDel);
                    break;
            }
        }
        System.out.println("Guardando y saliendo...");
        
        scanner.close(); 
    }
}