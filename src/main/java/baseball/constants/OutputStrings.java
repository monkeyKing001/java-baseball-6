package baseball.constants;

public enum OutputStrings{

  START_MESSAGE("숫자 야구 게임을 시작합니다."),
  BALL("볼"),
  STRIKE("스트라이크"),
  END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  private final String text;

  OutputStrings(final String text){
    this.text = text;
  }
  public String getText() {
    return text;
  }
}
