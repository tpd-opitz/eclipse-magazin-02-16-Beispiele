import java.util.List;

public class ZelleMitNachbarn {

  private final String statusString;
  private final List<String> nachbarn;

  public ZelleMitNachbarn(String statusString, List<String> nachbarn) {
    this.statusString = statusString;
    this.nachbarn = nachbarn;
  }

  public String zustand() {
    return statusString;
  }

  public List<String> nachbarn() {
    return nachbarn;
  }

}
