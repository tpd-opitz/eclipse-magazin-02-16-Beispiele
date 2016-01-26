import java.util.ArrayList;
import java.util.List;

class Spiel {
  private final FeldGeometrie feldGeometrie;
  private ZustandsFinder zustandsFinder;

  public Spiel(FeldGeometrie feldGeometrie,
               ZustandsFinder zustandsFinder) {
    this.feldGeometrie = feldGeometrie;
    this.zustandsFinder = zustandsFinder;
  }

  public String neueGeneration(String zellenMap) {
    feldGeometrie.setzeKarte(zellenMap);
    for (ZelleMitNachbarn zelle : feldGeometrie.zellen()) {
      String neuerZustand = neuerZustand(zelle);
      feldGeometrie.aendereAktuellesFeld(neuerZustand);
    }
    return feldGeometrie.toString();
  }

  private String neuerZustand(ZelleMitNachbarn zelle) {
    List<Zustand> nachbarn = nachbarZustaende(zelle);
    Zustand alterZustand = zustandsFinder.find(
        zelle.zustand());
    Zustand neuerZustand = alterZustand.aendern(nachbarn);
    return neuerZustand.toString();
  }

  private List<Zustand> nachbarZustaende(
                                         ZelleMitNachbarn zelle) {
    List<String> nachbarn = zelle.nachbarn();
    List<Zustand> nachbarZustaende = new ArrayList<>();
    for (String nachbarZustand : nachbarn) {
      nachbarZustaende.add(zustandsFinder.find(
          nachbarZustand));
    }
    return nachbarZustaende;
  }

}
