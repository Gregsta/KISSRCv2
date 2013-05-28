package de.repat.kissrc;

public class Color {

    private String red;
    private String green;
    private String blue;

    private Color() {
        red = "0";
        green = "0";
        blue = "0";
    }

    public Color(String r, String g, String b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public void setColor(String r, String g, String b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public String getRed() {
        return this.red;
    }

    public String getGreen() {
        return this.green;
    }

    public String getBlue() {
        return this.blue;
    }
}
