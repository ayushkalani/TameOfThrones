package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import dto.MessageDTO;

public class Utils {

  public static Map<String, String> getKingdoms() {
    final Map<String, String> kingdoms = new HashMap<>();
    kingdoms.put("land", "panda");
    kingdoms.put("water", "octopus");
    kingdoms.put("ice", "mammoth");
    kingdoms.put("air", "owl");
    kingdoms.put("fire", "dragon");
    kingdoms.put("space", "gorilla");
    return kingdoms;
  }


  public List<String> readInput(int n) throws IOException {
    List<String> inputString = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (n > 0) {
      inputString.add(br.readLine().toLowerCase());
      n--;
    }
    return inputString;
  }

  public String[][] cleanInput(List<String> noise) {
    String[][] hold = new String[noise.size()][2];
    int i = 0;
    for (String str : noise) {
      hold[i++] = str.split(",\\s*\"");
    }
    return hold;
  }

  public List<String> getAllies(String[][] index, Map<String, String> kingdoms) {
    List<String> allies = new ArrayList<>();
    for (int i = 0; i < index.length; i++) {
      String emblem = kingdoms.get(index[i][0]);
      if (parseString(index[i][1], emblem)) {
        allies.add(index[i][0]);
      }
    }
    return allies;
  }

  public static boolean parseString(String toParse, String emblem) {
    char[] check = emblem.toCharArray();
    for (char toTest : check) {
      if (toParse.indexOf(toTest) > -1) {
        toParse.replaceFirst(String.valueOf(toTest), "");
      } else {
        return false;
      }
    }
    return true;
  }

//  public static String getRandomMessageText(List<String> messageList) {
//    return (messageList != null) ? messageList.get(ThreadLocalRandom.current().nextInt(
//        messageList.size())) : null;
//  }

  public static List<String> getMessages() {
    List<String> randomMessages = new ArrayList<>();
    randomMessages.add("oaaawaala");
    randomMessages.add("zmzmzmzaztzozh");
    randomMessages.add("Go, risk it all");
    randomMessages.add("Let's swing the sword together");
    randomMessages.add("Die or play the tame of thrones");
    randomMessages.add("Ahoy! Fight for me with men and money");
    randomMessages.add("Drag on Martin!");
    randomMessages.add("When you play the tame of thrones, you win or you die.");
    randomMessages.add("What could we say to the Lord of Death? Game on?");
    randomMessages.add("Turn us away, and we will burn you first");
    randomMessages.add("Death is so terribly final, while life is full of possibilities.");
    return randomMessages;
  }

  /*
   * @Param n - number of random messages to be selected //
   */
  // (listMessages != null) ? listMessages.get(ThreadLocalRandom.current().nextInt(
  // listMessages.size())) : null;}
  public List<MessageDTO> pickRandomMessage(List<MessageDTO> listMessages) {
    Collections.shuffle(listMessages);
    return new ArrayList<>(listMessages);

  }

  public static <T> T pickRandomFromList(List<T> list) {
    return (list != null) ? list.get(ThreadLocalRandom.current().nextInt(list.size())) : null;
  }
}
