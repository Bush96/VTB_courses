package org.example;

import jakarta.persistence.LockModeType;
import org.example.model.Thing;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 40; i++) {
            WorkerThread worker = new WorkerThread();
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}

