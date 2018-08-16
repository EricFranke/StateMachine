package dao;

import entity.ProcessImpl;
import jpa.JpaProcess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StateMachineDao {

    private static SessionFactory sessionFactory =
          new Configuration().configure().buildSessionFactory();

    public static void persist(ProcessImpl process) {

        JpaProcess jpaProcess = new JpaProcess();
        jpaProcess.setName(process.getName());
        jpaProcess.setCounter(process.getCounter());

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(jpaProcess);
        session.getTransaction().commit();
        session.close();
    }
}