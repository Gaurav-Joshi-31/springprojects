package helpers;

import java.util.List;

import models.Worker;

public class WorkerHelper {
	public static void printWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
			System.out.println(worker);
		}
	}
}
