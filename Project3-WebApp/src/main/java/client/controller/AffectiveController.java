/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.view.AffectiveDisplayGraph;
import client.view.AffectiveView;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import utility.FaceExpressionData;

public class AffectiveController {

	public AffectiveView affectiveView;
	JPanel leftPanel;
	private JPanel affectiveGraph;
	JPanel perfPanel;
	private AffectiveDisplayGraph g1;

	public AffectiveController() {
		leftPanel = new JPanel();
		affectiveGraph = new JPanel();
		perfPanel = new JPanel();

		affectiveView = new AffectiveView(leftPanel, affectiveGraph, perfPanel);
		g1 = new AffectiveDisplayGraph();

	}

	public void updateGraph(FaceExpressionData fed) {

		List<Double> affectiveData = new ArrayList<Double>();
		double pick;
		Random rand = new Random();
		for (int j = 0; j < 6; j++) {
			pick = rand.nextDouble();
			affectiveData.add(pick);
		}
		g1.addValues(affectiveData);

		affectiveGraph.add(g1, BorderLayout.CENTER);
		affectiveGraph.repaint();

	}

}
