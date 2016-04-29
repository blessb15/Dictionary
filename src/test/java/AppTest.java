import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest {

  @Test
  public void Scrabble_SingleLetterReturnValue_True() {
    Scrabble getScrabble = new Scrabble();
    Integer num = 5;
    assertEquals(num,getScrabble.getScore("aeiou"));
  }
}
