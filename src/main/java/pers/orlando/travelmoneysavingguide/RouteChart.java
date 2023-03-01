package pers.orlando.travelmoneysavingguide;

import co.SeqList;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class RouteChart {
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
            this.matrix.element.get(this.count).insert(new Tripe(this.citySeqList.get(this.count), this.citySeqList.get(i), 0));
            this.matrix.element.get(i).insert(new Tripe(this.citySeqList.get(i), this.citySeqList.get(this.count), 0));
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

    public void removeCity(String  city) {
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

    public void DFSTraverse(int i) {

    }

    public void BFSTraverse(int i) {

    }

    public void minSpanTree() {

    }

    public void shortestPath(int i) {

    }

    public void shortestPath() {

    }
}
