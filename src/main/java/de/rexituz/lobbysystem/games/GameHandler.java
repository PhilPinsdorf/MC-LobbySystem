package de.rexituz.lobbysystem.games;

import java.util.ArrayList;
import java.util.Collection;

public class GameHandler {
    private static final Collection<LobbyGame> lobbyGames = new ArrayList<>();

    public static void addLobbyGame(LobbyGame game) {
        lobbyGames.add(game);
    }

    public static Collection<LobbyGame> getLobbyGames() {
        return lobbyGames;
    }
}
