/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Sectoresdbncadingles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manue
 */
@Stateless
public class SectoresdbncadinglesFacade extends AbstractFacade<Sectoresdbncadingles> {

    @PersistenceContext(unitName = "PeiroPerezPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SectoresdbncadinglesFacade() {
        super(Sectoresdbncadingles.class);
    }
    
}
