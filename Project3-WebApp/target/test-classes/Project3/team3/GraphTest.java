import org.junit.jupiter.api.Test;
import client.view.AffectiveDisplayGraph;
import client.view.AffectiveView;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import utility.FaceAffectiveData;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Unit Test class to check whether graph is getting updated
 */
class GraphControllerTest{
  @Test
  void testUpdateGraphView(){
    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView(graphModel);
    GraphController graphController = new GraphController(graphModel, graphView);
    graphController.setNoOfChannels(6);
    Color channelColors[] = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.GRAY };
    graphController.setChannelColors(channelColors);
    ArrayList<ArrayList<CoordinatesModel>> graphData = new ArrayList<ArrayList<CoordinatesModel>>();
    for(int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
      ArrayList<CoordinatesModel> coordinatesList = new ArrayList<CoordinatesModel>();
      for(int channelNo = 0; channelNo < graphController.getNoOfChannels(); channelNo++) {
        Random rand = new Random();
        double yCoordinate = rand.nextDouble();
        coordinatesList.add(new CoordinatesModel(xCoordinate, yCoordinate + channelNo));
      }
      graphData.add(coordinatesList);
    }
    graphController.setXLength(100);
    graphController.setGraphData(graphData);
    graphController.updateGraphView();
  }
}