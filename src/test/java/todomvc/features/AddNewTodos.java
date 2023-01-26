package todomvc.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodos {


    @CastMember(name="Benito")
    Actor benito;

    @Test
    @DisplayName("Add a new item to the list")
    void addToEmptyList() throws InterruptedException {
        benito.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Enter.theValue("Create document").into(".new-todo").thenHit(Keys.ENTER)
        );
        var todos= benito.asksFor(Text.ofEach(".todo-list li"));
        assertThat(todos).containsExactly("Create document");
        Thread.sleep(3000);
    }
}
