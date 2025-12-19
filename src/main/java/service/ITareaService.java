package service;

import model.Tarea;
import java.util.List;

public interface ITareaService {

    void crearTarea(String titulo, int prioridad);
    List<Tarea> listarTareas();
    void completarTarea(int id);
    void eliminarTarea(int id);
    void guardarDatos();
}
