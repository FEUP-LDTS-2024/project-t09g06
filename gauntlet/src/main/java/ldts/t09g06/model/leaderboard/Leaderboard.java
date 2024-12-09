package ldts.t09g06.model.leaderboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Leaderboard {
    private List<Player> players;
    private List<String> leaderboardText;

    private int currentEntry;
    private LeaderboardHandler leaderboard;
    private String filepath;

    public Leaderboard(List<Player> players, String filepath) {
        this.leaderboard = new LeaderboardHandler(filepath);
        this.players = new ArrayList<>(players != null ? players : Collections.emptyList());

        List<Player> leaderboardPlayers =leaderboard.loadLeaderboard(filepath);

        if(leaderboardPlayers != null) {
            this.players.addAll(leaderboardPlayers);
        }

        this.leaderboardText = Collections.singletonList("Back to Menu");
        this.currentEntry = 0;

    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public List<String> getLeaderboard() {
        return leaderboardText;
    }

    public String getCurrentEntry() {
        return leaderboardText.get(currentEntry);
    }
    public void nextEntry() {
        currentEntry = (currentEntry + 1) % leaderboardText.size();
    }
    public void previousEntry() {
        currentEntry = (currentEntry - 1 + leaderboardText.size()) % leaderboardText.size();
    }
    public int getCurrentEntryIndex() {
        return currentEntry;
    }

    public void addPlayertoLeaderboard(Player player) {
        this.players.add(player);
        this.players.sort(Comparator.comparingInt(Player::getScore).reversed());
        leaderboard.saveLeaderboard(this);
    }
}
