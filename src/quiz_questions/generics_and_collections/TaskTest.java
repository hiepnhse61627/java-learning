package quiz_questions.generics_and_collections;

class TaskBase {

  int getStatusCode(Object object) throws NullPointerException {
    if (object != null) {
      return 1;
    } else {
      return 0;
    }
  }
}

class ParallelTask extends TaskBase {

  @Override
  int getStatusCode(Object object) throws RuntimeException {
    if (object != null) {
      return 1;
    } else {
      return 0;
    }
  }
}

public class TaskTest {

  public static void main(String[] args) {

  }
}
