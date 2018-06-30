package org.intw.searchpartner.materials;

public class Goods {

	private RawMaterials material;
	private String description;
	private boolean isLocked;
	
	public void setLocked(){
		this.isLocked = true;
	}
	
	public void resetLock() {
		this.isLocked = false;
	}
	
	public boolean isLock() {
		return this.isLocked;
	}
	
	public Goods(RawMaterials material, String description) {
		this.material = material; 
		this.description = description;
	}

	public RawMaterials getMaterialType() {
		return this.material;
	}
	
	public String getDescription() {
		return this.description;
	}


	@Override
	public String toString() {
		return "Goods [material=" + material + ", description=" + description + "]";
	}
	
}
