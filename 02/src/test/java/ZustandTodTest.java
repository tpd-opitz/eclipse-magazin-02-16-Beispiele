import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ZustandTodTest {

  private ZustandZaehler zustandZaehler = mock(
      ZustandZaehler.class);

  @SuppressWarnings("unchecked")
  @Test
  public void
         aendern__2lebendeNachbarn__tod() {
    List<Zustand> beliebigeZustaende = Collections
        .emptyList();
    when(zustandZaehler.zaehleIn(anyList(), any(
        Zustand.class))).thenReturn(2);

    Zustand zustand = erzeugeTestObject();
    Zustand neuerZustand = zustand.aendern(
        beliebigeZustaende);

    assertEquals(zustand, neuerZustand);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void
         aendern__3lebendeNachbarn__lebt() {
    List<Zustand> beliebigeZustaende = Collections
        .emptyList();
    when(zustandZaehler.zaehleIn(anyList(), any(
        Zustand.class))).thenReturn(3);

    Zustand zustand = erzeugeTestObject();
    Zustand neuerZustand = zustand.aendern(
        beliebigeZustaende);

    assertEquals(ZustandsFinder.LEBT, neuerZustand);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void
         aendern__4lebendeNachbarn__tod() {
    List<Zustand> beliebigeZustaende = Collections
        .emptyList();
    when(zustandZaehler.zaehleIn(anyList(), any(
        Zustand.class))).thenReturn(4);

    Zustand zustand = erzeugeTestObject();
    Zustand neuerZustand = zustand.aendern(
        beliebigeZustaende);

    assertEquals(zustand, neuerZustand);
  }

  @Test
  public void
         aendern__beliebigeNachbarZustaende__zaehltLebend() {
    List<Zustand> beliebigeZustaende = Collections
        .emptyList();
    Zustand zustand = erzeugeTestObject();
    zustand.aendern(beliebigeZustaende);

    verify(zustandZaehler).zaehleIn(beliebigeZustaende,
        ZustandsFinder.LEBT);
  }

  private Zustand erzeugeTestObject() {
    Zustand zustand = new ZustandTod(zustandZaehler);
    return zustand;
  }

}
