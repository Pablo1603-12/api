package crud;

import jakarta.persistence.EntityManager;

public interface Interfaz_Usu {

   
    public void crearUsuario(EntityManager em);

    public void leerUsuario(EntityManager em);

    public void actualizarUsuario(EntityManager em);

    public void eliminarUsuario(EntityManager em);
}
