import java.util.HashSet;
import java.util.Set;

public abstract class ObjPool<T> {

    private final Set<T> available = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T create();

    public synchronized T checkOut() {
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        System.out.println("Obj checked out with id "+instance.toString());
       System.out.println(toString());
        return instance;


    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);
        System.out.println("Obj checked in with id "+instance.toString());
        this.toString();
        System.out.println(toString());

    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}
