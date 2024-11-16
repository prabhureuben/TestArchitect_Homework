package BuildDataFactory;

import java.util.HashMap;

public class HardcodedDataProvider implements TestDataProvider {
    @Override
    public Object getTestData(String key) {
        HashMap<String, String> hardcodedData = new HashMap<>();
        hardcodedData.put("username", "Demosalesmanager");
        hardcodedData.put("password", "crmsfa");
        return hardcodedData.get(key);
    }
}