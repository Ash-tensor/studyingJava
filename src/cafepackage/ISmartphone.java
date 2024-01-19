package cafepackage;

import java.util.ArrayList;
import java.util.List;

public interface ISmartphone {
    List<App> appList = new ArrayList<>();
    public void installingApp(String name);
    public void usingApp(App app);
}
