package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized //pode ser uma representação de um objeto json
@AllArgsConstructor //criando os construtores com todos os atributos
@NoArgsConstructor // criando um construtor sem nenhum atributo

public class CostumerDTO { //classe usada para trafegar dados

    private Long id;
    private  String name;
    private String phone;
    private String adress;
    private Long age;
}
