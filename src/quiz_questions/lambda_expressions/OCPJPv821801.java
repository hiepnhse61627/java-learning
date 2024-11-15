package quiz_questions.lambda_expressions;

import java.util.Arrays;
import java.util.List;

public class OCPJPv821801 {

  public static void main(String[] args) {
    List<StringBuilder> messages = Arrays.asList(new StringBuilder(), new StringBuilder());
    messages.stream().forEach(s -> s.append("Hello World"));
    messages.forEach(s -> {
      s.insert(5, ",");
      System.out.println(s);
    });
  }
}
