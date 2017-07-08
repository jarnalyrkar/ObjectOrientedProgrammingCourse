package tk.proghodet.conwaysgame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ConwaysLife implements MouseListener, ActionListener {
	
	final int WIDTH = 20;
	final int HEIGHT = 20;
	JFrame frame = new JFrame("Conway's Life");
	boolean[][] grid = new boolean[WIDTH][HEIGHT];
	MyPanel panel = new MyPanel(grid);
	boolean running = false;
	
	public ConwaysLife() {
		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		
		panel.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JButton step = new JButton("Step");
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		Container south = new Container();
		
	}
	
	public static void main(String[] args) {
		new ConwaysLife();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(e.getX() + ", " + e.getY());
		int row = Math.min(e.getY() / (panel.getHeight() / HEIGHT), HEIGHT - 1);
		int col = Math.min(e.getX() / (panel.getWidth() / WIDTH), WIDTH - 1);
		grid[col][row] = !grid[col][row];
		frame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource().equals(step) == true) {
//			step(); }	
	}
//	
//	public void step() {
//		
//	}
	
}