package client;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.Compute;

public class ComputeFibonacci {
	public static void main(String args[]) {
    if (System.getSecurityManager() == null) {
        System.setSecurityManager(new SecurityManager());
    }
    try {
    	// Hier ist was ganz wichtiges
        String name = "Compute";
        Registry registry = LocateRegistry.getRegistry(args[0]);
        Compute comp = (Compute) registry.lookup(name);
        Fibonacci task = new Fibonacci(Integer.parseInt(args[1]));
        BigInteger fibo = comp.executeTask(task);
        System.out.println(fibo);
    } catch (Exception e) {
        System.err.println("ComputeFibo exception:");
        e.printStackTrace();
    }
  } 
}
