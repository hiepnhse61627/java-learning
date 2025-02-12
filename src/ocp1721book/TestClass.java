package ocp1721book;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestClass {

  public class Address {

  }

  ;

  public interface Doer {

    void doIt();
  }

  enum State {ON, OFF}

  private record Info(String str, State state) {

  }

  public static void main(String[] args) {

//    int a = 2;
//    int b = 5;
//    int c = b * a * (a++ - --b) * a * b;
//
//    byte d = (byte) a;
//
//    System.out.println(a + " " + b + " " + c);
//    System.out.println(d);
//
//    StringBuilder builder = new StringBuilder("hello");
//    System.out.println("" + builder + " " + builder.append(" ").append("world"));
//
//    Object object = getObject(args.length);
//    if (!(object instanceof String str)) {
//      return;
//    }
//
//    System.out.println("str = " + str);
//
//    Number n = null;
//
//    if (n instanceof Number num) {
//
//    }

//    int m = 50;
//    int n = ++m; // 51
//    System.out.println(n);
//    int o = m--; // 51
//    System.out.println(o);
//    int p = --o+m--; // 49 + 51 = 100
//    System.out.println(p);
//
//    int x = m < n ? n < o ? o < p ? p : o : n : m;
//    System.out.println(x);
//
//    int k = 4;
//    boolean flag = k++ == 5;
//    System.out.println(!flag);
//
//    byte b = 1;
////    b = b << 1;
//    int c = b << 1;
////    byte d += b;
//    byte e = 0;
//    e += b;

//    String s = "a";
//    String[] sa = {"a", s, s.substring(0,1), new String("a"), "" + 'a'};
//    for (int i = 0; i < sa.length; i++) {
//      System.out.println(i);
//      System.out.println(s == sa[i]);
//      System.out.println(s.equals(sa[i]));
//    }

//    String a = "ab";
//    String b = new String("ab");
//
//    System.out.println(a == b);

//    String commonHeader = """
//        \"
//        " \""" """;
//
//    System.out.println("|" + commonHeader + "|");

//    System.out.println("0123".indexOf("2", 1, 3));
//    System.out.println("0123".substring(1, 2));
//    System.out.println("123" + "\u2000".strip());
//    System.out.println(" 123 ".stripLeading());
//    System.out.println(" 123 ".stripTrailing());
//    System.out.println("123" + "\u2000".trim());
//    System.out.println("    abc    ".stripIndent());
//    System.out.println("abc".indent(22));

//    String s1 = "hello";
//    String s2 = s1.indent(1);
//    System.out.println("|"+s2+"|");
//    s2 = s2.strip();
//    System.out.println(s1.equals(s2) + " " + (s1 == s2));
//    String s3 = s2.intern();
//    System.out.println(s1.equals(s3) + " " + (s1 == s3));

//    StringBuilder sb = new StringBuilder("Hello");
//    String sbToString = sb.toString();
//    String sbSubstring = sb.substring(0, 3); // Converts to String implicitly
//    String internedSb = sbSubstring.intern();
//
//    System.out.println("StringBuilder toString() is interned: " + (sbToString == sbToString.intern()));
//    System.out.println("StringBuilder substring() is interned: " + (sbSubstring == sbSubstring.intern()));
//    System.out.println(internedSb == sbSubstring);
//
//    // Test with String
//    String str = "Hello";
//    String strToString = str.toString();
//    String strSubstring = str.substring(0, 3);
//    String internedString = strSubstring.intern();
//
//    System.out.println("String is interned: " + (strToString == str.intern()));
//    System.out.println("String substring() is interned: " + (strSubstring == strSubstring.intern()));
//    System.out.println(internedString == strSubstring);

//    int[] arr = {1 ,2, 3, 4};
//
//    switch (arr.length) {
//      default:
//        System.out.println("Yeah");
//      case 3:
//        System.out.println("No arguments");
//        break;
//      case 1, 2:
//        System.out.println("Only one argument");
//    }


//    int i = 0;
//    switch (args[0]) {
//      default: i = i + 3;
//      case "2": i = i + 2;
//      case "0": break;
//      case "1": i = i + 1;
//    }
//
//    System.out.println(i);

//    int i = 0;
//    switch (i) {
//      case 0:
//        m1();
//      case 1:
//        m1();
//        m1();
//      case 2: {
//        m1();
//        i++;
//      }
//      case 3: {
//        m1();
//      }
//      {
//        --i;
//      }
//      case 4:
//      case 5: throw new RuntimeException();
//    }

    DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

    switch (dayOfWeek) {
      case MONDAY: TUESDAY:
      System.out.println("MON/TUE"); break;
    }

    int value = 'a';
    System.out.println(value);
  }

  static Object getObject(int i) {
    if (i == 0) {
      return "no args";
    } else {
      return i;
    }
  }

  static public void m1() {}
}
