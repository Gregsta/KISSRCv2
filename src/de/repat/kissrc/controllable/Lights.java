package de.repat.kissrc.controllable;

import java.util.HashMap;

import org.json.JSONObject;

import android.util.Log;
import de.repat.kissrc.networkstuff.JsonMapBuilder;

public class Lights {/*
	 * -----------------dining light-----------------
	 */
	public static JSONObject diningLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("dining_light_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject diningLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("dining_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------lounge light-----------------
	 */
	public static JSONObject loungeLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("lounge_light_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject loungeLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("lounge_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------kitchen cooking light-----------------
	 */
	public static JSONObject kitchenCookingLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("kitchen_cooking_ligh_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject kitchenCookingLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("kitchen_cooking_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------kitchen main light-----------------
	 */
	public static JSONObject kitchenMainLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("kitchen_main_light_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject kitchenMainLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("kitchen_main_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------corridor light-----------------
	 */
	public static JSONObject corridorLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("corridor_light_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject corridorLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("corridor_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------sleeping light-----------------
	 */
	public static JSONObject sleepingLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("sleeping_light_on",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

	public static JSONObject sleepingLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("sleeping_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	/*
	 * -----------------bathroom light-----------------
	 */
	public static JSONObject bathroomLightOn() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("bathroom_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}
	
	public static JSONObject bathroomLightOff() {
		JSONObject msgDiningLight = new JSONObject(JsonMapBuilder.buildJsonMap("bathroom_light_off",new HashMap<String, String>()));
		Log.d("JSONDemo", msgDiningLight.toString());
		return msgDiningLight;
	}

}
