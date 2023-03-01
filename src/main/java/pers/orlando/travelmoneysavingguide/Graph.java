package pers.orlando.travelmoneysavingguide;

/**
 * Date: 2023/2/27
 * Author: liujiacheng
 */

public interface Graph<T> {

    /**
     * @return 顶点数
     */
    int vertexCount();

    /**
     * @param i 顶点
     * @return 顶点vi元素
     */
    T get(int i);

    /**
     * 设置顶点vi元素为x
     *
     * @param i 顶点
     * @param x 值
     */
    void set(int i, T x);

    /**
     * 插入元素值为x的顶点
     *
     * @param x 被插入值
     * @return 顶点序号
     */
    int insert(T x);

    /**
     * 插入边〈vi,vj〉，权值为w
     *
     * @param i 顶点
     * @param j 顶点
     * @param w 权值
     */
    void insert(int i, int j, int w);

    /**
     * 删除顶点vi及其关联的边
     *
     * @param i 被删除顶点
     * @return 被删除顶点
     */
    T remove(int i);

    /**
     * 删除边〈vi,vj〉
     *
     * @param i 顶点
     * @param j 顶点
     */
    void remove(int i, int j);

    /**
     * 查找并返回首个与key相等元素的顶点序号
     *
     * @param key 被查找元素
     * @return 顶点序号
     */
    int search(T key);

    /**
     * 查找并删除首个与key相等元素顶点及其关联的边
     *
     * @param key 被查找元素
     * @return 被删除的元素
     */
    T remove(T key);

    /**
     * 返回〈vi,vj〉边的权值
     *
     * @param i 顶点
     * @param j 顶点
     * @return 权值
     */
    int weight(int i, int j);

    /**
     * 图的深度优先遍历，从顶点vi出发
     *
     * @param i 顶点
     */
    void DFSTraverse(int i);

    /**
     * 图的广度优先遍历，从顶点vi出发
     *
     * @param i 顶点
     */
    void BFSTraverse(int i);

    /**
     * 构造带权无向图的最小生成树，Prim算法
     */
    void minSpanTree();

    /**
     * 求带权图顶点vi的单源最短路径，Dijkstra算法
     *
     * @param i 顶点
     */
    void shortestPath(int i);

    /**
     * 求带权图每对顶点间的最短路径及长度，Floyd算法
     */
    void shortestPath();
}
