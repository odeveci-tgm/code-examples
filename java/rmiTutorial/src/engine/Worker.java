package engine;

import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

public class Worker implements Compute {
	public Worker() {
		super();
	}

	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			int counter = 1;
			String name = "Worker";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0); // öffnet
																					// Serversocket
			Registry registry = LocateRegistry.getRegistry("localhost");
			do {
				try {
					registry.bind(name + counter, stub);
					name = name + counter;
				} catch (AlreadyBoundException e) {
					counter++;
				}
			} while (name.matches("Worker"));
			System.out.println(name+" ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}

}