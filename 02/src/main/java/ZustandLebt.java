import java.util.List;
import java.util.Random;

final class ZustandLebt
    implements Zustand {

  private static final int id = new Random().nextInt();

  private final ZustandZaehler zustandZaehler;

  ZustandLebt(ZustandZaehler zustandZaehler) {
    super();
    this.zustandZaehler = zustandZaehler;
  }

  @Override
  public Zustand aendern(List<Zustand> nachbarZustaende) {
    int lebendeNachbarn = zustandZaehler.zaehleIn(
        nachbarZustaende, ZustandsFinder.LEBT);
    return (2 == lebendeNachbarn || 3 == lebendeNachbarn)
        ? ZustandsFinder.LEBT : ZustandsFinder.TOD;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id;
  }
  

}