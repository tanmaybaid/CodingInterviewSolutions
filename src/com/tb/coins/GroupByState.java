package com.tb.coins;

/**
 * Grouping the Cities based on States
 *
 * @author tanmaybaid
 */
public class GroupByState {
  public static void main(String[] args) {
    String[][] city = {{"Seattle", "WA"}, {"Spokane", "WA"}, {"Apple Valley", "CA"},
        {"Dorchester", "MA"}, {"Bellevue", "WA"}};
    for (int i = 0; i < city.length - 1; i++) {
      System.out.println(city[i][1] + ":" + city[i][0]);
      for (int j = i + 1; j < city.length; j++) {
        if (city[i][1] == city[j][1]) {
          System.out.println(city[j][0]);
        }
      }
    }
  }
}
