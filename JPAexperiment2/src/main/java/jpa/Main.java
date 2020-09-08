package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "Person";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Person> todoList = q.getResultList();
        for (Person todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Person person = new Person("arne");
        ArrayList<Address> addr = new ArrayList();
        addr.add(new Address("blvd", 12));
        person.setAdresses(addr);
        em.persist(person);
        em.getTransaction().commit();

        em.close();
    }
}