package client.controller;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.view.DisplayGraph;
import client.view.ExpressiveView;
import client.view.FacePaint;
import utility.FaceExpressionData;

public class ExpressiveController {
	public ExpressiveView expressiveView;
	JPanel facePanel;
	JPanel graphPanel;
	private JPanel blinkGraph;
	private JPanel rgtWinkGraph;
	private JPanel lftWinkGraph;
	private JPanel looklftGraph;
	private JPanel lookrgtGraph;
	private JPanel furrowGraph;
	private JPanel raiseGraph;
	private JPanel smileGraph;
	private JPanel lftSmirkGraph;
	private JPanel rgtSmirkGraph;
	private JPanel clenchGraph;
	private JPanel laughGraph;
	private FacePaint f;
	private DisplayGraph g;
	private DisplayGraph g1;
	private DisplayGraph g2;
	private DisplayGraph g3;
	private DisplayGraph g4;
	private DisplayGraph g5;
	private DisplayGraph g6;
	private DisplayGraph g7;
	private DisplayGraph g8;
	private DisplayGraph g9;
	private DisplayGraph g10;
	private DisplayGraph g11;

	public ExpressiveController() {
		facePanel = new JPanel();
		graphPanel = new JPanel();
		blinkGraph = new JPanel();
		rgtWinkGraph = new JPanel();
		lftWinkGraph = new JPanel();
		looklftGraph = new JPanel();
		lookrgtGraph = new JPanel();
		furrowGraph = new JPanel();
		raiseGraph = new JPanel();
		smileGraph = new JPanel();
		clenchGraph = new JPanel();
		lftSmirkGraph = new JPanel();
		smileGraph = new JPanel();
		rgtSmirkGraph = new JPanel();
		laughGraph = new JPanel();

		expressiveView = new ExpressiveView(facePanel, graphPanel, blinkGraph, rgtWinkGraph, lftWinkGraph, looklftGraph,
				lookrgtGraph, furrowGraph, raiseGraph, smileGraph, clenchGraph, lftSmirkGraph, rgtSmirkGraph,
				laughGraph);

		final JLabel faceLabel = new JLabel("    Face Expression");
		faceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		faceLabel.setBounds(0, 3, 336, 26);
		expressiveView.add(faceLabel);

		final JLabel graphLabel = new JLabel("    Graph Charts");
		graphLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		graphLabel.setBounds(336, 0, 357, 29);
		expressiveView.add(graphLabel);

		f = new FacePaint();
		g = new DisplayGraph();
		g1 = new DisplayGraph();
		g2 = new DisplayGraph();
		g3 = new DisplayGraph();
		g4 = new DisplayGraph();
		g5 = new DisplayGraph();
		g6 = new DisplayGraph();
		g7 = new DisplayGraph();
		g8 = new DisplayGraph();
		g9 = new DisplayGraph();
		g10 = new DisplayGraph();
		g11 = new DisplayGraph();

	}

	public void updateGraph(FaceExpressionData fed) {
		facePanel.add(f, BorderLayout.CENTER);
		facePanel.repaint();
		double[] v = fed.fetchVectors();
		g.addValues(v[1]);
		g1.addValues(v[2]);
		g2.addValues(v[3]);
		g3.addValues(v[4]);
		g4.addValues(v[5]);
		g5.addValues(v[6]);
		g6.addValues(v[7]);
		g7.addValues(v[8]);
		g8.addValues(v[9]);
		g9.addValues(v[10]);
		g10.addValues(v[11]);
		g11.addValues(v[12]);

		blinkGraph.add(g, BorderLayout.CENTER);
		blinkGraph.repaint();
		rgtWinkGraph.add(g1, BorderLayout.CENTER);
		rgtWinkGraph.repaint();
		lftWinkGraph.add(g2, BorderLayout.CENTER);
		lftWinkGraph.repaint();
		lookrgtGraph.add(g3, BorderLayout.CENTER);
		lookrgtGraph.repaint();
		looklftGraph.add(g4, BorderLayout.CENTER);
		looklftGraph.repaint();
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

	}

}
