import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ZellenIterator implements
    Iterator<ZelleMitNachbarn> {
  final String[] rows;
  int row = 0;
  int col = 0;

  public ZellenIterator(String zellenMap) {
    rows = zellenMap.split("[\r\n]+");
  }

  @Override
  public ZelleMitNachbarn next() {
    List<String> nachbarn = new ArrayList<>();
    for (int iRow = -1; iRow < 2; iRow++)
      for (int iCol = -1; iCol < 2; iCol++)
        if (!(iRow == 0 && iCol == 0)) {
          int rowIndex = calulateIndex(row, iRow,
              rows.length);
          int colIndex = calulateIndex(col, iCol,
              rows[0].length());
          nachbarn.add(String.valueOf(
              rows[rowIndex].charAt(colIndex)));
        }
    ZelleMitNachbarn zelleMitNachban = new ZelleMitNachbarn(
        String.valueOf(rows[row].charAt(col)),
        nachbarn);
    col++;
    if (0 == col % rows[0].length()) {
      col = 0;
      row++;
    }
    return zelleMitNachban;
  }

  private int calulateIndex(int iteratorIndex,
                            int nachbarRelativIndex,
                            int anzahlInRichtung) {
    return (iteratorIndex - nachbarRelativIndex
        + anzahlInRichtung) % anzahlInRichtung;
  }

  @Override
  public boolean hasNext() {
    return row < rows.length && col < rows[row].length();
  }
}