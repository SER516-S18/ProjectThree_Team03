package client.controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.view.DisplayGraph;
import client.view.ExpressiveView;
import client.view.FacePaint;

public class ExpressiveController {
	public ExpressiveView expressiveView;
	JPanel facePanel;
	JPanel graphPanel;
	private JPanel blinkGraph;
	private JPanel rgtWinkGraph;
	private JPanel lftWinkGraph;
	private JPanel lookGraph;
	private JPanel furrowGraph;
	private JPanel raiseGraph;
	private JPanel smileGraph;
	private JPanel lftSmirkGraph;
	private JPanel rgtSmirkGraph;
	private JPanel clenchGraph;
	private JPanel laughGraph;
	
	
public ExpressiveController(){
	facePanel= new JPanel();
	graphPanel=new JPanel();
	blinkGraph = new JPanel();
	rgtWinkGraph = new JPanel();
	lftWinkGraph = new JPanel();
	lookGraph = new JPanel();
	furrowGraph = new JPanel();
	raiseGraph = new JPanel();
	smileGraph = new JPanel();
	clenchGraph = new JPanel();
	lftSmirkGraph = new JPanel();
	smileGraph = new JPanel();
	rgtSmirkGraph = new JPanel();
	laughGraph = new JPanel();
	
	
	expressiveView = new ExpressiveView(facePanel, graphPanel,blinkGraph,rgtWinkGraph,lftWinkGraph,lookGraph,furrowGraph,
			raiseGraph,smileGraph,clenchGraph,lftSmirkGraph,rgtSmirkGraph,laughGraph);
	
	
	final JLabel faceLabel = new JLabel("    Face Expression");
	faceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	faceLabel.setBounds(0, 3, 336, 26);
	expressiveView.add(faceLabel);
	
	
	final JLabel graphLabel = new JLabel("    Graph Charts");
	graphLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	graphLabel.setBounds(336, 0, 357, 29);
	expressiveView.add(graphLabel);
	
	final FacePaint f = new FacePaint();
	final DisplayGraph g = new DisplayGraph();
	final DisplayGraph g1 = new DisplayGraph();
	final DisplayGraph g2 = new DisplayGraph();
	final DisplayGraph g3 = new DisplayGraph();
	final DisplayGraph g4 = new DisplayGraph();
	final DisplayGraph g5 = new DisplayGraph();
	final DisplayGraph g6 = new DisplayGraph();
	final DisplayGraph g7 = new DisplayGraph();
	final DisplayGraph g8 = new DisplayGraph();
	final DisplayGraph g9 = new DisplayGraph();
	final DisplayGraph g10 = new DisplayGraph();
	final DisplayGraph g11 = new DisplayGraph();
	
	
	
	
	

	
	
	
	
	

	
	Thread t = new Thread(new Runnable() {

		public void run() {
			while (true) {

				facePanel.add(f, BorderLayout.CENTER);
				facePanel.repaint();
				List<Double> al = new ArrayList<Double>();
				Random rand = new Random();
				double pick;
				for (int j = 0; j < 1; j++) {
					pick = rand.nextDouble();
					al.add(pick);
				}
				g.addValues(al);
				g1.addValues(al);
				g2.addValues(al);
				g3.addValues(al);
				g4.addValues(al);
				g5.addValues(al);
				g6.addValues(al);
				g7.addValues(al);
				g8.addValues(al);
				g9.addValues(al);
				g10.addValues(al);
				g11.addValues(al);
				// System.out.println(al);

				blinkGraph.add(g, BorderLayout.CENTER);
				blinkGraph.repaint();
				rgtWinkGraph.add(g1, BorderLayout.CENTER);
				rgtWinkGraph.repaint();
				lftWinkGraph.add(g2, BorderLayout.CENTER);
				lftWinkGraph.repaint();
				rgtWinkGraph.add(g3, BorderLayout.CENTER);
				rgtWinkGraph.repaint();
				lookGraph.add(g4, BorderLayout.CENTER);
				lookGraph.repaint();
				furrowGraph.add(g5, BorderLayout.CENTER);
				furrowGraph.repaint();
				raiseGraph.add(g6, BorderLayout.CENTER);
				raiseGraph.repaint();
				smileGraph.add(g7, BorderLayout.CENTER);
				smileGraph.repaint();
				clenchGraph.add(g8, BorderLayout.CENTER);
				clenchGraph.repaint();
				lftSmirkGraph.add(g9, BorderLayout.CENTER);
				lftSmirkGraph.repaint();
				rgtSmirkGraph.add(g10, BorderLayout.CENTER);
				rgtSmirkGraph.repaint();
				laughGraph.add(g11, BorderLayout.CENTER);
				laughGraph.repaint();

				// System.out.println(al);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
			}
		}

	});
	t.start();
}
	

}
