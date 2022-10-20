package cl.tbd.back.models;

public class EmergencySkill {

    private int id;
    private int id_emergency;
    private int id_skill;

    public int getId() {
        return id;
    }

    public int getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(int id_emergency) {
        this.id_emergency = id_emergency;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }
}
