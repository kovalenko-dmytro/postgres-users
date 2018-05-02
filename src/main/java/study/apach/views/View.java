package study.apach.views;

import study.apach.views.representable.Representable;

import java.util.*;

public class View {

    private Collection<Object> dataCollection;
    private Representable representable;

    public View(Representable representable) {
        this.representable = representable;
    }

    public void setData(Object data) {

        if (data instanceof Iterable) {

            if (data instanceof List) {
                dataCollection = new ArrayList<>();
            } else if (data instanceof Set) {
                dataCollection = new HashSet<>();
            } else if (data instanceof Queue) {
                dataCollection = new ArrayDeque<>();
            }

            dataCollection.addAll((Collection<?>) data);

        } else {
            dataCollection = new ArrayList<>();
            dataCollection.add(data);
        }
    }

    public void render() {
        if (dataCollection == null) {
            dataCollection = new ArrayList<>();
        }
        representable.render(dataCollection);
    }
}
