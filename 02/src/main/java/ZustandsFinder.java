public class ZustandsFinder {

  static final Zustand TOD = new ZustandTod(new ZustandZaehler());
  static final Zustand LEBT = new ZustandLebt(new ZustandZaehler());

  Zustand find(String zustand) {
    return "X".equals(zustand) ? LEBT : TOD;
  }

}
