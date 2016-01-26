import java.util.List;

public class ZustandZaehler {

  public ZustandZaehler() {
    super();
  }

  protected int zaehleIn(List<Zustand> nachbarZustände, Zustand zaehlZustand) {
    int lebendeNachbarn = 0;
    for (Zustand zustand : nachbarZustände) {
      if (zaehlZustand.equals( zustand))
        lebendeNachbarn++;
    }
    return lebendeNachbarn;
  }

}