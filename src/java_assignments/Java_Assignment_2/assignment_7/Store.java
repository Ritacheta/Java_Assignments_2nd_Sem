import java.util.*;

class ProducerConsumer {
	LinkedList<Integer> list=new LinkedList<>();
	int capacity=10;

	// Function called by producer thread
	public void produce() throws InterruptedException
	{
		int value = 0;
		while (true) {
			synchronized (this)
			{
				while (list.size() == capacity)
					wait();

				System.out.println("Producer produced-"+ value);
				list.add(value++);
				notifyAll();
				Thread.sleep(1000);
			}
		}
	}
	public void consume() throws InterruptedException
	{
		while (true) {
			synchronized (this)
			{
				// consumer thread waits while list is empty
				while (list.size() == 0)
					wait();

				// to retrive the ifrst job in the list
				int val = list.removeFirst();
				System.out.println("Consumer consumed-"+ val);
				notifyAll();
				Thread.sleep(1000);
			}
		}
	}
}
public class Store {
	public static void main(String[] args)
		throws InterruptedException
	{
		final ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.produce();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.consume();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
