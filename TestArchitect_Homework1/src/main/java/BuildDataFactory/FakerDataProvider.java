package BuildDataFactory;

import com.github.javafaker.Faker;

public class FakerDataProvider implements TestDataProvider {
	
    private final Faker faker = new Faker();

    @Override
    public Object getTestData(String key) {
        // Generate fake data based on the key
        switch (key.toLowerCase()) {
            case "username":
                return faker.name().username();
            case "email":
                return faker.internet().emailAddress();
            default:
                return "No Fake Data Found";
        }
    }
}

