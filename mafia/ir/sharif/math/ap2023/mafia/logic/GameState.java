package ir.sharif.math.ap2023.mafia.logic;

import ir.sharif.math.ap2023.mafia.model.*;

import java.util.*;

public class GameState {
    Player executedPlayerInLastRound = null;
    Player joker;
    int round;
    boolean day;
    List<Player> players = new ArrayList<>();
    List<Player> deadPlayersInLastRound = new ArrayList<>();
    List<Player> winnersList = new ArrayList<>();
    List<Player> mafiaList = new ArrayList<>();
    List<Player> citizenList = new ArrayList<>();

    public GameState(List<Player> players) {
        this.players = players;
        setRound(0);
        setDay(true);
        roleClassification();
    }

    public void nextDay() {
        killedByMafiaAtNight();
        killedBySniperAtNight();
        hasAnyoneWon();
        increaseRoundNumber();
        setDefaultsForDay();
    }

    public void nextNight() {
        executedAtDay();
        hasAnyoneWon();
        setDefaultsForNight();
    }

    private void roleClassification() {
        for (Player player : players) {
            if (player instanceof Joker) {
                this.joker = player;
            }
            else if (player instanceof Mafia) {
                mafiaList.add(player);
            }
            else {
                citizenList.add(player);
            }
        }
    }

    public List<Player> allPlayers() {
        return players;
    }


    private void setDefaultsForDay() {
        setDay(true);
        executedPlayerInLastRound = null;

        for (Player player : players) {
            player.setOrdinaryMafiaVote(0);
        }
        for (Player player : players) {
            player.setVote(0);
        }
    }


    private void setDefaultsForNight() {
        setDay(false);
        deadPlayersInLastRound = new ArrayList<>();

        for (Player player : players) {
            player.setMute(false);
            player.setOrdinaryMafiaVote(0);
            player.setChosenByGodfather(false);
            player.setShootBySniper(false);
            player.setHeal(false);
            player.setHealedByDoctorLecter(false);
        }
    }


    public int getRound() {
        return this.round;
    }


    public List<Player> getAlivePlayers() {
        List<Player> alivePlayersList = new ArrayList<>();

        for (Player player : players) {
            if (player.isAlive()) {
                alivePlayersList.add(player);
            }
        }
        return alivePlayersList;
    }


    public boolean isDay() {
        return day;
    }

    public List<Player> getDeadPlayersInLastRound() {
        return deadPlayersInLastRound;
    }

    public Player getSilentPlayerInLastRound() {
        List<Player> alivePlayers = getAlivePlayers();

        for (Player player : alivePlayers) {
            if (player.isMute()) {
                return player;
            }
        }
        return null;
    }


    // شششصصصصصصص
    // بووووووس سایناجاااان
    //پری جاااااان :*********


    public List<Player> getWinners() {
        return winnersList;
    }


    public Player getExecutedPlayer() {
        return executedPlayerInLastRound;
    }


    public void setDay(boolean day) {
        this.day = day;
    }


    public void killedByMafiaAtNight() {
        List<Player> alivePlayers = getAlivePlayers();

        for (Player player : alivePlayers) {
            if (player instanceof GodFather) {
                for (Player target : alivePlayers) {
                    if (target.isChosenByGodfather() && !target.isHeal()) {
                        target.setAlive(false);
                        deadPlayersInLastRound.add(target);
                        break;
                    }
                }
            } else {
                int maxVotes = 0;
                Player shouldBKilled = null;
                for (Player target : alivePlayers) {
                    if (target.getOrdinaryMafiaVote() > maxVotes) {
                        maxVotes = target.getOrdinaryMafiaVote();
                        shouldBKilled = target;
                    }
                }
                if (shouldBKilled != null && !shouldBKilled.isHeal()) {
                    shouldBKilled.setAlive(false);
                    deadPlayersInLastRound.add(shouldBKilled);
                    break;
                }
            }
        }
    }

    public void killedBySniperAtNight() {
        List<Player> alivePlayers = getAlivePlayers();

        for (Player player : alivePlayers) {
            if (player.isShootBySniper() && !player.isHealedByDoctorLecter()) {
                player.setAlive(false);
                deadPlayersInLastRound.add(player);
                break;
            }
        }
    }

    public void executedAtDay() {
        List<Player> alivePlayers = getAlivePlayers();

        for (Player player : alivePlayers) {
            if (player.getVote() > alivePlayers.size()/2 ) {
                player.setAlive(false);
                executedPlayerInLastRound = player;
            }
        }
    }

    public void increaseRoundNumber() {
        setRound(getRound() + 1);
    }

    public void hasAnyoneWon() {
        if (executedPlayerInLastRound instanceof Joker) {
            winnersList.add(joker);
        }

        else {
            int numberOfAliveMafias = 0;
            int numberOfAliveCitizens = 0;
            int aliveJoker = 1;
            for (Player player : players) {
                if (player instanceof Mafia && player.isAlive()) {
                    numberOfAliveMafias += 1;
                }
                else if (player instanceof Citizen && player.isAlive()) {
                    numberOfAliveCitizens += 1;
                }
                else if (player instanceof Joker && !player.isAlive()) {
                    aliveJoker -= 1;
                }
            }

            if (numberOfAliveMafias >= numberOfAliveCitizens + aliveJoker) {
                winnersList = mafiaList;
            }

            else if (numberOfAliveMafias == 0) {
                winnersList = citizenList;
            }

        }
    }

    public Player getExecutedPlayerInLastRound() {
        return executedPlayerInLastRound;
    }

    public void setExecutedPlayerInLastRound(Player executedPlayerInLastRound) {
        this.executedPlayerInLastRound = executedPlayerInLastRound;
    }

    public Player getJoker() {
        return joker;
    }

    public void setJoker(Player joker) {
        this.joker = joker;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setDeadPlayersInLastRound(List<Player> deadPlayersInLastRound) {
        this.deadPlayersInLastRound = deadPlayersInLastRound;
    }

    public List<Player> getWinnersList() {
        return winnersList;
    }

    public void setWinnersList(List<Player> winnersList) {
        this.winnersList = winnersList;
    }

    public List<Player> getMafiaList() {
        return mafiaList;
    }

    public void setMafiaList(List<Player> mafiaList) {
        this.mafiaList = mafiaList;
    }

    public List<Player> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Player> citizenList) {
        this.citizenList = citizenList;
    }
}
