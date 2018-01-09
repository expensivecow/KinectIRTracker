package main.java.org.kinectirtracker;

import java.nio.ByteBuffer;

import org.openkinect.freenect.Context;
import org.openkinect.freenect.Device;
import org.openkinect.freenect.FrameMode;
import org.openkinect.freenect.Freenect;
import org.openkinect.freenect.VideoFormat;
import org.openkinect.freenect.VideoHandler;

public class KinectIRTracker {
	private static final int KINECT_DEVICE = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context = Freenect.createContext();
		
		try {
			Device kinect = context.openDevice(KINECT_DEVICE);
			
			kinect.refreshTiltState();
			kinect.setVideoFormat(VideoFormat.IR_8BIT);
			
			kinect.startVideo(new VideoHandler() {
				public void onFrameReceived(FrameMode mode, ByteBuffer frame, int timestamp) {
					// TODO Auto-generated method stub
					System.out.println("TEST");
				}
			});

			// infinite loop while reading frames
			while(true) {
				
			}			
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return;
		}
	}

}
