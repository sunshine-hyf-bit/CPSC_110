package com.example;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class View {
    private Pane canvas;
    private ColorPicker colorPicker;
    private ToggleButton lineButton;
    private ToggleButton rectButton;
    private ToggleButton circleButton;
    private HBox toolbar;
    private BorderPane layout;

    public View() {
        canvas = new Pane();  // 绘图区域
        canvas.setStyle("-fx-background-color: white;");  // 设置背景为白色

        colorPicker = new ColorPicker();  // 颜色选择器

        // 创建工具按钮组
        ToggleGroup toggleGroup = new ToggleGroup();
        lineButton = new ToggleButton("Line");
        rectButton = new ToggleButton("Rectangle");
        circleButton = new ToggleButton("Circle");

        lineButton.setToggleGroup(toggleGroup);
        rectButton.setToggleGroup(toggleGroup);
        circleButton.setToggleGroup(toggleGroup);
        lineButton.setSelected(true);  // 默认选择线条工具

        // 工具栏放在底部
        toolbar = new HBox(10);  // 间隔10px
        toolbar.getChildren().addAll(colorPicker, lineButton, rectButton, circleButton);

        layout = new BorderPane();
        layout.setCenter(canvas);  // 将绘图区域放在中心
        layout.setBottom(toolbar);  // 将工具栏放在底部
    }

    // 获取画布
    public Pane getCanvas() {
        return canvas;
    }

    // 获取颜色选择器
    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    // 获取线条工具按钮
    public ToggleButton getLineButton() {
        return lineButton;
    }

    // 获取矩形工具按钮
    public ToggleButton getRectButton() {
        return rectButton;
    }

    // 获取圆形工具按钮
    public ToggleButton getCircleButton() {
        return circleButton;
    }

    // 获取主布局
    public BorderPane getLayout() {
        return layout;
    }
}
