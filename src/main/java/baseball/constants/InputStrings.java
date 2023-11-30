package baseball.constants;
public enum InputStrings{
  INPUT_NUMBER("숫자를 입력해주세요 : "),
  INPUT_YES("1"),
  INPUT_NO("2"),
  INPUT_START("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

  private final String text;

  InputStrings(final String text){
    this.text = text;
  }
  public String getText() {
    return text;
  }
}
