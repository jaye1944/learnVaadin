package com.example.demo;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
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
        setContent(root);
    }

    private void addHeader() {
        root.addComponent(new Label("TODOs"));
    }
    private void addList() {
        root.addComponent(todolayot);
    }

    private void addForm() {
        HorizontalLayout horizontalLay = new HorizontalLayout();
        TextField task = new TextField();
        Button add = new Button( "Add");
        horizontalLay.addComponents(task,add);
        root.addComponent(horizontalLay);
    }

    private void addDeleteButtion() {
        root.addComponent(new Button("Delete Completed"));
    }
}
