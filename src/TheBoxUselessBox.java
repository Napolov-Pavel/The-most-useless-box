import java.util.concurrent.atomic.AtomicBoolean;

public class TheBoxUselessBox {
    volatile private AtomicBoolean state = new AtomicBoolean(false);

    public void changingTheStateOfTheBox(boolean newState) {
        System.out.printf("%s переключает тумблер в положение %s\n", Thread.currentThread().getName(), newState);
        state.getAndSet(newState);
        System.out.printf("Теперь тумблер в положении %s\n", state.get());
    }

    public boolean getStateOfTheBox() {
        return state.get();
    }
}
