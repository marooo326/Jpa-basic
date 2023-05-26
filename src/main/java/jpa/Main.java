package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            MEMBER member = new MEMBER();
            member.setId(1L);
            member.setName("ddd");
            em.persist(member);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}