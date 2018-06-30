package org.intw.searchpartner.materials;

import java.util.LinkedList;
import java.util.List;

public class Product {

	private List<Goods> goods;
	private int bolts;
	private int machines;
	
	public Product() {
		this.goods = new LinkedList<>();
	}
	
	public boolean addGood(Goods rawGood){
		
		boolean status = false;
		
		if(rawGood.isLock())
			return status;
		
		rawGood.setLocked();
		
		switch(rawGood.getMaterialType()) {
			case BOLT :
				status = addBolt();
				break;
			case MACHINE:
				status = addMachine();
				break;
			default:
				break;
		}
		
		if(status) goods.add(rawGood);
		else rawGood.resetLock();
		
		return status;
	}
	
	public boolean addBolt(){
		boolean status = false;
		
		if(checkBolts()) {
			++this.bolts;
			status = true;
		}
		
		return status;
	}
	
	public boolean addMachine(){
		boolean status = false;
		
		if(checkMachine()) {
			++this.machines;
			status = true;
		}
		
		return status;
	}
	
	public boolean checkBolts(){
		return this.bolts < 2;
	}
	
	public boolean checkMachine(){
		return this.machines < 1;
	}
	
	public boolean allGoodsReceived(){
		return !checkBolts() && !checkMachine();
	}
	
	public void resetGoods(){
		this.bolts = this.machines = 0;
	}
	
	@Override
	public String toString() {
		return "Assembling Product [goods=" + goods + "]";
	}

}
