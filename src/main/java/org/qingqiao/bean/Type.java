package org.qingqiao.bean;

/**
 * @author hj
 * @data 2023/2/1 16:00
 */
public class Type {
    private Integer tid;
    private String name;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type() {
    }

    public Type(Integer tid, String name) {
        this.tid = tid;
        this.name = name;
    }
}
