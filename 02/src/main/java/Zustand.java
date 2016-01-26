import java.util.List;

public interface Zustand {

  Zustand aendern(List<Zustand> nachbarZustände);

}
