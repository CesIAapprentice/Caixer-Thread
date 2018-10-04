import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caixer left = new Caixer("Left");
		Caixer center = new Caixer("Center");
		Caixer right = new Caixer("Right");
		
		ArrayList<Caixer> caixers = new ArrayList<Caixer>();
		Collections.addAll(caixers, left, center, right);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (Caixer caixer : caixers) {
			exec.execute(caixer);
		}
		exec.shutdown();
	}

}
