package br.com.benefrancis;

import br.com.benefrancis.domain.entity.Pizzaria;
import br.com.benefrancis.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "maria-db" );
        EntityManager manager = factory.createEntityManager();

        var manjericao = new Sabor( null, "Manjericao", "Deliciosa pizza de manjericão que fora plantado pelos mais renomados agricultores do Brasil" );


        Pizzaria p1 = new Pizzaria( null, "Dominus" );


        manager.getTransaction().begin();
        manager.persist( manjericao );
        manager.persist( p1 );
        manager.getTransaction().commit();

        System.out.println("PIZZARIA: " + p1);

        System.out.println("SABOR: " + manjericao);

        manager.close();
        factory.close();
    }
}