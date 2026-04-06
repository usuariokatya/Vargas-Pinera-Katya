
/*
  @author katya
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HappinnessCo {

    // Constantes del menú
    static final int PRIMERA_OPCION_MENU = 1;
    static final int ULTIMA_OPCION_MENU = 9;

    // Colecciones
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static HashMap<Integer, Evento> eventos = new HashMap<>();
    static ArrayList<Favorito> favoritos = new ArrayList<>();

    // Contadores para IDs autogenerados
    static int contadorEventos = 0;
    static int contadorGalerias = 0;

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("========================================");
            System.out.println(
                    "HAPPINESS&CO - MENU\n 1. Añadir usuario\n 2. Eliminar usuario\n 3. Añadir evento\n 4. Eliminar evento\n 5. Añadir galería\n 6. Eliminar galería\n 7. Añadir favorito\n 8. Eliminar favorito\n 9. Salir");
            System.out.println("========================================");

            // SOLICITO AL USUARIO QUE INGRESE UNA OPCIÓN DEL MENÚ
            System.out.println("Introduce una opción del Menú (1-9): ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer

            // COMPRUEBO LA VALIDEZ DE LA OPCIÓN INTRODUCIDA
            opcion = comprobarMenu(opcion, teclado);

            // DESPLIEGO OPCIONES
            switch (opcion) {
                case 1:
                    annadirUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    annadirEvento();
                    break;
                case 4:
                    eliminarEvento();
                    break;
                case 5:
                    annadirGaleria();
                    break;
                case 6:
                    eliminarGaleria();
                    break;
                case 7:
                    annadirFavorito();
                    break;
                case 8:
                    eliminarFavorito();
                    break;
                case 9:
                    System.out.println("Su sesión ha finalizado. Gracias.");
            }
        } while (opcion != 9);

        teclado.close();
    }

    public static int comprobarMenu(int opcion, Scanner teclado) {
        while (opcion < PRIMERA_OPCION_MENU || opcion > ULTIMA_OPCION_MENU) {
            System.out.println(
                    "Opción NO válida\n========================================\nHAPPINESS&CO - MENU\n 1. Añadir usuario\n 2. Eliminar usuario\n 3. Añadir evento\n 4. Eliminar evento\n 5. Añadir galería\n 6. Eliminar galería\n 7. Añadir favorito\n 8. Eliminar favorito\n 9. Salir\n========================================\nIntroduce una opción válida (1-9): ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer
        }
        return opcion;
    }

    public static void annadirUsuario() {
        String nombreUsuario;
        String emailUsuario;
        String passwordUsuario;

        System.out.println("\n--- Añadir Usuario ---");
        System.out.print("Introduce el nombre: ");
        nombreUsuario = teclado.nextLine();
        System.out.print("Introduce el email: ");
        emailUsuario = teclado.nextLine();
        System.out.print("Introduce la contraseña: ");
        passwordUsuario = teclado.nextLine();

        if (usuarios.containsKey(emailUsuario)) {
            System.out.println("El usuario ya existe");
        } else {
            Usuario nuevoUsuario = new Usuario(nombreUsuario, emailUsuario, passwordUsuario);
            usuarios.put(emailUsuario, nuevoUsuario);
            System.out.println("Usuario creado correctamente");
        }
    }

    public static void eliminarUsuario() {
        String correoEliminar;

        System.out.println("\n--- Eliminar Usuario ---");
        System.out.print("Introduce el correo del usuario a eliminar: ");
        correoEliminar = teclado.nextLine();

        if (usuarios.containsKey(correoEliminar)) {
            usuarios.remove(correoEliminar);
            System.out.println("Usuario eliminado correctamente");
        } else {
            System.out.println("El usuario no existe");
        }
    }

    public static void annadirEvento() {
        String fechaEvento;
        String tituloEvento;
        String ubicacionEvento;
        String descripcionEvento;

        System.out.println("\n--- Añadir Evento ---");
        System.out.print("Introduce la fecha: ");
        fechaEvento = teclado.nextLine();
        System.out.print("Introduce el título: ");
        tituloEvento = teclado.nextLine();
        System.out.print("Introduce la ubicación: ");
        ubicacionEvento = teclado.nextLine();
        System.out.print("Introduce la descripción: ");
        descripcionEvento = teclado.nextLine();

        Evento nuevoEvento = new Evento(contadorEventos, fechaEvento, tituloEvento, ubicacionEvento, descripcionEvento);
        eventos.put(contadorEventos, nuevoEvento);
        contadorEventos++;
        System.out.println("Evento creado correctamente");
    }

    public static void eliminarEvento() {
        int idEventoEliminar;
        ArrayList<Integer> clavesEventos;

        System.out.println("\n--- Eliminar Evento ---");
        System.out.println("Listado de eventos:");
        clavesEventos = new ArrayList<>(eventos.keySet());
        for (int i = 0; i < clavesEventos.size(); i++) {
            System.out.println(eventos.get(clavesEventos.get(i)));
        }

        System.out.print("Introduce el id del evento a eliminar: ");
        idEventoEliminar = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        if (eventos.containsKey(idEventoEliminar)) {
            eventos.remove(idEventoEliminar);
            System.out.println("Evento eliminado correctamente");
        } else {
            System.out.println("El evento no existe");
        }
    }

    public static void annadirGaleria() {
        int idEventoGaleria;
        String tituloGaleria;
        ArrayList<Integer> clavesEventos;

        System.out.println("\n--- Añadir Galería ---");
        System.out.println("Listado de eventos:");
        clavesEventos = new ArrayList<>(eventos.keySet());
        for (int i = 0; i < clavesEventos.size(); i++) {
            System.out.println(eventos.get(clavesEventos.get(i)));
        }

        System.out.print("Introduce el id del evento: ");
        idEventoGaleria = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        if (!eventos.containsKey(idEventoGaleria)) {
            System.out.println("Error: El evento no existe");
        } else {
            System.out.print("Introduce el título de la galería: ");
            tituloGaleria = teclado.nextLine();

            Galeria nuevaGaleria = new Galeria(contadorGalerias, tituloGaleria, idEventoGaleria);
            eventos.get(idEventoGaleria).getGalerias().put(contadorGalerias, nuevaGaleria);
            contadorGalerias++;
            System.out.println("Galería creada correctamente");
        }
    }

    public static void eliminarGaleria() {
        int idEventoElimGaleria;
        int idGaleriaEliminar;
        Evento eventoSeleccionado;
        ArrayList<Integer> clavesEventos;
        ArrayList<Integer> clavesGalerias;

        System.out.println("\n--- Eliminar Galería ---");
        System.out.println("Listado de eventos:");
        clavesEventos = new ArrayList<>(eventos.keySet());
        for (int i = 0; i < clavesEventos.size(); i++) {
            System.out.println(eventos.get(clavesEventos.get(i)));
        }

        System.out.print("Introduce el id del evento: ");
        idEventoElimGaleria = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        if (!eventos.containsKey(idEventoElimGaleria)) {
            System.out.println("Error: El evento no existe");
        } else {
            eventoSeleccionado = eventos.get(idEventoElimGaleria);
            System.out.println("Listado de galerías del evento:");
            clavesGalerias = new ArrayList<>(eventoSeleccionado.getGalerias().keySet());
            for (int i = 0; i < clavesGalerias.size(); i++) {
                System.out.println(eventoSeleccionado.getGalerias().get(clavesGalerias.get(i)));
            }

            System.out.print("Introduce el id de la galería a eliminar: ");
            idGaleriaEliminar = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer

            if (eventoSeleccionado.getGalerias().containsKey(idGaleriaEliminar)) {
                eventoSeleccionado.getGalerias().remove(idGaleriaEliminar);
                System.out.println("Galería eliminada correctamente");
            } else {
                System.out.println("La galería no existe");
            }
        }
    }

    public static void annadirFavorito() {
        int idEventoFav;
        String correoFav;
        ArrayList<Integer> clavesEventos;
        ArrayList<String> clavesUsuarios;

        System.out.println("\n--- Añadir Favorito ---");
        System.out.println("Listado de eventos:");
        clavesEventos = new ArrayList<>(eventos.keySet());
        for (int i = 0; i < clavesEventos.size(); i++) {
            System.out.println(eventos.get(clavesEventos.get(i)));
        }
        System.out.println("\nListado de usuarios:");
        clavesUsuarios = new ArrayList<>(usuarios.keySet());
        for (int i = 0; i < clavesUsuarios.size(); i++) {
            System.out.println(usuarios.get(clavesUsuarios.get(i)));
        }

        System.out.print("Introduce el id del evento: ");
        idEventoFav = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        if (!eventos.containsKey(idEventoFav)) {
            System.out.println("Error: El evento no existe");
        } else {
            System.out.print("Introduce el correo del usuario: ");
            correoFav = teclado.nextLine();

            if (!usuarios.containsKey(correoFav)) {
                System.out.println("Error: El usuario no existe");
            } else {
                Favorito nuevoFavorito = new Favorito(correoFav, idEventoFav);
                favoritos.add(nuevoFavorito);
                System.out.println("Favorito creado correctamente");
            }
        }
    }

    public static void eliminarFavorito() {
        int idEventoElimFav;
        String correoElimFav;
        boolean encontrado;

        System.out.println("\n--- Eliminar Favorito ---");
        System.out.println("Listado de favoritos:");
        for (int i = 0; i < favoritos.size(); i++) {
            System.out.println(favoritos.get(i));
        }

        System.out.print("Introduce el id del evento del favorito: ");
        idEventoElimFav = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer
        System.out.print("Introduce el correo del usuario del favorito: ");
        correoElimFav = teclado.nextLine();

        encontrado = false;
        for (int i = 0; i < favoritos.size(); i++) {
            if (favoritos.get(i).getIdEvento() == idEventoElimFav &&
                    favoritos.get(i).getCorreoUsuario().equals(correoElimFav)) {
                favoritos.remove(i);
                encontrado = true;
                System.out.println("Favorito eliminado correctamente");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El favorito no existe");
        }
    }
}
