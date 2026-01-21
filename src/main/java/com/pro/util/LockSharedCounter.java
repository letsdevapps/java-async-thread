package com.pro.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockSharedCounter {

	private int count = 0;
	private final ReentrantLock lock = new ReentrantLock(); // default false
	//private final ReentrantLock lock = new ReentrantLock(true); // fair lock / lock justo


	public void increment() {
		lock.lock(); // adquire o lock
		try {
			count++;
			System.out.println(Thread.currentThread().getName() + " - Incrementou o contador: " + count);
		} finally {
			lock.unlock(); // SEMPRE liberar
		}
	}
	
	// tryLock() – diferença chave
	// Agora algo que não existe com synchronized, tenta o lock, se conseguir otimo, se nao conseguir informa e nao tenta novamente
	// pool-1-thread-1 conseguiu o lock
	// pool-1-thread-3 não conseguiu o lock
	// Por que isso é útil na prática?
	// tryLock() é muito usado quando: 
	// você não pode bloquear, quer evitar deadlock, precisa de sistemas responsivos, prefere “falhar rápido” (fail fast)
	// Exemplo real: cache, fila, sistema financeiro, servidores web
	public void incrementTryLock() {
	    if (lock.tryLock()) {
	        try {
	            count++;
	            System.out.println(Thread.currentThread().getName() +
	                    " conseguiu o lock");
	        } finally {
	            lock.unlock();
	        }
	    } else {
	        System.out.println(Thread.currentThread().getName() +
	                " não conseguiu o lock");
	    }
	}

	// alternativa ao anterior que nao tenta novamentte
	// aqui esperamos um tempo estipulado antes de falhar
	public void incrementTryLockTimeoutWait() {
		try {
			if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
			    try {
			        System.out.println(Thread.currentThread().getName() +
			                " conseguiu o lock");
			    } finally {
			        lock.unlock();
			    }
			} else {
			    System.out.println(Thread.currentThread().getName() +
			            " desistiu após esperar");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getCount() {
		lock.lock();
		try {
			return count;
		} finally {
			lock.unlock();
		}
	}
}