package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        // 创建MVC组件
        Model model = new Model();
        View view = new View();
        new Controller(model, view);  // 连接Model和View

        // 设置舞台
        primaryStage.setTitle("Simple Drawing Board with Shapes");
        primaryStage.setScene(new Scene(view.getLayout(), 800, 600));  // 设置窗口大小
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // 启动JavaFX应用程序
    }

}