package pers.orlando.travelmoneysavingguide.transportationtool;

public abstract class TransportationTool {
    public static final double MAX_WEIGHT = 0x00ffffff;

    public String name;
    private String id;
    public double consumeTime;//时间--min
    public double price;//价格

    public TransportationTool(String id, String name,double consumeTime, double price) {
        this.consumeTime = consumeTime;
        this.price = price;
        this.id = id;
        this.name = name;
    }

    public TransportationTool() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(double consumeTime) {
        this.consumeTime = consumeTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("交通工具：").append(name).append('\t');
        if (name.equals("飞机")) stringBuilder.append("航班：").append(id).append('\t');
        else stringBuilder.append("车次：").append(id).append('\t');
        stringBuilder.append("时长：").append(consumeTime).append("min\t");
        stringBuilder.append("价格：").append(price).append("¥\t");
        return stringBuilder.toString();
    }
}
