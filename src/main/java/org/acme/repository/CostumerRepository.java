package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.CostumerEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped //coloca essas classes no contexto do quarkus
public class CostumerRepository implements PanacheRepository<CostumerEntity> { // representação do banco de dados

    // faz um implements no Panache que possui varios metodos que pode ser utilizado

}
