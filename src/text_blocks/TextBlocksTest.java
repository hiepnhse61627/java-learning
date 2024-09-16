package text_blocks;

public class TextBlocksTest {

  public static void textBlocks() {
    // 1. A text block is a String object (immutable and interned)
    var sName = "Hiep Nguyen";
    var tbName = """
        Hiep Nguyen"""; // no newline embedded at end
    var newSName = new String("Hiep Nguyen");
    System.out.println(sName.equals(tbName)); // true
    System.out.println(sName == tbName); // true
    System.out.println(newSName == sName); // false

    // 2. String methods can be applied to text blocks
    System.out.println(tbName.substring(5)); // Nguyen

    // 3. Text blocks start with """ followed by a line terminator
//    var tb1 = """abc""";
//    var tb2 = """abc
//        """;
    var tb3 = """
        abc
        """;
    System.out.println(tb3); // abc

    // 4. Embedded double quotes are not required in text blocks
    var sQuote = "Hamlet: \"There is nothing either good or bad, "
        + "but thinking makes it so\""; // on one line
    System.out.println(sQuote);

    var tbQuote = """
        Hamlet: "There is nothing either good or bad, but thinking makes it so";
        """;
    System.out.println(tbQuote);

    // 5. Depending on where you place the closing delimiter, determines whether you have a closing "\n"
    var sBookTitle01 = "Java\nMemory\nManagement\n"; // newline at end
    var tbBookTitle01 = """
        Java
        Memory
        Management
        """;
    System.out.println(sBookTitle01);
    System.out.println(123);
    System.out.println(tbBookTitle01);
    System.out.println(123);

    var sBookTitle02 = "Java\nMemory\nManagement"; // no newline at end
    var tbBookTitle02 = """
        Java
        Memory
        Management""";
    System.out.println(sBookTitle02);
    System.out.println(123);
    System.out.println(tbBookTitle02);
    System.out.println(123);
  }

  public static void main(String[] args) {
    textBlocks();
    jsonTraditionalStyle();
    jsonTextBlock();
  }

  public static void jsonTraditionalStyle() {
    var text = "{\n"
        + "  \"name\": \"Hiep Nguyen\",\n"
        + "  \"age\": 25,\n"
        + "  \"address\": \"Main Street\"\n"
        + "}";
    System.out.println(text);
  }

  public static void jsonTextBlock() {
    var text = """
        {
          "name": "Hiep Nguyen",
          "age": 25,
          "address": "Main Street"
        }
        """;
    System.out.println(text);
  }
}
