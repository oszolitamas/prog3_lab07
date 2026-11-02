package lab07;

public class Application {
	public static void main(String args[]) {
		Fifo f = new Fifo();
		Producer p = new Producer(f, "elso", 500);
		Consumer c = new Consumer(f, "fogyaszto", 1000);
		Thread t = new Thread(p);
		t.start();
		c.start();
	}
}
