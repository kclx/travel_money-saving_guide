package pers.orlando.travelmoneysavingguide;

import co.SeqList;
import org.junit.Before;
import org.junit.Test;
import pers.orlando.travelmoneysavingguide.transportationtool.TransportationTool;
import pers.orlando.travelmoneysavingguide.transportationtool.impl.HighSpeedTrain;
import pers.orlando.travelmoneysavingguide.transportationtool.impl.Train;

import java.util.UUID;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class TestRouteChart {
    private City[] cities;
    private Tripe[] tripes;
    private RouteChart routeChart;
    private Tripe[][] tripess;

    @Before
    public void before() {
        cities = new City[]{City.create("沈阳"), City.create("天津"), City.create("济南"), City.create("南京")};
        Tripe tripe0 = new Tripe("沈阳", "沈阳", 0);
        Train k9281 = new Train("K928", 559, 112);
        Tripe tripe1 = new Tripe("沈阳", "天津", 663, new TransportationTool[]{k9281});
        tripe1.setTransportationTool("高铁", "G2604", 248, 242);
        HighSpeedTrain g2650 = new HighSpeedTrain("G2650", 363, 396);
        Tripe tripe2 = new Tripe("沈阳", "济南", 973, new TransportationTool[]{g2650});
        tripe2.setTransportationTool("火车", "K346", 915, 141);
        tripe2.setTransportationTool("飞机", "SC8444", 115, 649);
        Train k346 = new Train("K346", 1450, 206);
        Tripe tripe3 = new Tripe("沈阳", "南京", 1542, new TransportationTool[]{k346});
        tripe3.setTransportationTool("高铁", "G1222", 504, 704);
        tripe3.setTransportationTool("飞机", "9C8743", 240, 880);

        Tripe[] tripes1 = new Tripe[]{tripe0, tripe1, tripe2, tripe3};

        Train k553 = new Train("K553", 539, 93);
        Tripe tripe4 = new Tripe("天津", "沈阳", 663,new TransportationTool[]{k553});
        tripe4.setTransportationTool("高铁", "G3497", 252, 248);
        Tripe tripe5 = new Tripe("天津", "天津", 0);
        HighSpeedTrain g191 = new HighSpeedTrain("G191", 70, 136);
        Tripe tripe6 = new Tripe("天津", "济南", 327, new TransportationTool[]{g191});
        tripe6.setTransportationTool("火车", "K1449", 368, 53.5);
        Train k187 = new Train("K187", 774, 135.5);
        Tripe tripe7 = new Tripe("天津", "南京", 894, new TransportationTool[]{k187});
        tripe7.setTransportationTool("高铁", "G191", 242, 412);

        Tripe[] tripes2 = new Tripe[]{tripe4, tripe5, tripe6, tripe7};

        Train k348 = new Train("K348", 919, 141.5);
        Tripe tripe8 = new Tripe("济南", "沈阳", 973, new TransportationTool[]{k348});
        tripe8.setTransportationTool("高铁", "G1244", 240, 397);
        tripe8.setTransportationTool("飞机", "SC8443", 110, 963);
        Train k3481 = new Train("K348", 261, 50.5);
        Tripe tripe9 = new Tripe("济南", "天津", 318,new TransportationTool[]{k3481});
        tripe9.setTransportationTool("高铁", "G2604", 94, 141);
        Tripe tripe10 = new Tripe("济南", "济南", 0);
        Train k335 = new Train("K335", 481, 91);
        Tripe tripe11 = new Tripe("济南", "南京", 625,new TransportationTool[]{k335});
        tripe11.setTransportationTool("高铁", "G1213", 163, 290);

        Tripe[] tripes3 = new Tripe[]{tripe8, tripe9, tripe10, tripe11};

        Train k336 = new Train("K336", 1334, 198);
        Tripe tripe12 = new Tripe("南京", "沈阳", 1542,new TransportationTool[]{k336});
        tripe12.setTransportationTool("高铁", "G1232", 506, 698);
        tripe12.setTransportationTool("飞机", "9C8744", 225, 880);
        Train k48 = new Train("K48", 964, 135.5);
        Tripe tripe13 = new Tripe("南京", "天津", 894, new TransportationTool[]{k48});
        tripe13.setTransportationTool("高铁", "G20", 179, 447);
        HighSpeedTrain g192 = new HighSpeedTrain("G192", 153, 290);
        Tripe tripe14 = new Tripe("南京", "济南", 625,new TransportationTool[]{g192});
        tripe14.setTransportationTool("火车", "K48", 717, 91);
        Tripe tripe15 = new Tripe("南京", "南京", 0);

        Tripe[] tripes4 = new Tripe[]{tripe12, tripe13, tripe14, tripe15};

        tripes = new Tripe[]{
                tripe0, tripe1, tripe2, tripe3,
                tripe4, tripe5, tripe6, tripe7,
                tripe8, tripe9, tripe10, tripe11,
                tripe12, tripe13, tripe14, tripe15
        };
        tripess = new Tripe[][]{tripes1, tripes2, tripes3, tripes4};

        SeqList<String> stringSeqList = new SeqList<>(new String[]{"沈阳", "天津", "济南", "南京"});
        routeChart = new RouteChart(stringSeqList, tripess);
    }

    @Test
    public void test01() {
        System.out.println(routeChart.getMatrix());
        System.out.println(routeChart.getCitySeqList());
    }

    @Test
    public void testGet() {
        String  city = routeChart.get(1);
        System.out.println(city);
        Tripe tripe = routeChart.get(2, 2);
        System.out.println(tripe);
    }

    @Test
    public void testSet() {
        routeChart.set("大连");
        System.out.println(routeChart.getCitySeqList());
        Tripe tripe = new Tripe("大连", "沈阳", 392, new Train[]{new Train("K335", 481, 91)});
        tripe.setTransportationTool("高铁", "G1213", 163, 290);
        routeChart.set(tripe);

        routeChart.set("石家庄");
        System.out.println(routeChart.getCitySeqList());
        Tripe tripe1 = new Tripe("石家庄", "沈阳", 400, new Train[]{new Train("K335", 481, 91)});
        tripe.setTransportationTool("高铁", "G1213", 163, 290);
        routeChart.set(tripe1);
        System.out.println(routeChart.getMatrix());
    }

    @Test
    public void removeTripe() {
        routeChart.removeTripe(1, 2);
        System.out.println(routeChart.getMatrix());
        System.out.println(routeChart.getCitySeqList());
    }

    @Test
    public void removeCity() {
        routeChart.removeCity("沈阳");
        routeChart.removeCity("南京");
        System.out.println(routeChart.getMatrix());
        System.out.println(routeChart.getCitySeqList());
        System.out.println(routeChart.cityCount());
    }

    @Test
    public void create() {
        Matrix matrix = new Matrix(tripess);
        System.out.println(matrix);
    }
}
