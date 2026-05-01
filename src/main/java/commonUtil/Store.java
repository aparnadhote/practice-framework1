package commonUtil;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class Store {

    private static final ThreadLocal<Map<String, Object>> store = ThreadLocal.withInitial(HashMap::new);

    private static final ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    private static final ThreadLocal<Response> response = new ThreadLocal<>();

    // ================= STORE METHODS =================

    public static void set(String key, Object value) {
        store.get().put(key, value);
    }

    public static Object get(String key) {
        return store.get().get(key);
    }

    public static void clear() {
        store.remove();
        scenario.remove();
        response.remove();    }

    // ================= SCENARIO =================

    public static void setScenario(Scenario sc) {
        scenario.set(sc);
    }

    public static Scenario getScenario() {
        return scenario.get();
    }

    // ================= RESPONSE =================

    public static void setResponse(Response res) {
        response.set(res);
    }

    public static Response getResponse() {
        return response.get();
    }
    // ================= DRIVER =================

    public static void setDriver(WebDriver driver){
        store.get().put("driver",driver);
    }
    public static WebDriver getDriver() {
        return (WebDriver) store.get().get("driver");
    }
}