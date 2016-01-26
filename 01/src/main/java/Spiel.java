class Spiel {
  String berechneGeneration(String zellenMap) {
    StringBuilder neueMap = new StringBuilder();
    String[] mapRows = zellenMap.split("[\r\n]+");
    int rowCount = mapRows.length;
    int colCount = mapRows[0].length();
    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        int lebendeNachbarn = 0;
        for (int nCol = -1; nCol < 2; nCol++)
          for (int nRow = -1; nRow < 2; nRow++)
            if (!(nRow == 0 && nCol == 0)) {
              int rowIndex = (row + nRow + rowCount)
                  % rowCount;
              int colIndex = (col + nCol + colCount)
                  % colCount;
              char nachbar = mapRows[rowIndex].charAt(
                  colIndex);
              if ('X' == nachbar)
                lebendeNachbarn++;
            }
        char alterZustand = mapRows[row].charAt(col);
        String neuerZustand = ".";
        if ('X' == alterZustand)
          if (2 == lebendeNachbarn || 3 == lebendeNachbarn)
            neuerZustand = "X";
        if ('.' == alterZustand)
          if (3 == lebendeNachbarn)
            neuerZustand = "X";
        neueMap.append(neuerZustand);
      }
      neueMap.append("\n");
    }
    return neueMap.toString();
  }
}
