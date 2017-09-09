package com.example.demo;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class ToDoUI extends UI {
    private VerticalLayout root;

    @Autowired
    TodoLayout todolayot;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setLayout();
        addHeader();
        addForm();
        addList();
        addDeleteButtion();
    }

    private void setLayout() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

    private void addHeader() {

        Label labelHeader = new Label("TODOs");
        labelHeader.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(labelHeader);

    }
    private void addList() {
        todolayot.setWidth("80%");
        root.addComponent(todolayot);
    }

    private void addForm() {
        HorizontalLayout horizontalLay = new HorizontalLayout();
        horizontalLay.setWidth("80%");
        TextField task = new TextField();
        Button add = new Button();
        add.setStyleName(ValoTheme.BUTTON_PRIMARY);
        add.setIcon(VaadinIcons.PLUS);
        horizontalLay.addComponentsAndExpand(task);
        horizontalLay.addComponents(add);
        root.addComponent(horizontalLay);
    }

    private void addDeleteButtion() {
        root.addComponent(new Button("Delete Completed"));
    }
}
