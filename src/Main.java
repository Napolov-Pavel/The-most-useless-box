public class Main {
    static TheBoxUselessBox box = new TheBoxUselessBox();
    static final int NUMBER_OF_GAMES = 10;
    static final int TIME_BETWEEN_USER_ACTION = 3000;
    static final int TIME_BEFORE_THE_ACTION_OF_THE_BOX = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread user = new Thread(null, Main::user2, "Пользователь");
        Thread toy = new Thread(null, Main::toy, "Коробка");
        user.start();
        toy.start();
        while (user.isAlive()) {
        }
        toy.interrupt();
    }

    public static void user2() {
        for (int i = 0; i < NUMBER_OF_GAMES; i++) {
            box.changingTheStateOfTheBox(true);
            try {
                Thread.sleep(TIME_BETWEEN_USER_ACTION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void toy() {
        while (!Thread.currentThread().isInterrupted()) {
            if (box.getStateOfTheBox() == true) {
                try {
                    Thread.sleep(TIME_BEFORE_THE_ACTION_OF_THE_BOX);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                box.changingTheStateOfTheBox(false);
            }
        }
    }
}
