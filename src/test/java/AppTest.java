import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void RootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void successForWord() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Cactus");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been Added!");
  }

  @Test
  public void WordisDisplayedonPage() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Cactus");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Cactus");
  }

  @Test
  public void goesToDefinitionPage() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Cactus");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Cactus");
    click("a", withText("Cactus"));
    click("a", withText("Add a new Definition"));
    assertThat(pageSource()).contains("Add a definition to Cactus");
  }
}
