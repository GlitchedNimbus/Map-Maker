package veiw;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Floor;

public class GUI extends JFrame{

	int[][] grid = new int[40][40];

	graphpanel board;
	JPanel infoPanel;
	JPanel buttonPanel;
	JPanel visuals;
	JButton Save;
	JButton Load;
	JButton Refresh;
	JButton Edit;

	
	GUI(int k){
		setup();
	}
	
	GUI(){
		Floor floor = new Floor();
		floor.getGrid(grid);
		setup();
}
	
private void setup(){
this.setTitle("Dungeon");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setSize(1217,640);
this.setLayout(new GridLayout(1,2));

board = new graphpanel(grid);
infoPanel = new JPanel();
buttonPanel = new JPanel();
Save = new JButton("Save");
Load = new JButton("Load");
Refresh = new JButton("Refresh");
Edit = new JButton("Edit");
visuals = new JPanel();


buttonPanel.setLayout(new FlowLayout());
buttonPanel.add(Save);
buttonPanel.add(Load);
buttonPanel.add(Edit);
buttonPanel.add(Refresh);

Save.addActionListener(new ButtonListener());
Load.addActionListener(new ButtonListener());
Edit.addActionListener(new ButtonListener());
Refresh.addActionListener(new ButtonListener());

this.add(visuals);
visuals.setPreferredSize(new Dimension(600,640));
board.setPreferredSize(new Dimension(600,640));
visuals.add(board);

this.add(infoPanel);
infoPanel.add(buttonPanel);
this.setVisible(true);

}
private void addIt(graphpanel panel) {
	visuals.remove(board);
	panel.setPreferredSize(new Dimension(600,640));
	visuals.add(panel);
	board = panel;
	revalidate();
}

class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Save){
			
		}
		
		if(e.getSource() == Load){
			
		}
		
		if(e.getSource() == Refresh){
			Floor floor = new Floor();
			floor.getGrid(grid);		
			graphpanel boards = new graphpanel(grid);
			addIt(boards);
			repaint();
			}
		
		if(e.getSource() == Edit){
			
		}
	}
}

}
