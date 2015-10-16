package veiw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class graphpanel extends JPanel{

	int[][] graph;
	int width;
	int length;
	
	graphpanel(int[][] graph){
		
		this.width = graph.length;
        this.length = graph[0].length;
        this.graph = new int[(width)*15+1][(length)*15+1];
		
		for(int i = 0; i < width*15; i ++){
        	for(int j = 0; j < length*15; j++){
        		this.graph[i][j] = graph[i/15][j/15];
        	}
        }
	}
	
	
		 private void doDrawing(Graphics g , int[][] graph) {
		        Graphics2D g2d = (Graphics2D) g;
		        g2d.setColor(Color.BLUE);
		        
		        int width = this.graph.length;
		        int length = this.graph[0].length;
		        
		        //iterates through the array and blocks the colors
		        for(int i = 0; i < width; i ++){
		        	for(int j = 0; j < length; j++){
		        		//walls
		        		if(graph[j][i] == 1){
		    		        g2d.setColor(Color.BLACK);
		        			g2d.drawLine(i, j, i, j);
		        		}
		        		//Enemies
		        		if(graph[j][i] == 2){
		        			g2d.setColor(Color.RED);
		        			g2d.drawLine(i, j, i, j);		        		
		        		}
		        		//Chests
		        		if(graph[j][i] == 3){
		        			g2d.setColor(Color.BLUE);
		        			g2d.drawLine(i, j, i, j);		        		
		        		}
		        		
		        		if(i % 15 == 0 || j % 15 == 0){
		    		        g2d.setColor(Color.BLACK);
		        			g2d.drawLine(i,j,i,j);
		        		}
		        		
		        	}
		        }

		       
		    }

		    @Override
		    public void paintComponent(Graphics g) {

		        super.paintComponent(g);
		        doDrawing(g, graph);		 
		    }

	}