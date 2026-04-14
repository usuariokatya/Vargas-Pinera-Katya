
/*
  @author katya
 */
import java.util.HashMap;

public class Evento {
    private int id;
    private String fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private HashMap<Integer, Galeria> galerias;

    public Evento(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.galerias = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HashMap<Integer, Galeria> getGalerias() {
        return galerias;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " (" + fecha + ") en " + ubicacion + " - " + descripcion;
    }
}