{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf400
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
import org.junit.jupiter.api.Test;\
import client.view.AffectiveDisplayGraph;\
import client.view.AffectiveView;\
import java.awt.BorderLayout;\
import javax.swing.JPanel;\
import utility.FaceAffectiveData;\
import java.awt.*;\
import java.util.ArrayList;\
import java.util.Random;\
\
/**\
 * Unit Test class to check whether graph is getting updated\
 */\
class GraphControllerTest \{\
\
  @Test\
  void testUpdateGraphView() \{\
    GraphModel graphModel = new GraphModel();\
    GraphView graphView = new GraphView(graphModel);\
    GraphController graphController = new GraphController(graphModel, graphView);\
\
    graphController.setNoOfChannels(6);\
    Color channelColors[] = new Color[] \{ Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.GRAY \};\
    graphController.setChannelColors(channelColors);\
\
    ArrayList<ArrayList<CoordinatesModel>> graphData = new ArrayList<ArrayList<CoordinatesModel>>();\
    for(int xCoordinate = 0; xCoordinate < 10; xCoordinate++) \{\
      ArrayList<CoordinatesModel> coordinatesList = new ArrayList<CoordinatesModel>();\
      for(int channelNo = 0; channelNo < graphController.getNoOfChannels(); channelNo++) \{\
        Random rand = new Random();\
        double yCoordinate = rand.nextDouble();\
        coordinatesList.add(new CoordinatesModel(xCoordinate, yCoordinate + channelNo));\
      \}\
      graphData.add(coordinatesList);\
    \}\
    graphController.setXLength(100);\
    graphController.setGraphData(graphData);\
    graphController.updateGraphView();\
  \}\
\}}