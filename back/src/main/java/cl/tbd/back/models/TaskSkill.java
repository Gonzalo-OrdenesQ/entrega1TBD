package cl.tbd.back.models;

public class TaskSkill {

    private int id;
    private int id_task;
    private int id_skill;

    public int getId() {
        return id;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }
}
