import static org.junit.Assert.*;

import org.junit.Test;

public class ZustandsFinderTest {

  @Test
  public void find__X__Lebt() {
    Zustand zustand = new ZustandsFinder().find("X");
    
    assertTrue("lebt", ZustandsFinder.LEBT==zustand);
  }
  @Test
  public void find__DOT__TOD() {
    Zustand zustand = new ZustandsFinder().find(".");
    
    assertTrue("lebt", ZustandsFinder.TOD==zustand);
  }

}
