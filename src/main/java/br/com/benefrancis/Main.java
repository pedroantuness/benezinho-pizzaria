package br.com.benefrancis;

import br.com.benefrancis.domain.entity.Opcional;
import br.com.benefrancis.domain.entity.Pizzaria;
import br.com.benefrancis.domain.entity.Produto;
import br.com.benefrancis.domain.entity.Sabor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        var db = LocalDate.now().getDayOfWeek().equals( DayOfWeek.FRIDAY ) ? "maria-db" : "fiap";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( db );
        EntityManager manager = factory.createEntityManager();

        var manjericao = new Sabor( null, "Manjericao", "Deliciosa pizza de manjericão que fora plantado pelos mais renomados agricultores do Brasil" );
        var frangoComCatupiri = new Sabor( null, "Frango com Catupiri", "O verdadeiro sabor do Catupiri Original faz toda a diferença nesta pizza" );


        var bordaDeCatupiri = Opcional.builder()
                .nome( "Borda de Catupiri" )
                .preco( 9.99 )
                .build();

        var bordaPaozinho = Opcional.builder()
                .nome( "Borda paozinho de calabresa e catupiri" )
                .preco( 19.99 )
                .build();

        var cocaCola = Opcional.builder()
                .nome( "Coca de 2 Litros" )
                .preco( 19.99 )
                .build();

        Set<Opcional> opcionaisDaPrimeiraPizza = new LinkedHashSet<>();
        opcionaisDaPrimeiraPizza.add( bordaDeCatupiri );
        opcionaisDaPrimeiraPizza.add( cocaCola );

        Set<Opcional> opcionaisDaSegundaPizza = new LinkedHashSet<>();
        opcionaisDaSegundaPizza.add( bordaPaozinho );
        opcionaisDaSegundaPizza.add( cocaCola );


        var pizzaDeManjericao = Produto.builder()
                .nome( "Pizza" )
                .sabor( manjericao )
                .preco( BigDecimal.valueOf( 59.99 ) )
                .opcionais( opcionaisDaPrimeiraPizza )
                .build();


        var pizzaDeFrangoComCatupiri = Produto.builder()
                .nome( "Pizza" )
                .sabor( frangoComCatupiri )
                .preco( BigDecimal.valueOf( 79.99 ) )
                .opcionais( opcionaisDaSegundaPizza )
                .build();


        var cardapio = new LinkedHashSet<Produto>();
        cardapio.add( pizzaDeFrangoComCatupiri );
        cardapio.add( pizzaDeManjericao );


        // Pizzaria pizzaria = new Pizzaria( null, "Dominus", cardapio );
        Pizzaria dominus = Pizzaria.builder().nome( "Dominus" ).cardapio( cardapio ).build();

        Pizzaria nona = Pizzaria.builder().nome( "Nona Pizzaria LTDA" ).cardapio( cardapio ).build();

        manager.getTransaction().begin();
        manager.persist( dominus );
        manager.persist( nona );
        manager.getTransaction().commit();

        System.out.println( "PIZZARIA: " + dominus );
        System.out.println( "PIZZARIA: " + nona );

        manager.close();
        factory.close();
    }
}