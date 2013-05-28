/**
 *
 * @date Apr2013
 */
package de.repat.kissrc.networkstuff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


import android.os.AsyncTask;
import android.util.Log;

public class LightConnection implements SettingsStrings {

    // Singleton
    private static LightConnection instance;

    
    // Parameters for JSON-Message
    private String[] params = new String[5];

    public static LightConnection getInstance() {
        if (instance == null) {
            instance = new LightConnection();
            instance.init();
        }
        return instance;
    }

    private void init() {
        params[0] = IP;
        params[1] = PORT;
        params[2] = LIGHTCONTROL;
        params[3] = TOPIC;
    }

    private JSONObject setLightinRoom(String room, String R, String G, String B, String fadeTime) {

        // Fallback for debugging
//        if (room == null || R == null || G == null || B == null || fadeTime == null) {
//            room = DININGCOLOR;
//            R = "0";
//            G = "0";
//            B = "0";
//            fadeTime = "0";
//        }

        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put(RED, R);
        valueMap.put(GREEN, G);
        valueMap.put(BLUE, B);
        valueMap.put(FADETIME, fadeTime);

        Map<String, Object> aendernMap = new HashMap<String, Object>();
        aendernMap.put(VALUES, new JSONObject(valueMap));
        aendernMap.put(ID, TEAM);
        aendernMap.put(VERSION, null);
        aendernMap.put(ACTION, room);

        JSONObject jsonMap = new JSONObject(aendernMap);

        Log.d(DEBUGMSG, jsonMap.toString());

        return jsonMap;
    }

    // Test Mappings
    private JSONObject lightsOff(String room) {
        return setLightinRoom(room, "0", "0", "0", "0");
    }

    private JSONObject lightsOn(String room) {
        return setLightinRoom(room, "255", "255", "255", "0");
    }

    // Network Stuff
    private class sendMessageToProxy extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                AndroidPublisher publisher = new AndroidPublisher(params[0], Integer.valueOf(params[1]), params[2]);
                publisher.setMessage(params[4]);
                if (params[3].equalsIgnoreCase(TOPIC)) {
                    publisher.publishToTopic();
                    Log.d(DEBUGMSG, "Published to Topic");

                } else {
                    publisher.publishToQueue();
                }
            } catch (IOException e) {
                Log.e("Publisher", "Can't publish the message");
            }
            return null;
        }

    }

    // This is called by MainActivity
    public void execute(String room, String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(room, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }


    public void setLightLounge( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(LOUNGECOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightKitchenMain( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(KITCHENMAINCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightKitchenCooking( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(KITCHENCOOKINGCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightDining( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(DININGCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightCorridor( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(CORRIDORCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightSleeping( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(SLEEPINGCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }

    public void setLightBathroom( String R, String G, String B, String fadeTime) {

        params[4] = setLightinRoom(BATHROOMCOLOR, R, G, B, fadeTime).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
}
