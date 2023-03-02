package pers.orlando.travelmoneysavingguide;

import co.SeqList;
import pers.orlando.travelmoneysavingguide.transportationtool.TransportationTool;

import java.util.Arrays;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class RouteChart {
    public static double MaxValue = 0x00ffffff;
    private final Matrix matrix;
    private final SeqList<String> citySeqList;
    private int count;

    public Matrix getMatrix() {
        return matrix;
    }

    public SeqList<String> getCitySeqList() {
        return citySeqList;
    }

    public RouteChart(SeqList<String> citySeqList, Tripe[][] tripess) {
        this.matrix = new Matrix(tripess);
        this.citySeqList = citySeqList;
        this.count = citySeqList.size();
    }

    public int cityCount() {
        return this.citySeqList.size();
    }

    public String get(int i) {
        return citySeqList.get(i);
    }

    public Tripe get(int i, int j) {
        return matrix.get(i, j);
    }

    public void set(String city) {
        this.citySeqList.insert(city);
        this.matrix.element.insert(new SeqList<>(this.matrix.getSize()));
        for (int i = 0; i <= this.count; i++) {
            this.matrix.element.get(this.count).insert(new Tripe(this.citySeqList.get(this.count), this.citySeqList.get(i), MaxValue));
            this.matrix.element.get(i).insert(new Tripe(this.citySeqList.get(i), this.citySeqList.get(this.count), MaxValue));
        }
        this.count++;
        this.matrix.setCount(this.count);
    }

    public void setCityDistance(String go, String to, double distance) {
        int i = -1, j = -1;
        for (int k = 0; k < this.citySeqList.size(); k++) {
            i = this.citySeqList.get(k).equals(go) ? k : -1;
            j = this.citySeqList.get(k).equals(to) ? k : -1;
        }
        if (i != -1 && j != -1) {
            this.matrix.element.get(i).get(j).setDistance(distance);
        }
    }

    public void set(Tripe tripe) {
        int i = -1, j = -1;
        for (int k = 0; k < this.citySeqList.size(); k++) {
            if (this.citySeqList.get(k).equals(tripe.getStart())) {
                i = k;
            }
            if (this.citySeqList.get(k).equals(tripe.getEnd())) {
                j = k;
            }
        }
        if (i != -1 && j != -1) {
            this.matrix.element.get(i).set(j, tripe);
        }
    }

    public void removeTripe(int go, int to) {
        Tripe tripe = get(go, to);
        this.matrix.set(go, to, new Tripe(tripe.getStart(), tripe.getEnd(), tripe.getDistance()));
    }

    public void removeCity(String city) {
        int x = -1;
        for (int i = 0; i < this.citySeqList.size(); i++) {
            if (city.equals(this.citySeqList.get(i))) {
                for (int j = 0; j < this.count; j++) {
                    this.matrix.element.get(j).remove(i);
                }
                this.matrix.element.remove(i);
                this.citySeqList.remove(city);
                this.matrix.setCount(--this.count);
                break;
            }
        }
    }

    public double getDistance(String start, String end) {
        int x = -1, y = -1;
        for (int i = 0; i < this.count; i++) {
            if (this.citySeqList.get(i).equals(start)) {
                x = i;
            }
            if (this.citySeqList.get(i).equals(end)) {
                y = i;
            }
        }
        if (x != -1 && y != -1) return this.matrix.get(x, y).getDistance();
        return 0;
    }

    public double getDistance(int start, int end) {
        return this.matrix.get(start, end).getDistance();
    }

    public void DFSTraverse(int i) {

    }

    public void BFSTraverse(int i) {

    }

    public void minSpanTree() {

    }

    public double shorForDistancePath(String city, String to) {
        int source = -1;
        int end = -1;
        for (int i = 0; i < this.count; i++) {
            if (city.equals(this.citySeqList.get(i))) {
                source = i;
            }
            if (to.equals(this.citySeqList.get(i))) {
                end = i;
            }
        }
        if (source == -1 && end == -1) return -1;
        //最短路径长度
        double[] shortest = new double[this.count];
        //判断该点的最短路径是否求出
        int[] visited = new int[this.count];
        //存储输出路径
        String[] path = new String[this.count];

        //初始化输出路径
        for (int i = 0; i < this.count; i++) {
            path[i] = source + "->" + i;
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < this.count; i++) {
            double min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < this.count; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix.get(source, j).getDistance() < min) {
                    min = matrix.get(source, j).getDistance();
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < this.count; m++) {
                if (visited[m] == 0 && matrix.get(source, index).getDistance() + matrix.get(index, m).getDistance() < matrix.get(source, m).getDistance()) {
                    matrix.get(index, m).setDistance(matrix.get(source, index).getDistance() + matrix.get(index, m).getDistance());
                    path[m] = path[index] + "->" + m;
                }
            }
        }
        System.out.println(city+"->"+to);
        return shortest[end];
    }
    public double shorForMoneyPath(String city, String to) {
        int source = -1;
        int end = -1;
        for (int i = 0; i < this.count; i++) {
            if (city.equals(this.citySeqList.get(i))) {
                source = i;
            }
            if (to.equals(this.citySeqList.get(i))) {
                end = i;
            }
        }
        if (source == -1 && end == -1) return -1;
        //最短路径长度
        double[] shortest = new double[this.count];
        //判断该点的最短路径是否求出
        int[] visited = new int[this.count];
        //存储输出路径
        String[] path = new String[this.count];

        //初始化输出路径
        for (int i = 0; i < this.count; i++) {
            path[i] = source + "->" + i;
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < this.count; i++) {
            double min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < this.count; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix.get(source, j).getTransportationTool()[0].price < min) {
                    min = matrix.get(source, j).getTransportationTool()[0].price;
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < this.count; m++) {
                if (visited[m] == 0 && matrix.get(source, index).getTransportationTool()[0].price + matrix.get(index, m).getTransportationTool()[0].price < matrix.get(source, m).getTransportationTool()[0].price) {
                    matrix.get(index, m).getTransportationTool()[0].setPrice(matrix.get(source, index).getTransportationTool()[0].price + matrix.get(index, m).getTransportationTool()[0].price);
                    path[m] = path[index] + "->" + m;
                }
            }
        }
        System.out.println(city+"->"+to);
        return shortest[end];
    }

    @Deprecated
    public double shorForTimePath(String city, String to) {
        int source = -1;
        int end = -1;
        for (int i = 0; i < this.count; i++) {
            if (city.equals(this.citySeqList.get(i))) {
                source = i;
            }
            if (to.equals(this.citySeqList.get(i))) {
                end = i;
            }
        }
        if (source == -1 && end == -1) return -1;
        //最短路径长度
        double[] shortest = new double[this.count];
        //判断该点的最短路径是否求出
        int[] visited = new int[this.count];
        //存储输出路径
        String[] path = new String[this.count];

        //初始化输出路径
        for (int i = 0; i < this.count; i++) {
            path[i] = source + "->" + i;
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < this.count; i++) {
            double min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < this.count; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix.get(source, j).getTransportationTool()[0].consumeTime < min) {
                    min = matrix.get(source, j).getTransportationTool()[0].consumeTime;
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < this.count; m++) {
                if (visited[m] == 0 && matrix.get(source, index).getTransportationTool()[0].consumeTime + matrix.get(index, m).getTransportationTool()[0].consumeTime < matrix.get(source, m).getTransportationTool()[0].consumeTime) {
                    matrix.get(index, m).getTransportationTool()[0].setConsumeTime(matrix.get(source, index).getTransportationTool()[0].consumeTime + matrix.get(index, m).getTransportationTool()[0].consumeTime);
                    path[m] = path[index] + "->" + m;
                }
            }
        }
        System.out.println(city+"->"+to);
        return shortest[end];
    }
}