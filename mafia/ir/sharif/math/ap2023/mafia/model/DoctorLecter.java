package ir.sharif.math.ap2023.mafia.model;

public class DoctorLecter extends Mafia {
    public DoctorLecter(String name, int id) {
        super(name, id);
    }

    @Override
    public String action(Player target) {
        target.setHealedByDoctorLecter(true);
        return "";
    }

}