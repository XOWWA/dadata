package edu.ycp.cs320.movethesquare.model;

public class Game {
	public static final double MOVE_DIST = 10.0; // x/y distance square moves each tick 
	private double width, height;
	private Square square;
	private double squareDx;
	private double squareDy;
	
	public Game() {
		
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return square;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setSquareDx(double squareDx) {
		this.squareDx = squareDx;
	}
	
	public double getSquareDx() {
		return squareDx;
	}
	
	public void setSquareDy(double squareDy) {
		this.squareDy = squareDy;
	}
	
	public double getSquareDy() {
		return squareDy;
	}
}
