package edu.ycp.cs320.movethesquare.model;

public class Game {
	public static final double MOVE_DIST = 10.0; // x/y distance square moves each tick 
	private double width, height;
	private Square square;
	private double squareDx;
	private double squareDy;
	
	public Game() {
		
	}
	
	public void se