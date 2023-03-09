package ir.sharif.math.ap2023.mafia;

import ir.sharif.math.ap2023.mafia.logic.GameState;
import ir.sharif.math.ap2023.mafia.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("doctor", 1);
        Detective detective = new Detective("detective", 2);
        GodFather godFather = new GodFather("father", 3);
        OrdinaryCitizen citizen = new OrdinaryCitizen("citizen", 6);

        List<Player> players = new ArrayList<>();
        players.add(doctor);
        players.add(godFather);
        players.add(detective);
        players.add(citizen);

        GameState gameState = new GameState(players);

        gameState.nextNight();
        System.out.println(detective.action(godFather)); // NO_MAFIA
        doctor.action(detective);
        godFather.action(detective);

        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 4
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 0
        System.out.println(godFather.isAsked()); // true
        System.out.println(doctor.getNumberOfSelfSave()); // 2

        doctor.vote(citizen);
        godFather.vote(detective);
        detective.vote(doctor);
        citizen.vote(godFather);

        gameState.nextNight();
        System.out.println(gameState.getExecutedPlayer()); // null
        godFather.action(citizen);
        doctor.action(doctor);
        System.out.println(detective.action(godFather)); // MAFIA

        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 3
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 1
        System.out.println(gameState.getDeadPlayersInLastRound().contains(citizen)); // true
        System.out.println(doctor.getNumberOfSelfSave()); // 1

        detective.vote(godFather);
        doctor.vote(godFather);
        godFather.vote(detective);

        gameState.nextNight();
        System.out.println(godFather.isAlive()); // false
        System.out.println(gameState.getExecutedPlayer() == godFather); // true
        System.out.println(gameState.getWinners().size()); // 3
        System.out.println(gameState.getWinners().contains(doctor)); // true
        System.out.println(gameState.getWinners().contains(detective)); // true
        System.out.println(gameState.getWinners().contains(citizen)); // true
    }
}
