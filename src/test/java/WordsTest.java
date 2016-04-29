import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class WordsTest {

  @After
  public void tearDown() {
    Words.clear();
  }

  @Test
  public void Words_checkInstantiatesWord_Cactus() {
    Words newWord = new Words("Cactus");
    assertEquals(true, newWord instanceof Words);
  }

  @Test
  public void Words_checkInstantiatesMultipleWords_CactusApple() {
    Words newWord1 = new Words("Cactus");
    Words newWord2 = new Words("Apple");
    assertEquals(Words.all().size(),2);
  }

  @Test
  public void Words_takeNewWordAddDefinition_Cactusisadesertplant() {
    Words newWord = new Words("Cactus");
    Definitions newDefinition = new Definitions("a dessert plant.");
    newWord.addDefinition(newDefinition);
    assertTrue(newWord.getDefinition().contains(newDefinition));
  }
}
