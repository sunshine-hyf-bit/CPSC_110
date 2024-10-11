package com.example;

import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

public class Controller {
    private Model model;
    private View view;
    private double startX, startY;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Listen for changes in the color picker
        view.getColorPicker().setOnAction(e -> {
            model.setCurrentColor(view.getColorPicker().getValue());
        });

        // Listen for tool selection
        view.getLineButton().setOnAction(e -> model.setCurrentTool("Line"));
        view.getRectButton().setOnAction(e -> model.setCurrentTool("Rectangle"));
        view.getCircleButton().setOnAction(e -> model.setCurrentTool("Circle"));

        // Handle mouse events for drawing shapes
        view.getCanvas().setOnMousePressed(this::handleMousePressed);
        view.getCanvas().setOnMouseReleased(this::handleMouseReleased);
    }

    // Record the initial mouse press coordinates
    private void handleMousePressed(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
    }

    // Draw the shape after the mouse is released
    private void handleMouseReleased(MouseEvent event) {
        double endX = event.getX();
        double endY = event.getY();

        switch (model.getCurrentTool()) {
            case "Line":
                // Create and add a line
                Line line = new Line(startX, startY, endX, endY);
                model.addShape(line);
                view.getCanvas().getChildren().add(line);
                break;

            case "Rectangle":
                // Create and add a rectangle
                Rectangle rect = new Rectangle(Math.min(startX, endX), Math.min(startY, endY),
                        Math.abs(startX - endX), Math.abs(startY - endY));
                rect.setFill(null);  // Only draw the border of the rectangle
                model.addShape(rect);
                view.getCanvas().getChildren().add(rect);
                break;

            case "Circle":
                // Create and add a circle
                double radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                Circle circle = new Circle(startX, startY, radius);
                circle.setFill(null);  // Only draw the border of the circle
                model.addShape(circle);
                view.getCanvas().getChildren().add(circle);
                break;
        }
    }
}
