package org.acme.service;


import org.acme.dto.CostumerDTO;
import org.acme.entity.CostumerEntity;
import org.acme.repository.CostumerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CostumerService { //usada para manipular dados no banco de dados

    @Inject //injetar as possibilidades ou caracteristica do que o objeto faz em outro objeto
    private CostumerRepository costumerRepository; //ja tenho acesso aos metodos dessa classe

    //metodo patra buscar todos os clientes salvos no banco de dados

    public List<CostumerDTO> findAllCostumers(){ //metodo que encontra todos os clientes
        List<CostumerDTO> costumers = new ArrayList<>();

        costumerRepository.findAll().stream().forEach(item->{
            costumers.add(mapCostumerEntityToDTO(item));
        });

        return costumers;
    }

    public CostumerDTO findAllCostumersById(Long id) {
        return mapCostumerEntityToDTO(costumerRepository.findById(id));
    }

    public void createNewCostumer(CostumerDTO costumerDTO){
        costumerRepository.persist(mapCostumerDTOtoEntity(costumerDTO));
    }

    public void changeCostumer(Long id, CostumerDTO costumerDTO){

        CostumerEntity costumer = costumerRepository.findById(id);

        costumer.setName(costumerDTO.getName());
        costumer.setAdress(costumerDTO.getAdress());
        costumer.setPhone(costumerDTO.getPhone());
        costumer.setAge(costumerDTO.getAge());

        costumerRepository.persist(costumer);
    }

    public void deleteCostumer(Long id){

        costumerRepository.deleteById(id);

    }

    private CostumerDTO mapCostumerEntityToDTO(CostumerEntity costumer) { //faz a conversão de uma classe para outra
        CostumerDTO costumerDTO = new CostumerDTO();

        costumerDTO.setAdress(costumer.getAdress());
        costumerDTO.setAge(costumer.getAge());
        costumerDTO.setName(costumer.getName());
        costumerDTO.setPhone(costumer.getPhone());

        return costumerDTO;
    }

    private CostumerEntity mapCostumerDTOtoEntity(CostumerDTO costumer) { //faz a conversão de uma classe para outra
        CostumerEntity costumerEntity = new CostumerEntity();

        costumerEntity.setAdress(costumer.getAdress());
        costumerEntity.setAge(costumer.getAge());
        costumerEntity.setName(costumer.getName());
        costumerEntity.setPhone(costumer.getPhone());

        return costumerEntity;
    }


}
