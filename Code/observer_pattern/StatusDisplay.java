

public class StatusDisplay implements Observer {
    @Override
    public void update(int hunger, int fatigue) {
        System.out.println("Current Hunger: " + hunger + ", Current Fatigue: " + fatigue);
    }
}