package cl.tbd.back.models;

public class VolunteeSkill {

    private int id;
    private int id_voluntee;
    private int id_skill;

    public int getId() {
        return id;
    }

    public int getId_voluntee() {
        return id_voluntee;
    }

    public void setId_voluntee(int id_voluntee) {
        this.id_voluntee = id_voluntee;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }
}
