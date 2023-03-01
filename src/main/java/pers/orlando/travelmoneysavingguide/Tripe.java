package pers.orlando.travelmoneysavingguide;

import pers.orlando.travelmoneysavingguide.transportationtool.TransportationTool;
import pers.orlando.travelmoneysavingguide.transportationtool.impl.*;

import java.util.Arrays;
import java.util.UUID;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class Tripe {
    private String id;//识别码
    private String start;//起点位置
    private String end;//终点位置
    private double distance;//距离
    private TransportationTool[] transportationTool;//交通公交类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start + "-->" + end + '\t' + "距离:" + this.distance + "km\t" +
                "详细信息：" + Arrays.toString(transportationTool);
    }

    public TransportationTool[] getTransportationTool() {
        return transportationTool;
    }
    public void setTransportationTool(TransportationTool[] transportationTools){
        this.transportationTool=transportationTools;
    }
    public void setTransportationTool(String transportationTool, String id, double consumeTime, double price) {
        if (start.equals(end)) {
            return;
        }
        switch (transportationTool) {
            case "火车":
                this.transportationTool[0] = new Train(id,consumeTime, price);
                break;
            case "高铁":
                this.transportationTool[1] = new HighSpeedTrain(id,consumeTime, price);
                break;
            case "飞机":
                this.transportationTool[2] = new Airplane(id,consumeTime, price);
                break;
        }
    }

    public Tripe(String start, String end, double distance, TransportationTool[] transportationTool) {
        this.id = String.valueOf(UUID.randomUUID());
        this.start = start;
        this.end = end;
        this.distance = distance;
        TransportationTool[] tool = new TransportationTool[3];
        for (TransportationTool tool1 : transportationTool) {
            if (tool1 instanceof Airplane) tool[2] = tool1;
            if (tool1 instanceof HighSpeedTrain) tool[1] = tool1;
            if (tool1 instanceof Train) tool[0] = tool1;
        }
        this.transportationTool = tool;
    }

    public Tripe(String start, String end, double distance) {
        this.id = String.valueOf(UUID.randomUUID());
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.transportationTool = new TransportationTool[]{null, null, null};
    }

}
