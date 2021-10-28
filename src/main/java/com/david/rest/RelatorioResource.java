/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.rest;

import com.david.model.Config;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author David
 */
@Path("/relatorio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelatorioResource {

    /**
     * Injeta (instancia automaticamente) um objeto com as configurações da
     * aplicação. Como a classe {@link Config} foi anotada com
     * &#64;{@link ApplicationScoped}, só existirá um único objeto (Singleton)
     * config em toda a aplicação, independentemente de quantos usuários estejam
     * conectados.
     *
     * O atributo é definido com visibilidade package por uma solicitação do
     * Quarkus.
     */
    @Inject
    Config config;

    @GET
    public Config getConfig() {
        return config;
    }

    @PUT
    public void updateConfig(Config newConfig) {
        this.config = newConfig;
        /**
         * Como o objeto config tem seu ciclo de vida controlado pelo CDI e este
         * parâmetro newConfig não tem, não podemos simplismenter atribuir o
         * último ao primeiro. Precisamos copiar os valores dos atributos de um
         * para o outro.
         */
        config.setFormatoRelatorios(newConfig.getFormatoRelatorios());
        config.setTipoGraficos(newConfig.getTipoGraficos());
    }
}
