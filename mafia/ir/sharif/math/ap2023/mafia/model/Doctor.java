package ir.sharif.math.ap2023.mafia.model;

public class Doctor extends Citizen  {
    int numberOfSelfSave;

    public Doctor(String name, int id) {
        super(name, id);
        this.setNumberOfSelfSave(2);
    }

    public String action(Player target) {
        if (!(target instanceof Doctor)) {
            target.setHeal(true);
            return "";
        }
        else if (((Doctor) target).getNumberOfSelfSave() > 0) {
            target.setHeal(true);
            useSelfHeal();
            return "";
        }
        return "NO_SAVE";
    }

    public void useSelfHeal() {
        this.numberOfSelfSave = this.getNumberOfSelfSave() - 1;
    }

    public int getNumberOfSelfSave() {
        return numberOfSelfSave;
    }

    public void setNumberOfSelfSave(int numberOfSelfSave) {
        this.numberOfSelfSave = numberOfSelfSave;
    }
}