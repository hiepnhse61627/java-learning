package com.enthuware.javafund.exercises.chapter03;

import java.util.Arrays;

public class TestClass {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + "playAround01" + "=".repeat(30));
    playAround01();

    System.out.println("=".repeat(30) + "playAround02" + "=".repeat(30));
    playAround02();

    System.out.println("=".repeat(30) + "playAround03" + "=".repeat(30));
    playAround03();

    System.out.println("=".repeat(30) + "arrayExercises" + "=".repeat(30));
    arrayExercises();
  }

  public static void playAround01() {
    int[][][] iaaa = new int[2][][];
    iaaa[0] = new int[3][5];
    iaaa[0][0] = new int[]{1, 2, 3, 4, 5};
    iaaa[0][0][0] = 1;

    for (int i = 0; i < iaaa.length; i++) {
      if (iaaa[i] != null) {
        System.out.println("iaaa[" + i + "] length = " + iaaa[i].length);
        for (int j = 0; j < iaaa[i].length; j++) {
          if (iaaa[i][j] != null) {
            System.out.println(
                "iaaa[" + i + "][" + j + "] contains: " + Arrays.toString(iaaa[i][j]));

            for (int k = 0; k < iaaa[i][j].length; k++) {
              System.out.println(
                  "iaaa[" + i + "][" + j + "][" + k + "] contains: " + iaaa[i][j][k]);

            }
          } else {
            System.out.println("iaaa[" + i + "][" + j + "] is null");
          }
        }
      } else {
        System.out.println("iaaa[" + i + "] is null");
      }
    }
  }

  public static void playAround02() {
    Object[] iaa[] = {{"String is also an object"}, {null}, {new Object(), 10}};

    for (int i = 0; i < iaa.length; i++) {
      System.out.println("iaa[" + i + "] contains an array of length " + iaa.length);
      for (int j = 0; j < iaa[i].length; j++) {
        System.out.println("iaa[" + i + "][" + j + "] contains: " + iaa[i][j]);
      }
    }
  }

  public static void playAround03() {
    Object[] oa = new int[2][3]; // This is valid
    // Object[][] oaa = new int[2][3]; This will not compile
    Object[][] oaa2 = new int[2][3][1];

    System.out.println(Arrays.deepToString(oa));
  }

  public static void arrayExercises() {
    // 1.
    System.out.println("============Exercise 1==============");
    boolean[] booleanArr = new boolean[3];
    System.out.println(Arrays.toString(booleanArr));

    // 2.
    System.out.println("============Exercise 2==============");
    int[] first = new int[3];
    int[] second = {};
    int[] third = null;
    System.out.println("First array length = " + first.length);
    System.out.println("Second array length = " + second.length);
//    System.out.println("Third array length = " + third.length);
    System.out.println("Fist array elements: " + Arrays.toString(first));
    System.out.println("Second array elements: " + Arrays.toString(second));

    // 3.
    System.out.println("============Exercise 3==============");
    char[] charArr = new char[]{'a', 'b', 'c', 'd'};

    charArr[0] = charArr[1];
    charArr[1] = charArr[2];
    charArr[2] = charArr[3];

    System.out.println(Arrays.toString(charArr));

    // 4.
    System.out.println("============Exercise 4==============");
    String[][] strings = {
        {"one"},
        {"one", "two"},
        {"one", "two", "three"},
        {"one", "two", "three", "four"},
    };

    for (int i = 0; i < strings.length; i++) {
      System.out.println("String[" + i + "] length = " + strings[i].length);
    }

    // 5.
    System.out.println("============Exercise 5==============");
    String[][] names = new String[2][3];
    names[0][0] = "Alice";
    names[0][1] = "Bob";
    names[0][2] = "Charlie";
    names[1][0] = "David";
    names[1][1] = "Eve";
    names[1][2] = "Frank";

    // Print each element manually
    System.out.println(names[0][0]);
    System.out.println(names[0][1]);
    System.out.println(names[0][2]);
    System.out.println(names[1][0]);
    System.out.println(names[1][1]);
    System.out.println(names[1][2]);

    // 6.
    System.out.println("============Exercise 6==============");
    String[] names01 = {names[0][0], names[0][1], names[0][2]};
    String[] names02 = {names[1][0], names[1][1], names[1][2]};

    for (String name : names01) {
      System.out.println(name);
    }

    for (String name : names02) {
      System.out.println(name);
    }

    // 7.
    System.out.println("============Exercise 7==============");
    Data d = new Data();
    Data[] data = new Data[]{d, d, d};
    data[1].value = 3;

    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i].value);
    }

    System.out.println(d.value);

    // 8.
    System.out.println("============Exercise 8==============");
    int[][] arr = new int[4][];
    int value = 1;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new int[i + 1];
      for (int j = 0; j <= i; j++) {
        arr[i][j] = value;
        value++;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    // 9.
    System.out.println("============Exercise 9==============");
    int[][] arr2 = new int[4][];
    int value2 = 10;

    for (int i = 0; i < arr2.length; i++) {
      arr2[i] = new int[arr2.length - i];
      for (int j = 0; j < arr2[i].length; j++) {
        arr2[i][j] = value2;
        value2--;
      }
    }

    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        System.out.print(arr2[i][j] + " ");
      }
      System.out.println();
    }

    // 10.
    System.out.println("============Exercise 10==============");
    Object[] objects = new Object[3];
    objects[0] = new int[2];
    objects[1] = new int[2][3];
    objects[2] = new Object[2];

    // 11.
    System.out.println("============Exercise 11==============");
    int[][] nums = new int[1][3];

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        System.out.println(nums[i][j]);
      }
    }

    // 12.
    System.out.println("============Exercise 12==============");
    /*
     * [0][0][0] = 0
     * [0][0][1] = 1
     * [0][1][0] = 1
     * [0][1][1] = 2
     * [0][2][0] = 2
     * [0][2][1] = 3
     * [0][3][0] = 3
     * [0][3][1] = 4
     */
    int[][][] nums2 = new int[1][4][2];
    for (int i = 0; i < nums2.length; i++) {
      for (int j = 0; j < nums2[i].length; j++) {
        for (int k = 0; k < nums2[i][j].length; k++) {
          nums2[i][j][k] = i + j + k;
          System.out.println("nums[" + i + "][" + j + "][" + k + "] = " + nums2[i][j][k]);
        }
      }
    }
  }
}
