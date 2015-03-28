package de.awenger.krispa.util.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Adrian Wenger
 */
public class Observable implements IObservable {


    /**
     * List to save Subscriber Objects.
     */
    private final List<IObserver> subscribers = new ArrayList<>();

    /**
     * add single observer to subscriber list.
     *
     * @param s Obersver
     */
    @Override
    public final void addObserver(final IObserver s) {
        if (!subscribers.contains(s)) {
        subscribers.add(s);
    }
    }

    /**
     * notify each observer in subscriber List.
     */
    @Override
    public final void notifyObservers() {
        for (IObserver observer : subscribers) {
            observer.update();
        }
    }

    /**
     * remove specific Subscriber.
     * @param s subscriber
     */
    @Override
    public void removeObserver(final IObserver s) {
        subscribers.remove(s);
    }

    /**
     *
     * @return list of subscribers
     */
    @Override
    public final List<IObserver> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
}

}
