package pro.kondratev.wicketmodaldemo;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.jetbrains.annotations.NotNull;

public class HomePage extends WebPage {

    public HomePage() {
        add(new Label("helloMessage", "Hello WicketWorld!"));
        final ModalWindow modalWindow = new ModalWindow("modalWindow");
        Label label = new Label(modalWindow.getContentId(), "I'm a modal window!");

        modalWindow.setContent(label);
        modalWindow.setTitle("Modal window");
        modalWindow.setContent(new ModalPanel(modalWindow.getContentId()));

        add(modalWindow);
        add(new AjaxLink<Void>("openWindow") {
            @Override
            public void onClick(@NotNull AjaxRequestTarget target) {
                modalWindow.show(target);
            }
        });
    }

}
