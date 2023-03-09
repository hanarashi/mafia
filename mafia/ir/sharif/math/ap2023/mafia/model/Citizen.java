package ir.sharif.math.ap2023.mafia.model;

public abstract class Citizen extends Player {
    //ToDo
    public Citizen(String name, int id) {
        super(name, id);
    }

    @Override
    public String action(Player target) {
        return "";
    }


}