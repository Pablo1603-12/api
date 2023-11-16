package controlador;

import crud.Implementacion_Usu;
import crud.Interfaz_Usu;
import daos.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Inicio {
//SOLAMENTE HAY PRUEBAS DEL CRUD

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Interfaz_Usu usuario = new Implementacion_Usu();
        em.getTransaction().begin();

        usuario.crearUsuario(em);
        
        em.close();
        emf.close();
         
        
    }

}
