import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class WordsTest {

  @After
  public void tearDown() {
    Words.clear();
  }

  @Test
  public void Word_checkInstantiatesWord_Cactus() {
    Words newWord = new Words("Cactus");
    assertEquals(true, newWord instanceof Words);
  }

  @Test
  public void Word_checkInstantiatesMultipleWords_CactusApple() {
    Words newWord1 = new Words("Cactus");
    Words newWord2 = new Words("Apple");
    assertEquals(Words.returnWordList().size(),2);
  }
}
