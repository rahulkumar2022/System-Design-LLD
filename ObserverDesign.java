// Observer Design Pattern Example in Java
// The observer design pattern defines a one-to-many dependency between objects so that when one object changes state,
// all its dependents are notified and updated automatically.

import java.util.*;

public class ObserverDesign {

    interface Observer {

        void message(String msg);
    }

    interface Subject {

        void registerObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObservers(String msg);
    }

    static class WeatherService implements Subject {

        private final List<Observer> observers;

        public WeatherService() {
            this.observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers(String msg) {
            for (Observer o : observers) {
                o.message(msg);
            }
        }

        public void setWeatherUpdate(String weatherInfo) {
            notifyObservers(weatherInfo);
        }
    }

    static class WeatherApp implements Observer {

        private final String appName;

        public WeatherApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void message(String msg) {
            System.out.println(appName + " received weather update: " + msg);
        }
    }

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        WeatherApp app1 = new WeatherApp("WeatherApp One");
        WeatherApp app2 = new WeatherApp("WeatherApp Two");

        weatherService.registerObserver(app1);
        weatherService.registerObserver(app2);

        weatherService.setWeatherUpdate("Sunny, 25°C");
        weatherService.setWeatherUpdate("Rainy, 18°C");

        weatherService.removeObserver(app1);

        weatherService.setWeatherUpdate("Cloudy, 20°C");
    }
}

// Benefits of Observer Pattern:
// 1. Loose Coupling: The subject and observers are loosely coupled. The subject only knows about the observers through the Observer interface.
// 2. Dynamic Relationships: Observers can be added or removed at runtime, allowing for dynamic relationships.
// 3. Broadcast Communication: A single change in the subject can notify multiple observers, facilitating broadcast communication.  
// Usage Scenarios:
// 1. Event Handling Systems: GUI frameworks often use the observer pattern to handle events like button clicks.
// 2. Real-time Data Feeds: Applications that require real-time updates, such as stock market tickers or weather updates.
// 3. MVC Architecture: The observer pattern is commonly used in Model-View-Controller (MVC) architectures to keep views updated with changes in the model
