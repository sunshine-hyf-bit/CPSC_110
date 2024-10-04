package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * JavaFX App
 */
public class App extends Application {
    private String currentShape = "Circle"; // 默认形状

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        GridPane toolBar = new GridPane();
        toolBar.setVgap(10);
        toolBar.setHgap(10);

        Label label = new Label("选择形状：");
        Button circleButton = new Button("圆形");
        Button rectangleButton = new Button("矩形");
        Button triangleButton = new Button("三角形");

        circleButton.setOnAction(e -> currentShape = "Circle");
        rectangleButton.setOnAction(e -> currentShape = "Rectangle");
        triangleButton.setOnAction(e -> currentShape = "Triangle");

        toolBar.add(label, 0, 0);
        toolBar.add(circleButton, 0, 1);
        toolBar.add(rectangleButton, 1, 1);
        toolBar.add(triangleButton, 0, 2);
        Pane drawingPane = new Pane();
        drawingPane.setStyle("-fx-border-color: black; -fx-background-color: white;");

        // 鼠标点击画图
        drawingPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            double x = event.getX();
            double y = event.getY();
            
            switch (currentShape) {
                case "Circle":
                    Circle circle = new Circle(x, y, 30);
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                    drawingPane.getChildren().add(circle);
                    break;
                case "Rectangle":
                    Rectangle rectangle = new Rectangle(x - 40, y - 30, 80, 60);
                    rectangle.setFill(Color.TRANSPARENT);
                    rectangle.setStroke(Color.BLACK);
                    drawingPane.getChildren().add(rectangle);
                    break;
                case "Triangle":
                    Polygon triangle = new Polygon();
                    triangle.getPoints().addAll(
                            x, y - 40,
                            x - 40, y + 40,
                            x + 40, y + 40
                    );
                    triangle.setFill(Color.TRANSPARENT);
                    triangle.setStroke(Color.BLACK);
                    drawingPane.getChildren().add(triangle);
                    break;
            }
        });

        // 主布局
        BorderPane root = new BorderPane();
        root.setLeft(toolBar);  // 工具栏放在左边
        root.setCenter(drawingPane);  // 画布放在中间

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}