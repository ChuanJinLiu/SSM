package model;

import java.util.Objects;

public class Res {
    private Integer id;
    private String name;
    private String path;
    private String remark;

    public Res() {
    }

    public Res(Integer id, String name, String path, String remark) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.remark = remark;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Res{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Res res = (Res) o;
        return Objects.equals(id, res.id) &&
                Objects.equals(name, res.name) &&
                Objects.equals(path, res.path) &&
                Objects.equals(remark, res.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, path, remark);
    }
}
