
/*
  @author katya
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HappinnessCo {
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static HashMap<Integer, Evento> eventos = new HashMap<>();
    static ArrayList<Favorito> favoritos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);
    static int contadorEventos = 0;
    static int contadorGalerias = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n========== HAPPINESS & CO ==========");
            System.out.println("1. Añadir usuario      2. Eliminar usuario");
            System.out.println("3. Añadir evento       4. Eliminar evento");
            System.out.println("5. Añadir galería      6. Eliminar galería");
            System.out.println("7. Añadir favorito     8. Eliminar favorito");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    añadirUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    añadirEvento();
                    break;
                case 4:
                    eliminarEvento();
                    break;
                case 5:
                    añadirGaleria();
                    break;
                case 6:
                    eliminarGaleria();
                    break;
                case 7:
                    añadirFavorito();
                    break;
                case 8:
                    eliminarFavorito();
                    break;
            }
        } while (opcion != 9);
    }

    public static void añadirUsuario() {
        System.out.println("\n--- Añadir Usuario ---");
        System.out.print("Introduce el email: ");
        String email = teclado.nextLine();

        if (usuarios.containsKey(email)) {
            System.out.println("Error: El usuario ya existe");
        } else {
            System.out.print("Introduce el nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Introduce el password: ");
            String password = teclado.nextLine();
            Usuario nuevoUsuario = new Usuario(usuarios.size() + 1, nombre, email, password);
            usuarios.put(email, nuevoUsuario);
            System.out.println("Usuario añadido correctamente");
        }
    }

    public static void eliminarUsuario() {
        System.out.print("Email del usuario a borrar: ");
        String email = teclado.nextLine();
        if (usuarios.remove(email) != null) {
            favoritos.removeIf(f -> f.getCorreoUsuario().equals(email));
            System.out.println("Usuario eliminado");
        } else {
            System.out.println("No existe el usuario");
        }
    }

    public static void añadirEvento() {
        contadorEventos++;
        System.out.print("Título: ");
        String t = teclado.nextLine();
        System.out.print("Fecha: ");
        String f = teclado.nextLine();
        System.out.print("Ubicación: ");
        String u = teclado.nextLine();
        System.out.print("Descripción: ");
        String d = teclado.nextLine();
        eventos.put(contadorEventos, new Evento(contadorEventos, f, t, u, d));
        System.out.println("Evento creado con ID: " + contadorEventos);
    }

    public static void eliminarEvento() {
        System.out.println("\n--- Eliminar Evento ---");
        System.out.print("Introduce el id del evento a eliminar: ");
        int idEliminar = teclado.nextInt();
        teclado.nextLine();

        if (eventos.containsKey(idEliminar)) {
            eventos.remove(idEliminar);
            favoritos.removeIf(f -> f.getIdEvento() == idEliminar);
            System.out.println("Evento y datos asociados eliminados");
        } else {
            System.out.println("Error: El evento no existe");
        }
    }

    public static void añadirGaleria() {
        for (Evento e : eventos.values())
            System.out.println(e);
        System.out.print("ID Evento: ");
        int idEv = teclado.nextInt();
        teclado.nextLine();
        if (eventos.containsKey(idEv)) {
            contadorGalerias++;
            System.out.print("Título Galería: ");
            String tit = teclado.nextLine();
            Galeria g = new Galeria(contadorGalerias, tit, idEv);
            eventos.get(idEv).getGalerias().put(contadorGalerias, g);
            System.out.println("Galería añadida");
        }
    }

    public static void eliminarGaleria() {
        System.out.print("ID Evento: ");
        int idEv = teclado.nextInt();
        teclado.nextLine();
        if (eventos.containsKey(idEv)) {
            Evento ev = eventos.get(idEv);
            for (Galeria g : ev.getGalerias().values())
                System.out.println(g);
            System.out.print("ID Galería a borrar: ");
            int idG = teclado.nextInt();
            if (ev.getGalerias().remove(idG) != null)
                System.out.println("Eliminada");
        }
    }

    public static void añadirFavorito() {
        for (Evento e : eventos.values())
            System.out.println(e);
        for (Usuario u : usuarios.values())
            System.out.println(u);
        System.out.print("ID Evento: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Email: ");
        String mail = teclado.nextLine();
        if (eventos.containsKey(id) && usuarios.containsKey(mail)) {
            favoritos.add(new Favorito(mail, id));
            System.out.println("Favorito creado");
        }
    }

    public static void eliminarFavorito() {
        for (Favorito f : favoritos)
            System.out.println(f);
        System.out.print("ID Evento: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Email: ");
        String mail = teclado.nextLine();
        favoritos.removeIf(f -> f.getIdEvento() == id && f.getCorreoUsuario().equals(mail));
        System.out.println("Proceso de eliminación finalizado");
    }
}