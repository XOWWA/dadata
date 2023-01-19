
package edu.ycp.cs320.movethesquare.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.ycp.cs320.movethesquare.controllers.GameController;
import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameView extends JPanel {
	private static final Color MIDNIGHT_BLUE = new Color(16, 16, 128);
	
	private Game model;
	private GameController controller;
	private Timer timer;
	
	public GameView(Game model) {
		this.model = model;
		setPreferredSize(new Dimension((int) model.getWidth(), (int)model.getHeight()));
		setBackground(MIDNIGHT_BLUE);
		
		this.timer = new Timer(1000 / 60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerTick();
			}
		});
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void startAnimation() {
		timer.start();
	}

	protected void handleTimerTick() {
		if (controller == null) {
			return;
		}
		Square square = model.getSquare();
		Point mouseLoc = getMousePosition();
		if (mouseLoc != null) {
			controller.computeSquareMoveDirection(model, square, mouseLoc.getX(), mouseLoc.getY());
		}
		controller.moveSquare(model, square);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		
		g.setColor(Color.YELLOW);

		Square square = model.getSquare();

		g.fillRect((int) square.getX(), (int) square.getY(), (int) square.getWidth(), (int) square.getHeight());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game model = new Game();
				model.setWidth(1280.0);
				model.setHeight(1080.0);
				
				Square square = new Square();
				square.setX(540.0);
				square.setY(440.0);
				square.setWidth(40.0);
				square.setHeight(40.0);
				model.setSquare(square);
				
				GameController controller = new GameController();
				
				GameView view = new GameView(model);
				view.setController(controller);