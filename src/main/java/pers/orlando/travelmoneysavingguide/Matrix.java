package pers.orlando.travelmoneysavingguide;

import co.SeqList;

import java.util.Objects;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */
public class Matrix {
    private int size;//矩阵大小
    private int count;//矩阵存在的数据数量，行=列=count
    protected SeqList<SeqList<Tripe>> element;
    private static final int MIN_CAPACITY = 16;

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public Matrix(Tripe[][] values) {
        this.count = values.length == values[0].length ? values.length : -1;
        this.size=Math.max(this.count,MIN_CAPACITY);
        this.element=new SeqList<>(this.size);
        for (int i = 0; i < this.count; i++) {
            this.element.insert(new SeqList<>(this.size));
            for (int j = 0; j < this.count; j++) {
                if(Objects.equals(values[i][j].getStart(), values[i][j].getEnd())){
                    values[i][j].setTransportationTool(null);
                    this.element.get(i).insert(j,values[i][j]);
                }
                else this.element.get(i).insert(j,values[i][j]);
            }
        }
    }

    public Tripe get(int i, int j) {
        return this.element.get(i).get(j);
    }

    public void set(int i, int j, Tripe x) {
        this.element.get(i).set(j, x);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.count).append('*').append(this.count).append("矩阵\n");
        for (int i = 0; i < this.count; i++) {
            for (int i1 = 0; i1 < this.count; i1++) {
                stringBuilder.append(this.element.get(i).get(i1)).append("❤️");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
