package quiz_questions.advanced_class_design;

//public enum EnumA {A, AA, AAA}; // 1

public class OCPJPv821463 { // 2

  public enum EnumB {B, BB, BBB} // 3

  ;
//  public EnumC {C, CC, CCC}; // 4

  public OCPJPv821463() {
    enum EnumD {D, DD, DDD} // 5
    ;
  }

  public void methodX() {
//    public enum EnumE {E, EE, EEE}; // 6
  }

  public static void main(String[] args) {
    enum EnumF {F, FF, FFF} // 8
    ;
  }
}
