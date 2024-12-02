package ldts.t09g06.model.leaderboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class LeaderboardHandler {
    private String filepath;
    public LeaderboardHandler(String filepath) {
        this.filepath = filepath;
    }
    public List<Player> loadLeaderboard(String filepath)  {
        List<Player> leaderboard = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filepath), UTF_8)){
            String currLine;
            while ((currLine = reader.readLine()) != null) {
                List<String> data = Arrays.asList(currLine.split("\t"));
                if(data.size()==2) {
                    Player currPlayer = new Player(data.get(0), Integer.parseInt(data.get(1)));
                    leaderboard.add(currPlayer);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leaderboard.sort(Comparator.comparingInt(Player::getScore).reversed());
        return leaderboard;
    }

    public void saveLeaderboard(Leaderboard leaderboard) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filepath), UTF_8)) {
            List<Player> players = leaderboard.getPlayers();
            for (Player player : players){
                writer.write(player.getName());
                writer.write("\t");
                writer.write(String.valueOf(player.getScore()));
                writer.write("\t");
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

}
