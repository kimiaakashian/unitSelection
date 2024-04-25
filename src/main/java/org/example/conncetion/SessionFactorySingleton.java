package org.example.conncetion;


import org.example.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {}

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Users.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Professor.class)
                    .addAnnotatedClass(Term.class)
                    .addAnnotatedClass(Lesson.class)
                    .addAnnotatedClass(StudentTerm.class)
                    .addAnnotatedClass(StudentTermUnit.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}