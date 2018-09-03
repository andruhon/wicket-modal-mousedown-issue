package pro.kondratev.wicketmodaldemo;

import org.apache.wicket.markup.html.panel.Panel;
import org.jetbrains.annotations.NotNull;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;
import org.wicketstuff.select2.Select2MultiChoice;
import org.wicketstuff.select2.StringTextChoiceProvider;

import java.util.Arrays;
import java.util.List;

public class ModalPanel extends Panel
{

    private final List<String> choices = Arrays.asList("a", "b", "c", "d");

    private final StringTextChoiceProvider choiceProvider = new StringTextChoiceProvider() {
        @Override
        public void query(@NotNull String s, int i, Response<String> response) {
            response.setResults(choices);
        }
    };

    public ModalPanel(@NotNull String id)
    {
        super(id);
        setOutputMarkupPlaceholderTag(true); // this bit is necessary to make the setDropdownParent work properly

        Select2Choice<String> letters = new Select2Choice<String>("letters", choiceProvider) {
            protected void onBeforeRender() {
                super.onBeforeRender();
                this.getSettings().setDropdownParent(this.getParent().getMarkupId());
                this.getSettings().setWidth("100%");
            }
        };
        add(letters);

        Select2MultiChoice<String> lettersMulti = new Select2MultiChoice<String>("lettersMulti", choiceProvider) {
            @Override
            protected void onBeforeRender() {
                super.onBeforeRender();
                this.getSettings().setDropdownParent(this.getParent().getMarkupId());
                this.getSettings().setWidth("100%");
            }
        };
        add(lettersMulti);
    }

}