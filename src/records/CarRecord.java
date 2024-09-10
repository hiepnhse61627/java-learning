package records;

// records are immutable and final by default
// regNumber and owner are known as 'components'
public record CarRecord(String regNumber, String owner) implements I {

//  private final int age; // instance fields must be listed in constructor signature above

  public static final String currentYear = "24";

  // 6. Custom canonical constructor and compact constructor
  // custom canonical constructor
//  public CarRecord(String regNumber, String owner) {
//    if (regNumber.length() <= 4) {
//      throw new IllegalArgumentException("Invalid car registration number");
//    }
//    this.regNumber = regNumber;
//    this.owner = owner;
//  }

  // custom compact constructor
  public CarRecord {
    if (regNumber.length() <= 4) {
      throw new IllegalArgumentException("Invalid car registration number");
    }
  }

  // 7. Non-canonical record constructor must delegate to another constructor
  public CarRecord() {
    this("   ", "");
  }

  public boolean isNewCar() {
    return regNumber().startsWith(currentYear);
  }

  public static CarRecord createBlankCarRecord() {
    return new CarRecord("     ", "");
  }

  @Override
  public String owner() {
    return owner.toUpperCase();
  }

  @Override
  public void writeSomething() {
    System.out.println("Writing car record");
  }
}

// 9. Cannot define a subtype based on a record
// class X extends CarRecord {}

interface I {

  void writeSomething();
}
