package client.constants;

import java.awt.Color;

import utility.Constants;
/**
 * ClientConstants holds values that are to be used
 * by the client program.
 */
public class ClientConstants extends Constants {
    public static volatile int CHANNELS = 2;
    public static final int MAX_RETRIES = 10;
    public static volatile int DEFAULT_FREQ = 2;
	public static final String INTEREST = "Interest";
	public static final String ENGAGEMENT = "Engagement";
	public static final String STRESS = "  Stress  ";
	public static final String RELAXATION = "Relaxation";
	public static final String EXCITEMENT = "Excitement";
	public static final String FOCUS = "Focus";
	public final static String DISPLAY_LENGTH = "Length:";
	public final static String SECONDS = "Seconds";
	public final static Color INTEREST_COLOR = Color.BLACK;
	public final static Color ENGAGEMENT_COLOR = Color.BLACK;
	public final static Color STRESS_COLOR = Color.BLACK;
	public final static Color RELAXATION_COLOR = Color.BLACK;
	public final static Color EXCITEMENT_COLOR = Color.BLACK;
	public final static Color FOCUS_COLOR = Color.BLACK;
	public final static Color GRAPHPANEL = new Color(238, 238, 238);
	public final static Color GRAPHLABEL_BACKGROUND = Color.GRAY;
	public final static Color GRAPHLABEL_FOREGROUND = Color.WHITE;
}
