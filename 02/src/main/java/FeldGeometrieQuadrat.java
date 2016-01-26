import java.util.Iterator;

public class FeldGeometrieQuadrat implements FeldGeometrie {

  private String zellenMap;
  private StringBuilder neueKarte;

  @Override
  public void setzeKarte(String zellenMap) {
    this.zellenMap = zellenMap;
  }

  @Override
  public Iterable<ZelleMitNachbarn> zellen() {
    neueKarte = new StringBuilder();
    return new Iterable<ZelleMitNachbarn>() {
      @Override
      public Iterator<ZelleMitNachbarn> iterator() {
        return new ZellenIterator(zellenMap);
      }
    };
  }

  @Override
  public void aendereAktuellesFeld(String string) {
    neueKarte.append(string);
    if ('\n' == zellenMap.charAt(neueKarte.length())) {
      neueKarte.append("\n");
    }
  }

  @Override
  public String toString() {
    return neueKarte.toString();
  }
  

}
