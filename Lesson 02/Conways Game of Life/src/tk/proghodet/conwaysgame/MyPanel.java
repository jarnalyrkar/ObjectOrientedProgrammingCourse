package tk.proghodet.conwaysgame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	boolean[][] grid;

	public MyPanel(boolean[][] newGrid) {
		grid = newGrid;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double boxWidth = (double)this.getWidth() / grid.length;
		double boxHeight = (double)this.getHeight() / grid.length;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					if (grid[i][j] == true) {
			g.setColor(Color.BLUE);
			g.fillRect((int)(i*boxWidth), (int)(j*boxHeight), (int)(boxWidth), (int)(boxHeight));
			}
		}
		
		
		
	}

}
}