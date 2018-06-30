/**
 * 
 */
package org.intw.searchpartner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.intw.searchpartner.materials.Goods;
import org.intw.searchpartner.materials.RawMaterials;
import org.intw.searchpartner.workers.WorkerEntity;

/**
 * @author Admin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Goods> queue = new ArrayBlockingQueue<>(100);
		queue.put(new Goods(RawMaterials.BOLT, "Bolt11"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt12"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine1"));		
		queue.put(new Goods(RawMaterials.BOLT, "Bolt21"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt22"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine2"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt31"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt32"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine3"));
		
		queue.put(new Goods(RawMaterials.BOLT, "Bolt41"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt42"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine4"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt51"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt52"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine5"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt61"));
		queue.put(new Goods(RawMaterials.BOLT, "Bolt62"));
		queue.put(new Goods(RawMaterials.MACHINE, "Machine6"));
		
		int totalMachines = 6;
		int threads = 3;
		Thread c1 = new Thread(new WorkerEntity(queue,totalMachines/threads));
		Thread c2 = new Thread(new WorkerEntity(queue,totalMachines/threads));
		Thread c3 = new Thread(new WorkerEntity(queue,totalMachines/threads));
		
		c1.start();
		c2.start();
		c3.start();
		c1.join();
		c2.join();
		c3.join();
	}

}
