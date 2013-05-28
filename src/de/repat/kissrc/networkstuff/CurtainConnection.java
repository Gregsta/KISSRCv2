/**
 *
 * @date Apr2013
 */
package de.repat.kissrc.networkstuff;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.util.Log;

public class CurtainConnection implements SettingsStrings {

    // Singleton
    private static CurtainConnection instance;

    
    // Parameters for JSON-Message
    private String[] params = new String[5];

    public static CurtainConnection getInstance() {
        if (instance == null) {
            instance = new CurtainConnection();
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

    private JSONObject setCurtain(String room, String act) {

  Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put(ACTION, act);
        

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
    private JSONObject curtainOpen(String room) throws InvalidParameterException {
    	if(room.equals("Lounge"))
    		return setCurtain(room, LOUNGCURTAINOPEN );
    	else if(room.equals("KitchenMain"))
    		return setCurtain(room, KITCHENCURTAINOPEN );
    	else if(room.equals("Sleeping"))
    		return setCurtain(room, SLEEPINGCURTAINOPEN );
    	else throw new InvalidParameterException();
    }

    private JSONObject curtainClose(String room) throws InvalidParameterException {
    	if(room.equals("Lounge"))
    		return setCurtain(room, LOUNGCURTAINCLOSE );
    	else if(room.equals("KitchenMain"))
    		return setCurtain(room, KITCHENCURTAINCLOSE );
    	else if(room.equals("Sleeping"))
    		return setCurtain(room, SLEEPINGCURTAINCLOSE );
    	else throw new InvalidParameterException();
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
    public void openCurtain(String room) {
    	params[4] = curtainOpen(room).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeCurtain(String room) {
    	params[4] = curtainClose(room).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void openCurtainLouge() {
    	params[4] = setCurtain("Louge",LOUNGCURTAINOPEN).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeCurtainLouge() {
    	params[4] = setCurtain("Louge",LOUNGCURTAINCLOSE).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void openCurtainKitchen() {
    	params[4] = setCurtain("KitchenMain",KITCHENCURTAINOPEN).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeCurtainKitchen() {
    	params[4] = setCurtain("KitchenMain",KITCHENCURTAINCLOSE).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    
    public void openCurtainSleeping() {
    	params[4] = setCurtain("Sleeping",SLEEPINGCURTAINOPEN).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
    
    public void closeCurtainSleeping() {
    	params[4] = setCurtain("Sleeping",SLEEPINGCURTAINCLOSE).toString();

        sendMessageToProxy smtp = new sendMessageToProxy();
        smtp.execute(params);
    }
}
