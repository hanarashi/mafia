package ir.sharif.math.ap2023.mafia.model;

public class Joker extends Player {

    public Joker(String name, int id) {
        super(name, id);

    }
    @Override
    public String action(Player target) {
        return "";
    }

}