package crud;

import daos.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Implementacion_Usu implements Interfaz_Usu {

    @Override
    public void crearUsuario(EntityManager em) {

        Calendar fchFinBloqueo = Calendar.getInstance();
        fchFinBloqueo.set(2023, Calendar.DECEMBER, 31);

        Calendar fchAltaUsuario = Calendar.getInstance();
        fchAltaUsuario.set(2022, Calendar.NOVEMBER, 1);

        Calendar fchBajaUsuario = Calendar.getInstance();
        fchBajaUsuario.set(2023, Calendar.OCTOBER, 15);

        Usuario usuario = new Usuario(
                "12345678L",
                "Pablo",
                "Marquinez",
                "654987312",
                "pmj3@gmail.com",
                "1234",
                true,
                fchFinBloqueo,
                fchAltaUsuario,
                fchBajaUsuario);
        em.persist(usuario);
        em.getTransaction().commit();

    }

    @Override
    public void leerUsuario(EntityManager em) {

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuarios u", Usuario.class
        );
        List<Usuario> usuarios = query.getResultList();

        if (usuarios.isEmpty()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            System.out.println("Usuarios encontrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId_usuario());
                System.out.println("Nombre: " + usuario.getNombre_usuario());
                System.out.println("Apellido: " + usuario.getApellidos_usuario());
                System.out.println("DNI: " + usuario.getDni_usuario());
                System.out.println("Tlf: " + usuario.getTlf_usuario());
                System.out.println("Email: " + usuario.getEmail_usuario());

                System.out.println("-------------------------------------------------");
                System.out.println("");
            }
        }

        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();

        }

    }

    @Override
    public void actualizarUsuario(EntityManager em) {
        //em.getTransaction().begin();  // Comienzas la transacción al inicio del método

        try {
            System.out.println("USUARIOS DISPONIBLES:");
            leerUsuario(em);

            // Pedir al usuario que seleccione un ID de usuario para actualizar
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID del usuario que desea actualizar: ");
            int userId = scanner.nextInt();
            scanner.nextLine();

            Usuario usuario = em.find(Usuario.class, userId);

            if (usuario != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + usuario.getId_usuario());
                System.out.println("Nombre actual: " + usuario.getNombre_usuario());
                System.out.println("Apellido actual: " + usuario.getApellidos_usuario());
                System.out.println("DNI actual: " + usuario.getDni_usuario());
                System.out.println("Tlf actual: " + usuario.getTlf_usuario());
                System.out.println("Email actual: " + usuario.getEmail_usuario());

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();

                if (!nuevoNombre.isEmpty()) {
                    usuario.setNombre_usuario(nuevoNombre);
                }

                System.out.print("Nuevos apellidos: ");
                String nuevosApellidos = scanner.nextLine();

                if (!nuevosApellidos.isEmpty()) {
                    usuario.setApellidos_usuario(nuevosApellidos);
                }

                System.out.print("Nuevo DNI: ");
                String nuevoDni = scanner.nextLine();

                if (!nuevoDni.isEmpty()) {
                    usuario.setDni_usuario(nuevoDni);
                }

                System.out.print("Nuevo teléfono: ");
                String nuevoTlf = scanner.nextLine();

                if (!nuevoTlf.isEmpty()) {
                    usuario.setTlf_usuario(nuevoTlf);
                }

                System.out.print("Nuevo email: ");
                String nuevoEmail = scanner.nextLine();

                if (!nuevoEmail.isEmpty()) {
                    usuario.setEmail_usuario(nuevoEmail);
                }

                em.getTransaction().begin();
                em.getTransaction().commit();
                System.out.println("Usuario actualizado con éxito");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(EntityManager em) {
        leerUsuario(em);

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID del usuario que desea eliminar: ");
            int id = scanner.nextInt();

            Usuario usuario = em.find(Usuario.class,
                    id);
            if (usuario != null) {
                // Eliminar el usuario de la base de datos
                em.remove(usuario);
                // Comprobar si la transacción está activa antes de confirmarla

                em.getTransaction().commit();

                System.out.println("Usuario eliminado con éxito");
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

  

}
