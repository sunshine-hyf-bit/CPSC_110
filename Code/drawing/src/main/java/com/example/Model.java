package com.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Shape> shapes = new ArrayList<>();  // 存储所有绘制的形状
    private Color currentColor = Color.BLACK;  // 当前绘制颜色
    private String currentTool = "Line";  // 默认绘制工具为线条

    // 添加形状
    public void addShape(Shape shape) {
        shape.setStroke(currentColor);  // 设置形状边框颜色
        if (shape instanceof Line) {
            ((Line) shape).setStrokeWidth(2);
        }
        shapes.add(shape);
    }

    // 获取所有形状
    public List<Shape> getShapes() {
        return shapes;
    }

    // 设置当前颜色
    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    // 获取当前颜色
    public Color getCurrentColor() {
        return currentColor;
    }

    // 设置当前工具（线条、矩形或圆形）
    public void setCurrentTool(String tool) {
        currentTool = tool;
    }

    // 获取当前工具
    public String getCurrentTool() {
        return currentTool;
    }
}
