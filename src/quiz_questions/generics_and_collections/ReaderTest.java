package quiz_questions.generics_and_collections;

interface Classic {
  int version = 1;
  void read();
}

class MediaReader implements Classic {
  int version = 2;

  @Override
  public void read() {
    System.out.println(((Classic) this).version);
    System.out.println(Classic.version);
  }
}

public class ReaderTest {

  public static void main(String[] args) {
    MediaReader mediaReader = new MediaReader();
    mediaReader.read();
  }
}
