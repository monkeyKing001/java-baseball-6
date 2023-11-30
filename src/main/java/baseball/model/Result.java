package baseball.model;
public enum Result{
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    String result;

    private Result(String result){
      this.result = result;
    }

    public String getName(){
      return this.result;
    }
}
