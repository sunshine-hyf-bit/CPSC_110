public class AlertModule implements Observer {
    @Override
    public void update(int hunger, int fatigue) {
        if (hunger > 80) {
            System.out.println("Alert: Your pet is very hungry! Please feed it.");
        }
        if (fatigue > 80) {
            System.out.println("Alert: Your pet is very tired! Please let it rest.");
        }
    }
}
