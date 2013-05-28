package de.repat.kissrc.networkstuff;

public interface SettingsStrings {

    // Network and Debugging
    static final String IP = "172.16.0.200";
    static final String PORT = "12349";
    static final String LIGHTCONTROL = "LP.LIGHTCONTROL";
    static final String WINDOWCONTROL = "WINDOW.CONTROL";
    static final String TOPIC = "TOPIC";
    static final String TEAM = "TEAM_ROCKET";
    static final String DEBUGMSG = TEAM + "-Lights";

    // valueMap
    static final String RED = "red";
    static final String GREEN = "green";
    static final String BLUE = "blue";
    static final String FADETIME = "fadeTime";

    // aendernMap
    static final String VALUES = "values";
    static final String ID = "Id";
    static final String VERSION = "Version";
    static final String ACTION = "action";

    // Rooms
    static final String DININGCOLOR = "dining_light_color";
    static final String LOUNGECOLOR = "lounge_light_color";
    static final String BATHROOMCOLOR = "bathroom_light_color";
    static final String KITCHENMAINCOLOR = "kitchen_main_light_color";
    static final String KITCHENCOOKINGCOLOR = "kitchen_cooking_color";
    static final String CORRIDORCOLOR = "corridor_light_color";
    static final String SLEEPINGCOLOR = "sleeping_light_color";
    
    // Curtains
    static final String LOUNGCURTAINOPEN = "lounge_curtain_open";
    static final String LOUNGCURTAINCLOSE = "lounge_curtain_close";
    static final String KITCHENCURTAINOPEN = "sleeping_hall_curtain_open";
    static final String KITCHENCURTAINCLOSE = "sleeping_hall_curtain_close";
    static final String SLEEPINGCURTAINOPEN = "sleeping_window_curtain_open";
    static final String SLEEPINGCURTAINCLOSE = "sleeping_window_curtain_close";
   
    // Windows
    static final String SITTINGCONRNERLEFT = "winDining0";
    static final String SITTINGCORNERRIGHT = "winDining1";
    static final String KICTHEN = "winKitchen0";
    static final String KITCHENRIGHT = "winKitchen1";
    static final String LOUNGEFARLEFT = "winLouge0";
    static final String LOUNGELEFTS = "winLouge1";
    static final String LOUNGEMIDDLE = "winLouge2";
    static final String LOUNGERIGHT = "winLouge3";
    static final String LOUNGEFARRIGHT = "winLouge4";
    static final String BATHROOM = "winBathroom";
    
    static final String ALL = "ALL";
    static final String DINING = "DINING";
    static final String KITCHEN = "KITCHEN";
    static final String LOUNGE = "LOUNGE";
}
