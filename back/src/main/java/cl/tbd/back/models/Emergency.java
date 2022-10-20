package cl.tbd.back.models;

public class Emergency {

    private int id;
    private String name;
    private String addr;
    private String description;
    private int id_institution;

    public int getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_institution() {
        return id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }
}
