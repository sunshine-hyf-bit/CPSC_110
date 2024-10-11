public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();  // 创建虚拟宠物
        StatusDisplay statusDisplay = new StatusDisplay();  // 状态显示
        AlertModule alertModule = new AlertModule();  // 提醒模块

        // 将观察者添加到宠物中
        pet.addObserver(statusDisplay);
        pet.addObserver(alertModule);

        // 模拟时间流逝和宠物行为
        pet.passTime();  // 时间流逝，饥饿和疲劳增加
        pet.feed();  // 喂食
        pet.passTime();  // 再次时间流逝
        pet.rest();  // 休息
        pet.passTime();  // 继续时间流逝
        pet.passTime();  // 进一步时间流逝
    }
}
