public class InsufficientBalanceException extends Exception {

  private String message;

  public InsufficientBalanceException(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

  public String getMessage() {
    return message;
  }
}
