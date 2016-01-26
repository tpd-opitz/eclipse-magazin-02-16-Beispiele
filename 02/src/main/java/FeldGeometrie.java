public interface FeldGeometrie {

  void setzeKarte(String zellenMap);

  Iterable<ZelleMitNachbarn> zellen();

  void aendereAktuellesFeld(String string);

}
