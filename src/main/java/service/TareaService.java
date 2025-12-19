package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Tarea;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TareaService implements ITareaService {
    private List<Tarea> tareas;
    private final String RUTA_ARCHIVO = "data/tareas.json";
    private Gson gson;

    public TareaService(){
        this.gson = new Gson();
        this.tareas = cargarDatos();
    }

    @Override
    public void crearTarea(String titulo, int prioridad){
        int nuevoId = tareas.size() + 1;
        Tarea nueva = new Tarea(nuevoId, titulo, prioridad);
        tareas.add(nueva);
        System.out.println("Tarea creada: "+ titulo);
        guardarDatos();
    }

    @Override
    public List<Tarea> listarTareas(){
        return tareas;
    }

    @Override
    public void completarTarea (int id){
        for(Tarea t: tareas){
            if(t.getId() == id){
                t.setEstado("Completada");
                guardarDatos();
                return;
            }
        }
    }

    @Override
    public void guardarDatos(){
        try (Writer writer = new FileWriter(RUTA_ARCHIVO)){
            gson.toJson(tareas, writer);   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Tarea> cargarDatos() {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) return new ArrayList<>();

        try (Reader reader = new FileReader(RUTA_ARCHIVO)){
            Type listType = new TypeToken<ArrayList<Tarea>>(){}.getType();
            List<Tarea> datos = gson.fromJson(reader, listType);
            return datos != null ? datos : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void eliminarTarea(int id){
        tareas.removeIf(t -> t.getId() == id);
        guardarDatos();
    }
}