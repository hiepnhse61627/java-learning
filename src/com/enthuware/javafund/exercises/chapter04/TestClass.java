package com.enthuware.javafund.exercises.chapter04;

public class TestClass {

  public static void main(String[] args) {
    playAround04(6);
  }

  private static void playAround01() {
    String[] names = {"ally", "bob", "charlie", "david"};

    for (String name : names) {
      int sum = 0;

      for (int i = 0; i < name.length(); i++) {
        char ch = name.charAt(i);
        int letterNumber = ch - 96;
        sum += letterNumber;
      }

      System.out.println("Lucky number for " + name + " is " + sum);
    }
  }

  private static void playAround02() {
    int[][] values = {{1, 2, 3}, {2, 3}, {2}, {4, 5, 6, 7}};

    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[i].length; j++) {
        sum += values[i][j];
      }
    }

    System.out.println("Sum is " + sum);
  }

  private static void playAround03() {
    String[][] groups = {
        {"ally", "bob", "charlie"},
        {"bob", "alice", "boone"},
        {"chad", "dave", "elliot"}
    };

    MY_OUTER_LOOP:
    for (int i = 0; i < groups.length; i++) {
      for (String name : groups[i]) {
        System.out.println("Checking " + name);
        if ("bob".equals(name)) {
          System.out.println("Found bob in Group " + i);
          break MY_OUTER_LOOP;
        }
      }
    }
  }

  private static void playAround04(int h) {
    int x = 1;

    LOOP1:
    do {

      /*
       * x = 1
       * y = 1:
       *   y == x (1 == 1) continue;
       * y = 2:
       *   1 * 1 + 2 * 2 = 5 != 25 (h * h)
       * y = 3:
       *   1 * 1 + 3 * 3 = 10 != 25
       * y = 4:
       *   1 * 1 + 4 * 4 = 17 != 25
       *
       * x = 2
       * y = 1:
       *   2 * 2 + 1 * 1 = 5
       * y = 2:
       *   continue
       * y = 3:
       *   2 * 2 + 3 * 3 = 13 != 25
       * y = 4:
       *   2 * 2 + 4 * 4 = 20 != 25
       * ....
       * Found 3 4
       */
      LOOP2:
      for (int y = 1; y < h; y++) {
        if (y == x) {
          continue;
        }

        if (x * x + y * y == h * h) {
          System.out.println("Found " + x + " " + y);
          break LOOP1;
        }
      }

      x++;
    } while (x < h);
  }
}
