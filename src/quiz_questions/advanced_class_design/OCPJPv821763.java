package quiz_questions.advanced_class_design;

abstract class Switch {

  protected abstract void switchON();

  protected abstract void switchOFF();
}

class SimpleSwitch extends Switch {

  public final void switchON() {
    System.out.println("Switch ON");
  }

  public final void switchOFF() {
    System.out.println("Switch OFF");
  }
}

class Fan {

  Switch sw = new SimpleSwitch();

  public void test() {
    sw.switchON();
    sw.switchOFF();
  }
}

public class OCPJPv821763 {

  public static void main(String[] args) {
    Fan fan = new Fan();
    fan.test();
  }
}
