package model;


import java.util.Objects;

public class Supermarket {
    private Integer id;
    private String name;
    private String manager;
    private String thing;
    private String addr;
    private Integer num;

    public Supermarket() {

    }

    public Supermarket(Integer id, String name, String manager, String thing, String addr, Integer num) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.thing = thing;
        this.addr = addr;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", thing='" + thing + '\'' +
                ", addr='" + addr + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Supermarket that = (Supermarket) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manager, that.manager) &&
                Objects.equals(thing, that.thing) &&
                Objects.equals(addr, that.addr) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manager, thing, addr, num);
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
