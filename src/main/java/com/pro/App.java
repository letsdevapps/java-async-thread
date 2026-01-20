package com.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.pro.async.SimpleAsyncThread;

public class App {
	public static void main( String[] args ) {
        System.out.println("----- Java Async Thread | Main -----");
        
        // Cria um pool de 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Envia 5 tarefas para execução
        for (int i = 1; i <= 5; i++) {
            executor.submit(new SimpleAsyncThread(i));
        }

        // Fecha o ExecutorService após todas as tarefas serem executadas
        executor.shutdown();
    }
}