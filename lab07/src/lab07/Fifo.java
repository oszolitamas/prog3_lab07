package lab07;

import java.util.LinkedList;

public class Fifo {
	private LinkedList<String> data = new LinkedList<>();
	
	public synchronized void put(String s) throws InterruptedException {
		while (data.size() == 10) {
			wait();
		}
		data.addLast(s);
		notifyAll();
	}
	
	public synchronized String get() throws InterruptedException {
        while (data.isEmpty()) {
            wait();
        }
        String s = data.removeFirst();
        notifyAll();
        return s;
    }
}
