package ocp1721book.inheritance;

public abstract sealed class FinancialInstrument permits Stock {

}

sealed class Stock extends FinancialInstrument {}

//non-sealed class Bond extends FinancialInstrument permits GovtBond {}

//final sealed class GovtBond extends Bond {}

final class PStock extends Stock {
  int methodA(int a, String b) {return a;};
  int methodA(String a, int b) {return b;}
}
