package cl.tbd.back.models;

public class Task {

    private int id;
    private String name;
    private String description;
    private int id_emergency;
    private int id_stage_task;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(int id_emergency) {
        this.id_emergency = id_emergency;
    }

    public int getId_stage_task() {
        return id_stage_task;
    }

    public void setId_stage_task(int id_stage_task) {
        this.id_stage_task = id_stage_task;
    }
}
