package study.apach.controllers;

import study.apach.views.View;
import study.apach.views.representable.IndexView;

public class MainController {

    public void index() {
        View indexView = new View(new IndexView());
        indexView.render();
    }
}
