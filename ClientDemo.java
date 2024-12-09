package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert Device
        Device device = new Device();
        device.setBrand("Samsung");
        device.setModel("Generic Device");
        device.setPrice(20000);

        // Insert Smartphone
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(120000);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution(48);

        // Insert Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Lenovo");
        tablet.setModel("Yoga Tab");
        tablet.setPrice(40000);
        tablet.setScreenSize(10.5);
        tablet.setBatteryLife(15);

        // Persist data
        session.persist(device);
        session.persist(smartphone);
        session.persist(tablet);

        // Commit transaction
        transaction.commit();

        System.out.println("Records inserted successfully!");

        // Close session
        session.close();
        sessionFactory.close();
    }
}
