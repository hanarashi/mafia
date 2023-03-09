package ir.sharif.math.ap2023.mafia.model;

public abstract class Player {
    protected int id;
    protected String name;
    protected boolean alive;
    protected boolean mute;
    protected int vote;
    protected int ordinaryMafiaVote;
    protected boolean isChosenByGodfather;
    protected boolean isShootBySniper;
    protected boolean isHealedByDoctorLecter;
    protected boolean heal; //healed by doctor


    public Player(String name, int id) {
        this.id = id;
        this.name = name;
        this.setAlive(true);
    }

    public abstract String action(Player target);

    public void vote(Player target) {
        target.setVote(target.getVote() + 1);
    }

    public void addOneOrdinaryMafiaVote() {
        this.setOrdinaryMafiaVote(this.getOrdinaryMafiaVote() + 1);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getOrdinaryMafiaVote() {
        return ordinaryMafiaVote;
    }

    public void setOrdinaryMafiaVote(int ordinaryMafiaVote) {
        this.ordinaryMafiaVote = ordinaryMafiaVote;
    }

    public boolean isChosenByGodfather() {
        return isChosenByGodfather;
    }

    public void setChosenByGodfather(boolean chosenByGodfather) {
        isChosenByGodfather = chosenByGodfather;
    }

    public boolean isShootBySniper() {
        return isShootBySniper;
    }

    public void setShootBySniper(boolean shootBySniper) {
        isShootBySniper = shootBySniper;
    }

    public boolean isHealedByDoctorLecter() {
        return isHealedByDoctorLecter;
    }

    public void setHealedByDoctorLecter(boolean healedByDoctorLecter) {
        isHealedByDoctorLecter = healedByDoctorLecter;
    }

    public boolean isHeal() {
        return heal;
    }

    public void setHeal(boolean heal) {
        this.heal = heal;
    }
}