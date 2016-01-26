import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ZustandZaehlerTest {

  private static class ZustandVergleichsDummy implements
      Zustand {

    private ZustandVergleichsDummy() {
    }

    @Override
    public Zustand aendern(
                           List<Zustand> nachbarZustände) {
      return null;
    }

    @Override
    public boolean equals(Object other) {
      return other == this;
    }
  }

  @Test
  public void zaehleIn__gemischt__4() {
    Zustand zustand = new ZustandVergleichsDummy();
    Zustand andererZustand = new ZustandVergleichsDummy();

    ZustandZaehler zustandZaehler = new ZustandZaehler();
    int anzahl = zustandZaehler.zaehleIn(Arrays.asList(
        zustand, zustand, zustand, zustand, andererZustand,
        andererZustand, andererZustand), zustand);
    assertEquals("Anzahl", 4, anzahl);

  }

  @Test
  public void zaehleIn__nichtZaehlbare__0() {
    Zustand zustand = new ZustandVergleichsDummy();
    Zustand andererZustand = new ZustandVergleichsDummy();

    ZustandZaehler zustandZaehler = new ZustandZaehler();
    int anzahl = zustandZaehler.zaehleIn(Arrays.asList(
        andererZustand, andererZustand, andererZustand),
        zustand);
    assertEquals("Anzahl", 0, anzahl);

  }

  @Test
  public void zaehleIn__zaehlbare__0() {
    Zustand zustand = new ZustandVergleichsDummy();

    ZustandZaehler zustandZaehler = new ZustandZaehler();
    int anzahl = zustandZaehler.zaehleIn(Arrays.asList(
        zustand, zustand, zustand), zustand);
    assertEquals("Anzahl", 3, anzahl);

  }

}
