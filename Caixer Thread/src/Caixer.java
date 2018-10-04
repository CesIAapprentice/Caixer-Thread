import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Caixer implements Runnable{
	
	private String name;
	private ArrayList<Client> queue;
	private Random random;
	private Integer totalTime;

	public Caixer(String name) {
		this.random = new Random();
		this.name = name;
		this.queue = new ArrayList<Client>();
		setClients();
		this.totalTime = 0;
	}
	
	public void setClients() {
		for (Integer i=0; i< this.random.nextInt(6) + 10; i++){
			this.queue.add(new Client());
		}
	}
	
	public Integer getNumberOfClients() {
		return this.queue.size();
	}
	
	public Integer getTimeToWait() {
		return totalTime; 
	}

	@Override
	public void run() {
		
		for (Client client : queue) {
			try {
				Integer timeToWait = this.random.nextInt(100);
				TimeUnit.MILLISECONDS.sleep(timeToWait);
				this.totalTime += timeToWait;
				//System.out.println(this.getName() + " " + totalTime + " " + timeToWait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " - Number of clients: " + this.getNumberOfClients() + " - Total time: " + this.getTimeToWait());
	}

	public String getName() {
		return name;
	}
}
