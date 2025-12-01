/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Comunidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmaic
 */
@Stateless
public class ComunidadFacade extends AbstractFacade<Comunidad> {

    @PersistenceContext(unitName = "PeiroPerezPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunidadFacade() {
        super(Comunidad.class);
    }
    
}
