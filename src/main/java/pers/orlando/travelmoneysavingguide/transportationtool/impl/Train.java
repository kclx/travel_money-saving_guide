package pers.orlando.travelmoneysavingguide.transportationtool.impl;

import pers.orlando.travelmoneysavingguide.transportationtool.TransportationTool;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class Train extends TransportationTool {
    public static String name="火车";

    public Train(String id,double consumeTime, double price) {
        super(id,name,consumeTime,price);
    }

    static public TransportationTool createTemp() {
        return new Train("NULL",0,0);
    }
}
