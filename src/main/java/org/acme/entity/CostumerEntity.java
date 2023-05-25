package org.acme.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//classe excluisva para representação no banco de dados
@Entity()
@Table(name="costumer")
@Data //não precisa criar os getters e setters
@AllArgsConstructor
@NoArgsConstructor

public class CostumerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private  String name;
    private String phone;
    private String adress;
    private Long age;

}
