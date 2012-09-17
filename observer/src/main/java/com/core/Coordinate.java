package com.core;


public class Coordinate {

	private double posX, posY;
	
	public Coordinate(double posX2, double posY2) {
		this.posX = posX2;
		this.posY = posY2;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + posX;
		result = prime * result + posY;
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

	
}
