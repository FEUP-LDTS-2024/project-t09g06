package ldts.t09g06.model.instructions;

import ldts.t09g06.model.leaderboard.LeaderboardHandler;
import ldts.t09g06.model.leaderboard.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Instructions {
    private List<String> InstructionsText;
    private String filepath;

    public Instructions(String filepath) {
        this.InstructionsText = readFile(filepath);
    }

    public List<String> readFile(String filepath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filepath));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return lines;
    }

    public List<String> getInstructions() {
        return InstructionsText;
    }

}
