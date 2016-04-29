import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_checkInstantiatesWord_Cactus() {
    Word newWord = new Word("Cactus");
    assertEquals("Cactus", newWord.returnWord());
  }
}
