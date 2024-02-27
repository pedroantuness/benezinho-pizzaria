package br.com.benefrancis.domain.entity;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@Table(name = "TB_OPCIONAL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Opcional {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @SequenceGenerator(
            name ="SQ_OPCIONAL",
            sequenceName = "SQ_OPCIONAL",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_OPCIONAL")
    private Long id;

    @Column(name = "NM_OPCIONAL")
    private String nome;

    private Double preco;

}
