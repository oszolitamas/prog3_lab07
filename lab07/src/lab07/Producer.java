package lab07;

import java.lang.Thread;

public class Producer implements Runnable {
	private String text;
	private Fifo fifo;
	private int waiting_time;
	
	public Producer(Fifo f, String s, int wt) {
		text = s;
		fifo = f;
		waiting_time = wt;
	}
	
	public void run() {
		int counter = 0;
		while (true) {
			try {
				long time = System.currentTimeMillis() % 100000;
				String s = text + " " + counter;
				fifo.put(s);
				System.out.println("produced " + s + " " + time);
				counter++;
				Thread.sleep(waiting_time);
			} catch(InterruptedException e) {
				System.out.println("megszakiva");
			}
		}
	}
}
