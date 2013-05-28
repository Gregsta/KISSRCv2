package de.repat.kissrc;

import de.repat.kissrc.enums.RoomEnum;

public class Room {

    private RoomEnum roomEnum;
    private Color color;
    private boolean onOff;
    private static Room instance;

    private Room() {
        onOff = false;
        this.roomEnum = RoomEnum.LOUNGE;
        this.color = new Color("0", "0", "0");
    }

    private Room(RoomEnum re) {
        this.onOff = false;
        this.roomEnum = re;
        this.color = new Color("0", "0", "0");
    }

    public static Room getInstance() {
        if (instance == null) {
            instance = new Room();
        }
        return instance;
    }

    public RoomEnum getRoomEnum() {
        return this.roomEnum;
    }

    public void setRoomEnum(RoomEnum re) {
        this.roomEnum = re;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public boolean getonOff() {
        return this.onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public void turnLightsOff() {
        setOnOff(false);
    }

    public void turnLightsOn() {
        setOnOff(true);
    }

}
