/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.sessions;

import co.edu.events.jpa.entities.TypeDocument;
import co.edu.events.jpa.entities.User;
import co.edu.events.jpa.entities.User_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
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
        public User findByEmail(String email) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> usuario = cq.from(User.class);
        cq.where(cb.equal(usuario.get(User_.email), email));
        TypedQuery<User> q = getEntityManager().createQuery(cq);
        try {
            return (User) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    /**
     * Busca usuario por numDocumento
     *
     * @param numDocument
     * @return Usuario
     */
    public User findByNumDocument(String numDocument) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> usuario = cq.from(User.class);
        cq.where(cb.equal(usuario.get(User_.numDocument), numDocument));
        TypedQuery<User> q = getEntityManager().createQuery(cq);
        try {
            return (User) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
   
        public List<User> findUsers(Integer idUser, 
            String numDocument, String email,
            Integer idTypeDocument){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        
        Predicate data = cb.conjunction();
        
        if(idUser != null){
            data = cb.and(data, cb.equal(user.get(User_.idUser), idUser));
        }
           

        if(numDocument != null){
            data = cb.and(data, cb.equal(user.get(User_.numDocument), numDocument));
        }
        
        if(email != null){
            data = cb.and(data, cb.equal(user.get(User_.email), email));
        }
        
    
        if(idTypeDocument != null){
            data = cb.and(data, cb.equal(user.get(User_.idTypeDocument), new TypeDocument(idTypeDocument)));
        }
        
        cq.where(data);
        cq.orderBy(cb.asc(user.get(User_.lastname)));
        TypedQuery<User> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    
    
}
