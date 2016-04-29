import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DefinitionsTest {

  @Test
  public void Definitions_checkInstantiatesDefinition_adesertplant() {
  Definitions newDef = new Definitions("a dessert plant");
    assertEquals(true, newDef instanceof Definitions);
  }

}
