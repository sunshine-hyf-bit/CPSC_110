import java.util.ArrayList;
import java.util.List;

public class Pet implements Subject {
    private List<Observer> observers;
    private int hunger;  // 饥饿值
    private int fatigue;  // 疲劳值

    public Pet() {
        observers = new ArrayList<>();
        hunger = 50;  // 初始化饥饿值
        fatigue = 50;  // 初始化疲劳值
    }

    // 添加观察者
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    // 移除观察者
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // 通知所有观察者
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(hunger, fatigue);  // 传递当前饥饿值和疲劳值
        }
    }

    // 改变饥饿值并通知观察者
    public void feed() {
        hunger = Math.max(hunger - 10, 0);  // 喂食减少饥饿值
        notifyObservers();
    }

    // 改变疲劳值并通知观察者
    public void rest() {
        fatigue = Math.max(fatigue - 10, 0);  // 休息减少疲劳值
        notifyObservers();
    }

    // 模拟时间推移，增加饥饿和疲劳
    public void passTime() {
        hunger = Math.min(hunger + 5, 100);  // 时间流逝饥饿值增加
        fatigue = Math.min(fatigue + 5, 100);  // 时间流逝疲劳值增加
        notifyObservers();
    }

    // 获取饥饿值
    public int getHunger() {
        return hunger;
    }

    // 获取疲劳值
    public int getFatigue() {
        return fatigue;
    }
}
