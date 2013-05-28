package de.repat.kissrc;

import de.repat.kissrc.enums.RoomEnum;

public class CurrentRoom {
    private RoomEnum roomEnum;
    private Color color;
    private boolean onOff;
    private static CurrentRoom instance;

    private CurrentRoom() {
        this.roomEnum = RoomEnum.LOUNGE;
    }

    public static CurrentRoom getInstance() {
        if (instance == null) {
            instance = new CurrentRoom();
        }
        return instance;
    }

    public static RoomEnum getRoom() {
        if (instance == null) {
            instance = new CurrentRoom();
        }
        return instance.getRoomEnum();
    }

    public RoomEnum getRoomEnum() {
        return this.roomEnum;
    }
    
    public Color getColor() {
        return this.color;
    }

    public void setRoomEnum(RoomEnum re) {
        this.roomEnum = re;
    }

}
