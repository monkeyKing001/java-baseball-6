package baseball.constants;
public enum Integers{
  STRIKE_ZONE_MIN(1),
  STRIKE_ZONE_NUMBER(3),
  YES(1),
  NO(2),
  STRIKE_ZONE_MAX(9);

  private final int number;

  Integers(final int number){
    this.number = number;
  }
  public int getNumber() {
    return number;
  }
}
