
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