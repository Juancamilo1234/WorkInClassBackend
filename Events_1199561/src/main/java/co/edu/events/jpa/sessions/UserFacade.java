/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.sessions;

import co.edu.events.jpa.entities.User;
import co.edu.events.jpa.entities.User_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "co.edu.events_Events_1199561_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
     public User findByEmail(String email){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> tercero = cq.from(User.class);
        
        cq.where(cb.equal(tercero.get(User_.email), email));
        TypedQuery<User> tq = getEntityManager().createQuery(cq);
        
        try {
            return (User) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e){
            return null;
        }
    }

    public User findByNumDocument(String numDocument) {
           CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> tercero = cq.from(User.class);
        
        cq.where(cb.equal(tercero.get(User_.numDocument), numDocument));
        TypedQuery<User> tq = getEntityManager().createQuery(cq);
        
        try {
            return (User) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e){
            return null;
        }
    
    }
}
