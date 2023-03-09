package ir.sharif.math.ap2023.mafia.model;

public class GodFather extends Mafia {
    boolean asked;

    public GodFather(String name, int id) {
        super(name, id);
        this.asked = false;
    }

    @Override
    public String action(Player target) {
        target.setChosenByGodfather(true);
        return "";
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}