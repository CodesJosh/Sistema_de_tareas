package model;

public class Tarea extends Entidad {
    private String titulo;
    private String estado;
    private int prioridad;

    public Tarea(int id, String titulo, int prioridad) {
        super(id);
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
    }
    public String getTitulo() { return titulo; }
    public void setEstado(String estado) {this.estado = estado; }

    @Override
    public String getResumen(){
        return "ID " + id + " | " + titulo + " (Prioridad: " + prioridad + ") [" + estado + "]";
    }
    
    @Override
    public String toString(){
        return "Tarea{id=" + id + ", titulo='" + titulo + "', prioridad=" + prioridad + "}";
    }
}