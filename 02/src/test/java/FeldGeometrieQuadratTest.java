import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class FeldGeometrieQuadratTest {

  @Test
  public void
         aendereAktuellesFeld__erstesFeld__einzelnesFeld() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();
    feldGeometrie.setzeKarte("12345\n67890\n"
        + "abcde\nfghij\nklmno\n");
    feldGeometrie.zellen();
    feldGeometrie.aendereAktuellesFeld("X");

    assertEquals("eintlnesFeldGesetzt", "X", feldGeometrie
        .toString());
  }

  @Test
  public void
         aendereAktuellesFeld__letztesInZeile__zusaetzlicZeilenumbruch() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();
    feldGeometrie.setzeKarte("12345\n67890\n"
        + "abcde\nfghij\nklmno\n");
    feldGeometrie.zellen();
    feldGeometrie.aendereAktuellesFeld("X");
    feldGeometrie.aendereAktuellesFeld("X");
    feldGeometrie.aendereAktuellesFeld("X");
    feldGeometrie.aendereAktuellesFeld("X");
    feldGeometrie.aendereAktuellesFeld("X");

    assertEquals("eintlnesFeldGesetzt", "XXXXX\n",
        feldGeometrie.toString());
  }

  @Test
  public void
         iterator$hasNext__beliebigeKarte_ersterZugriff__true() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("1");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    boolean hasNext = zellenIterator.hasNext();

    assertTrue("erster Zugriff", hasNext);
  }

  @Test
  public void
         iterator$hasNext__beLiebigeKarte_letzterZugriff__true() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("1\n");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    zellenIterator.next();
    boolean hasNext = zellenIterator.hasNext();

    assertFalse("letzter Zugriff", hasNext);
  }

  @Test
  public void
         iterator$hasNext__Karte2Zeilen_ersterZugriff__true() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("1\n2");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    boolean hasNext = zellenIterator.hasNext();

    assertTrue("erster Zugriff", hasNext);
  }

  @Test
  public void
         zellen__karte3x3feldDrei__3_1$2$4$5$6$7$8$9() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("123\n456\n789\n");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    zellenIterator.next();
    zellenIterator.next();
    ZelleMitNachbarn dritteZelle = zellenIterator.next();

    assertEquals("erstes Feld", "3", dritteZelle.zustand());
    List<String> nachbarn = dritteZelle.nachbarn();
    nachbarn.sort(String.CASE_INSENSITIVE_ORDER);
    assertEquals("Nachbarn Liste",
        "[1, 2, 4, 5, 6, 7, 8, 9]",
        nachbarn.toString());

  }

  @Test
  public void
         zellen__karte3x3feldErsterEintfrag__1_2$3$4$5$6$7$8$9() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("123\n456\n789\n");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    ZelleMitNachbarn ersteZelle = zellen.iterator().next();

    assertEquals("erstes Feld", "1", ersteZelle.zustand());
    List<String> nachbarn = ersteZelle.nachbarn();
    nachbarn.sort(String.CASE_INSENSITIVE_ORDER);
    assertEquals("Nachbarn Liste",
        "[2, 3, 4, 5, 6, 7, 8, 9]",
        nachbarn.toString());

  }

  @Test
  public void
         zellen__karte3x3feldVier__4_1$2$3$5$6$7$8$9() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("123\n456\n789\n");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    ZelleMitNachbarn dritteZelle = zellenIterator.next();

    assertEquals("erstes Feld", "4", dritteZelle.zustand());
    List<String> nachbarn = dritteZelle.nachbarn();
    nachbarn.sort(String.CASE_INSENSITIVE_ORDER);
    assertEquals("Nachbarn Liste",
        "[1, 2, 3, 5, 6, 7, 8, 9]",
        nachbarn.toString());

  }

  @Test
  public void
         zellen__karte5x5feldAcht__8_2$3$4$7$9$b$c$d() {
    FeldGeometrie feldGeometrie = new FeldGeometrieQuadrat();

    feldGeometrie.setzeKarte("12345\n67890\n"
        + "abcde\nfghij\nklmno\n");
    Iterable<ZelleMitNachbarn> zellen = feldGeometrie
        .zellen();
    Iterator<ZelleMitNachbarn> zellenIterator = zellen
        .iterator();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    zellenIterator.next();
    ZelleMitNachbarn dritteZelle = zellenIterator.next();

    assertEquals("erstes Feld", "8", dritteZelle.zustand());
    List<String> nachbarn = dritteZelle.nachbarn();
    nachbarn.sort(String.CASE_INSENSITIVE_ORDER);
    assertEquals("Nachbarn Liste",
        "[2, 3, 4, 7, 9, b, c, d]",
        nachbarn.toString());
  }

}
