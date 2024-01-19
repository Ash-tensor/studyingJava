package cafepackage;

import java.util.ArrayList;
import java.util.List;

public abstract class App {
    private static List<App> appStore = new ArrayList<>();
    String name;
    public void registerAppstore() {
        App.appStore.add(this);
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static List<App> getAppStore() {
        return appStore;
    }

    public App(String name) {
        this.name = name;
    }


}
