package de.repat.kissrc;

import de.repat.kissrc.enums.ModeEnum;
import android.util.Log;

public class Mode {
    private ModeEnum lcw;
    private static Mode instance;

    private Mode() {
        this.lcw = ModeEnum.LIGHTS;
    }

    public static Mode getInstance() {
        if (instance == null) {
            instance = new Mode();
        }
        return instance;
    }

    public ModeEnum getLCWMode() {
        return this.lcw;
    }

    public void next() {
        if (lcw == ModeEnum.LIGHTS) {
            lcw = ModeEnum.CURTAINS;
        } else if (lcw == ModeEnum.CURTAINS) {
            lcw = ModeEnum.WINDOWS;
        } else if (lcw == ModeEnum.WINDOWS) {
            lcw = ModeEnum.LIGHTS;
        } else {
            Log.d("LightsCurtainsWindows", "ERROR in next()");
        }
    }
}
