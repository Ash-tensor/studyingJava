package cafepackage;

import java.util.ArrayList;
import java.util.List;

public abstract class App {
    private static List<App> APP_STORE = new ArrayList<>();
    String name;
    public void registerAppstore() {
        App.APP_STORE.add(this);
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static List<App> getAppStore() {
        return APP_STORE;
    }

    public App(String name) {
        this.name = name;
    }


}
