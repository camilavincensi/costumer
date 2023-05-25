package org.acme.controller;

import jdk.javadoc.doclet.Reporter;
import org.acme.dto.CostumerDTO;
import org.acme.service.CostumerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/costumers")// qual o endereço pelo qual a api vai respponder as requisiçoes
public class CostumerController {

    @Inject //injeção de dependencia da classe
    CostumerService costumerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON) //tipo de infomação que queremos retornar para o front
    public List<CostumerDTO> findAllCostumers(){
        return costumerService.findAllCostumers();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CostumerDTO findCostumerById(@PathParam("id") Long id){

        return costumerService.findAllCostumersById(id);

    }

    @POST
    @Transactional  //anotação que faz o gerenciamento de dados que vão ser salvos no banco de dados
    public Response saveCostumer(CostumerDTO costumerDTO){ //Response  tipo de resposta quando a gente ta criando uma api e quer devolver no formato do rest
        try{
            costumerService.createNewCostumer(costumerDTO);
            return Response.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}") // chamada da URL vai ter que enviar um id
    @Transactional
    public Response changeCostumer(@PathParam("id") Long id, CostumerDTO costumerDTO){ //pathparam precisa ser igual ao que esta no path

        try{
            costumerService.changeCostumer(id, costumerDTO);
            return  Response.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional //só é utilizado em metodos que faz alteração em banco de dados
    public Response deleteCostumer(@PathParam("id") Long id){

        try{
            costumerService.deleteCostumer(id);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
