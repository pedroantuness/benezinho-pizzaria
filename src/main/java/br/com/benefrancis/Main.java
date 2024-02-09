package br.com.benefrancis;

import br.com.benefrancis.domain.entity.Pizzaria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "maria-db" );

        EntityManager manager = factory.createEntityManager();


        Pizzaria p1 = new Pizzaria(null, "Benezinho Pizzaria");



        manager.getTransaction().begin();
        manager.persist( p1 );
        manager.getTransaction().commit();


        manager.close();
        factory.close();


    }
}