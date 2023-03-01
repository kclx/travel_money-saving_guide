package pers.orlando.travelmoneysavingguide.transportationtool.impl;

import pers.orlando.travelmoneysavingguide.transportationtool.TransportationTool;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class Airplane extends TransportationTool {
    public static String name = "飞机";

    public Airplane(String id,double consumeTime, double price) {
        super(id,name,consumeTime,price);
    }

    static public TransportationTool createTemp() {
        return new Airplane("NULL",0,0);
    }
}
