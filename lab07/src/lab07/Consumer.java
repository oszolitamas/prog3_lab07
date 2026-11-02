package lab07;

public class Consumer extends Thread {
	private Fifo f;
	private String s;
	private int n;
	
	public Consumer(Fifo f, String s, int n) {
		this.f = f;
		this.s = s;
		this.n = n;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("consumed " + s + f.get() + System.currentTimeMillis() % 100000);
				sleep(n);
			} catch(InterruptedException e) {
				System.out.println("meszakitva");
			}
		}
	}
}
