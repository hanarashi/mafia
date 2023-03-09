package ir.sharif.math.ap2023.mafia.model;

public class Sniper extends Citizen {
    int numberOfBulletsLeft;

    public Sniper(String name, int id) {
        super(name, id);
        setNumberOfBulletsLeft(2);
    }

    @Override
    public String action(Player target) {
        if (this.getNumberOfBulletsLeft() > 0) {
            target.setShootBySniper(true);
            useBullet();
            return "";
        }
        else {
            return "NO_BULLETS";
        }
    }

    public void useBullet() {
        this.setNumberOfBulletsLeft(this.getNumberOfBulletsLeft() - 1);
    }


    public int getNumberOfBulletsLeft() {
        return numberOfBulletsLeft;
    }

    public void setNumberOfBulletsLeft(int numberOfBulletsLeft) {
        this.numberOfBulletsLeft = numberOfBulletsLeft;
    }
}