package cl.tbd.back.models;

public class Ranking {

    private int id;
    private int id_voluntee;
    private int id_task;
    private int score;

    public int getId() {
        return id;
    }

    public int getId_voluntee() {
        return id_voluntee;
    }

    public void setId_voluntee(int id_voluntee) {
        this.id_voluntee = id_voluntee;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
