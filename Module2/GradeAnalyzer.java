import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

  public static void main(String[] args) {
    // Step 1: read scores from file
    // Step 2: calculate statistics
    // Step 3: write and print report
    String filename = "scores.txt";
    ArrayList<Integer> scores = readScores(filename);
    int highest = Integer.MIN_VALUE;
    int lowest = Integer.MAX_VALUE;
    double average = calculateAverage(scores);
    for (int i = 0; i < scores.size(); i++) {
      if (scores.get(i) > highest) {
        highest = scores.get(i);
      }
      if (scores.get(i) < lowest) {
        lowest = scores.get(i);
      }
    }

    writeReport(scores, average, highest, lowest, "report.txt");

  }

  // Returns a list of valid scores read from the file
  public static ArrayList<Integer> readScores(String filename) {
    ArrayList<Integer> scores = new ArrayList<Integer>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String trimmedLine = line.trim();
        if (trimmedLine.isEmpty()) {
          continue;
        }
        try {
          int parsedScore = Integer.parseInt(trimmedLine);
          scores.add(parsedScore);
        } catch (NumberFormatException e) {
          System.out.println("integer could not be parsed: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.out.println("Could not read file: " + e.getMessage());
    }

    return scores;
  }

  // Returns the average of a list of scores, or 0.0 if the list is empty
  public static double calculateAverage(ArrayList<Integer> scores) {
    if (scores.size() == 0) {
      return 0;
    }
    double total = 0;
    for (int i = 0; i < scores.size(); i++) {
      total += scores.get(i);
    }
    return total / scores.size();
  }

  // Writes and prints the report
  public static void writeReport(ArrayList<Integer> scores,
      double avg, int high, int low,
      String outputFile) {

    int countA = 0;
    int countB = 0;
    int countC = 0;
    int countD = 0;
    int countF = 0;
    for (int i = 0; i < scores.size(); i++) {
      int currScore = scores.get(i);
      if (currScore >= 90) {
        countA++;
      } else if (currScore >= 80) {
        countB++;
      } else if (currScore >= 70) {
        countC++;
      } else if (currScore >= 60) {
        countD++;
      } else {
        countF++;
      }
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
      if (scores.size() == 0) {
        String emptyOutput = "No report generated since no scores were processed";
        writer.write(emptyOutput);
        System.out.println(emptyOutput);
        writer.newLine();
        return;
      }
      String headerString = String.format("=== Grade Analysis Report ===%nTotal Scores Processed: %d", scores.size());
      writer.write(headerString);
      System.out.println(headerString);
      writer.newLine();

      String statString = String.format("Average Score: %.2f%nHighest Score: %d%nLowest Score:  %d", avg, high, low);
      writer.write(statString);
      System.out.println(statString);
      writer.newLine();

      String gradesString = String.format(
          "Grade Distribution:%n A (90-100):   %d%n B (80-89):    %d%n C (70-79):    %d%n D (60-69):    %d%n F (below 60): %d",
          countA, countB, countC, countD, countF);
      writer.write(gradesString);
      System.out.println(gradesString);

      writer.newLine();
    } catch (IOException e) {
      System.out.println("Could not write file: " + e.getMessage());
    }
  }
}
