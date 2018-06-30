package org.intw.searchpartner.workers;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.intw.searchpartner.materials.Goods;
import org.intw.searchpartner.materials.Product;

public class WorkerEntity implements Runnable{

	private BlockingQueue<Goods> queue;
	private int totalMachines;
	private int inputTotalMachines;
	private static final Logger LOGGER = Logger.getLogger("WorkerEntity");
    
    public WorkerEntity(BlockingQueue<Goods> queue, int machines){
        this.queue=queue;
        totalMachines = 0;
        this.inputTotalMachines = machines;
    }

    @Override
    public void run() {
        try{
        	
        	while(!queue.isEmpty() && totalMachines < inputTotalMachines) {
        			
        		Product product = new Product();
        		
        		while(!product.allGoodsReceived() ) {
        			if(product.addGood(queue.element()))
        				queue.take();
        		}
	            
        		++totalMachines;
        		LOGGER.log(Level.INFO, "Assembling {0}", product);
		        Thread.sleep(1000);
        	}
        } catch(InterruptedException e) {
        	LOGGER.log(Level.WARNING, "Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }
}