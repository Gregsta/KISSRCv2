package de.repat.kissrc.networkstuff;

import java.io.IOException;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import de.repat.kissrc.controllable.Lights;
import de.repat.kissrc.networkstuff.AndroidPublisher;
import de.repat.kissrc.networkstuff.Message;
//import de.repat.kissrc.networkstuff.Connector.sendMessageToProxy;

public class Connector {
	private static final String ip = "172.16.0.200";
	private static final String port = "12349";

	public static String getIp() {
		return ip;
	}

	public static String getPort() {
		return port;
	}
	
	/*
	 * ----------LIGHT----------
	 */
	
	public JSONObject diningLightOn() {
	return Lights.diningLightOn();
	}

	public JSONObject diningLightOff() {
		return Lights.diningLightOff();
	}
	
	public JSONObject loungeLightOff() {
		return Lights.loungeLightOff();
	}
	
	public JSONObject loungeLightOn() {
		return Lights.loungeLightOn();
	}
	
	public JSONObject kitchenCookingLightOn(){
		return Lights.kitchenCookingLightOn();
	}
	
	public JSONObject kitchenCookingLightOff(){
		return Lights.kitchenCookingLightOff();
	}
	
	
	public JSONObject kitchenMainLightOn(){
		return Lights.kitchenMainLightOn();
	}
	
	public JSONObject kitchenMainLightOff(){
		return Lights.kitchenMainLightOff();
	}
	
	public JSONObject sleepingLightOn(){
		return Lights.sleepingLightOn();
	}
	
	public JSONObject sleepingLightOff(){
		return Lights.sleepingLightOff();
	}
	
	public JSONObject corridorLightOn(){
		return Lights.corridorLightOn();
	}
	
	public JSONObject corridorLightOff(){
		return Lights.corridorLightOff();
	}
	
	public JSONObject bathroomLightOn(){
		return Lights.bathroomLightOn();
	}
	
	public JSONObject bathroomLightOff(){
		return Lights.bathroomLightOff();
	}
//	public JSONObject curtainOpen() {
//		return Curtain.loungeCurtainOpen();
//	}
//	
//	public JSONObject curtainClose() {
//		return Curtain.loungeCurtainClose();
//	}

	
	public void statusChanged(Message msg) {

		String[] params = new String[5];
		params[0] = getIp();
		params[1] = getPort();
		params[2] = msg.getTopic();
		params[3] = msg.getTyp();
		params[4] = msg.getMessage().toString();
		
		sendMessageToProxy send = new sendMessageToProxy();
		
		send.execute(params);
	}
	
	
	
	

	private class sendMessageToProxy extends AsyncTask<String, Void, String> {
		//
		// params[0] Server; [1] Port; [2] TopicName; [3]topic/queue;
		@Override
		protected String doInBackground(String... params) {
			try {
				// new AndroidPublisher(adress; port; topic-name)
				AndroidPublisher publisher = new AndroidPublisher(params[0],
						Integer.valueOf(params[1]), params[2]);

				publisher.setMessage(params[4]);
				
				if (params[3].equals("Topic")) {
					Log.v("TEAM_ROCKET", "topic");
					publisher.publishToTopic();
					
				} else {
					Log.v("TEAM_ROCKET", "queue");
					publisher.publishToQueue();
					
				}
			} catch (IOException e) {
				Log.e("Publisher", "Can't publish!");
			}
			return null;
		}

	}
}
