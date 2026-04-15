/*
  @author katya
 */
public class Favorito {
    private String correoUsuario;
    private int idEvento;

    public Favorito(String correoUsuario, int idEvento) {
        this.correoUsuario = correoUsuario;
        this.idEvento = idEvento;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    @Override
    public String toString() {
        return "Favorito -> Usuario: " + correoUsuario + " | Evento ID: " + idEvento;
    }
}