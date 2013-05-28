package de.repat.kissrc.networkstuff;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
//import de.repat.kissrc.networkstuff.WindowConnection.sendMessageToProxy;

public class WindowConnection implements SettingsStrings {
	 // Singleton
    private static WindowConnection instance;

    
    // Parameters for JSON-Message
    private String[] params = new String[5];

    public static WindowConnection getInstance() {
        if (instance == null) {
            instance = new WindowConnection();
            instance.init();
        }
        return instance;
    }

    private void init() {
        params[0] = IP;
        params[1] = PORT;
        params[2] = WINDOWCONTROL;
        params[3] = TOPIC;
    }

    private JSONObject setWindow(String window, String openingState) {

  Map<String, String[]> valueMap = new HashMap<String, String[]>();
  		
        valueMap.put(window,new String[]{openingState,"SLOW"});
   
        

        Map<String, Object> aendernMap = new HashMap<String, Object>();
        aendernMap.put(VALUES, new JSONObject(valueMap));
        aendernMap.put(ID, TEAM);
        aendernMap.put(VERSION, null);
        aendernMap.put(ACTION, window);

        JSONObject jsonMap = new JSONObject(aendernMap);

        Log.d(DEBUGMSG, jsonMap.toString());

        return jsonMap;
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
    public void openWindowAll() {
    	params[4] = setWindow(ALL,"20").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeWindowAll() {
    	params[4] = setWindow(ALL, "0").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void openWindowDining() {
    	params[4] = setWindow(DINING,"20").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeWindowDining() {
    	params[4] = setWindow(DINING, "0").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void openWindowKitchen() {
    	params[4] = setWindow(KITCHEN,"20").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeWindowKitchen() {
    	params[4] = setWindow(KITCHEN, "0").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void openWindowLounge() {
    	params[4] = setWindow(LOUNGE,"20").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeWindowLounge() {
    	params[4] = setWindow(LOUNGE, "0").toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
}
