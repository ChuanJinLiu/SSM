package model;

import java.util.Date;
import java.util.Objects;

public class Supplier {
    private Integer id;
    private String name;
    private String addr;
    private String type;
    private String remark;
    private Date createTime;

    public Supplier() {
    }

    public Supplier(Integer id, String name, String addr, String type, String remark, Date createTime) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.type = type;
        this.remark = remark;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(addr, supplier.addr) &&
                Objects.equals(type, supplier.type) &&
                Objects.equals(remark, supplier.remark) &&
                Objects.equals(createTime, supplier.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addr, type, remark, createTime);
    }
}
