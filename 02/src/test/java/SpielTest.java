import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SpielTest {
  FeldGeometrie feldGeometrie = mock(FeldGeometrie.class);
  ZustandsFinder zustandsFinder = mock(
      ZustandsFinder.class);

  @Test
  public void
         neueGeneration__beliebigesSpielfeld__IteratorAnfordern() {
    String zellenMap = "Kartendefinition als String";

    Spiel spiel = new Spiel(feldGeometrie, zustandsFinder);
    spiel.neueGeneration(zellenMap);

    verify(feldGeometrie).zellen();
  }

  @Test
  public void
         neueGeneration__beliebigesSpielfeld__KarteUebergeben() {
    String zellenMap = "Kartendefinition als String";

    Spiel spiel = new Spiel(feldGeometrie, zustandsFinder);
    spiel.neueGeneration(zellenMap);

    verify(feldGeometrie).setzeKarte(zellenMap);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void
         neueGeneration__eineZelle__ZustaendeErmittelln() {
    String zellenMap = "Kartendefinition als String";
    ZelleMitNachbarn zelleMinNachbarn = mock(
        ZelleMitNachbarn.class);
    Iterable<ZelleMitNachbarn> leeresSpielfeld = Arrays
        .asList(zelleMinNachbarn);
    String zustandString = "einGueltiger Zustand";
    Zustand zustand = mock(Zustand.class);
    when(feldGeometrie.zellen()).thenReturn(
        leeresSpielfeld);
    when(zelleMinNachbarn.zustand()).thenReturn(
        zustandString);
    when(zelleMinNachbarn.nachbarn()).thenReturn(Arrays
        .asList("Nachbar 1", "Nachbar 2", "Nachbar 3"));
    when(zustandsFinder.find(anyString())).thenReturn(
        zustand);
    when(zustand.aendern((List<Zustand>) any(List.class)))
        .thenReturn(zustand);

    Spiel spiel = new Spiel(feldGeometrie, zustandsFinder);
    spiel.neueGeneration(zellenMap);

    verify(zustandsFinder).find(zustandString);
    verify(zustandsFinder).find("Nachbar 1");
    verify(zustandsFinder).find("Nachbar 2");
    verify(zustandsFinder).find("Nachbar 3");
  }

  @Before
  public void setup() {
    Iterable<ZelleMitNachbarn> leeresSpielfeld = Collections
        .emptyList();
    when(feldGeometrie.zellen()).thenReturn(
        leeresSpielfeld);
  }

}
