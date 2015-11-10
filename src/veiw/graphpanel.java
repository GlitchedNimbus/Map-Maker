package veiw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class graphpanel extends JPanel {

	int[][] graph;
	int width;
	int length;

	graphpanel(int[][] graph) {

		this.width = graph.length;
		this.length = graph[0].length;
		this.graph = new int[(width) * 15 + 1][(length) * 15 + 1];
		this.addMouseListener(new mouseListener());
		this.addMouseMotionListener(new mouseListener());
		
		for (int i = 0; i < width * 15; i++) {
			for (int j = 0; j < length * 15; j++) {
				this.graph[i][j] = graph[i / 15][j / 15];
			}
		}
		repaint();
	}

	private void doDrawing(Graphics g, int[][] graph) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);

		int width = this.graph.length;
		int length = this.graph[0].length;

		// iterates through the array and blocks the colors
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				// walls
				if (graph[j][i] == 1) {
					g2d.setColor(Color.BLACK);
					g2d.drawLine(i, j, i, j);
				}
				// Enemies
				if (graph[j][i] == 2) {
					g2d.setColor(Color.RED);
					g2d.drawLine(i, j, i, j);
				}
				// Chests
				if (graph[j][i] == 3) {
					g2d.setColor(Color.BLUE);
					g2d.drawLine(i, j, i, j);
				}

				if (i % 15 == 0 || j % 15 == 0) {
					g2d.setColor(Color.BLACK);
					g2d.drawLine(i, j, i, j);
				}

			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g, graph);
	}

	private class mouseListener implements MouseInputListener{
		Point click;
		
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int X = arg0.getX();
			int Y = arg0.getY();	
				if(graph[X][Y] == 1)
					graph[arg0.getX()][arg0.getY()] = 0;
				
				if(graph[X][Y] == 0)
					graph[X][Y] = 1;
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			click = new Point(arg0.getX(),arg0.getY());
			System.out.println(click.getX() + " Point " + click.getY());
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int X = arg0.getX();
			int Y = arg0.getY();
			if(Math.abs(Y - click.getY()) == 15 && Math.abs(X - click.getX()) == 15){
				
				if(graph[X/15][Y/15] == 1)
					graph[X/15][Y/15] = 0;
				
				else if(graph[X/15][Y/15] == 0)
					graph[X/15][Y/15] = 1;
					
				repaint();
				
				click = new Point(arg0.getX(),arg0.getY());
			}
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}