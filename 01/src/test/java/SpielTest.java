import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTest {

  @Test
  public void
         berechneGeneration__feld5x5_3lebend__eineLebend() {
    Spiel spiel = new Spiel();

    String neueGeneration = spiel.berechneGeneration(
        ""
            + ".....\n"
            + "..X..\n"
            + ".....\n"
            + ".X.X.\n"
            + ".....\n");

    assertEquals("eine erwaeckte Zelle",
        ""
        + ".....\n"
        + ".....\n"
        + "..X..\n"
        + ".....\n"
        + ".....\n",
        neueGeneration);
  }

  @Test
  public void
        berechneGeneration__feld5x5_2lebend__alleTod() {
    Spiel spiel = new Spiel();

    String neueGeneration = spiel.berechneGeneration(
        ""
        + ".....\n"
        + ".....\n"
        + ".....\n"
        + ".X.X.\n"
        + ".....\n");

    assertEquals("alle tot",
        ""
        + ".....\n"
        + ".....\n"
        + ".....\n"
        + ".....\n"
        + ".....\n",
        neueGeneration);
  }

  @Test
  public void
        berechneGeneration__feld5x5_1lebendMit4nachbarm__stibt() {
    Spiel spiel = new Spiel();

    String neueGeneration = spiel.berechneGeneration(
        ""
        + ".....\n"
        + ".X.X.\n"
        + "..X..\n"
        + ".X.X.\n"
        + ".....\n");

    assertEquals("alleSterben aber 4 erwaeckt",
        ""
        + ".....\n"
        + "..X..\n"
        + ".X.X.\n"
        + "..X..\n"
        + ".....\n",
        neueGeneration);
  }

  @Test
  public void
         berechneGeneration__feld5x5_1lebend2Nachbarn__zweiLebend() {
    Spiel spiel = new Spiel();

    String neueGeneration = spiel.berechneGeneration(
        ".....\n.....\n.XX..\n...X.\n.....\n");

    assertEquals("zwei lebende Zellen",
        ".....\n.....\n..X..\n..X..\n.....\n",
        neueGeneration);
  }

  @Test
  public void
         berechneGeneration__feld5x5_1lebend3Nachbarn__dreiLebend() {
    Spiel spiel = new Spiel();

    String neueGeneration = spiel.berechneGeneration(
        ".....\n...X.\n.XX..\n...X.\n.....\n");

    assertEquals("vier lebende Zellen",
        ".....\n..X..\n..XX.\n..X..\n.....\n",
        neueGeneration);
  }

}
