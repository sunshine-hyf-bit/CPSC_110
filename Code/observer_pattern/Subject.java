import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void addObserver(Observer o);  // 添加观察者
    void removeObserver(Observer o);  // 移除观察者
    void notifyObservers();  // 通知所有观察者
}

