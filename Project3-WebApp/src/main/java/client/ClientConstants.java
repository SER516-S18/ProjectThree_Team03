package client;

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
}
