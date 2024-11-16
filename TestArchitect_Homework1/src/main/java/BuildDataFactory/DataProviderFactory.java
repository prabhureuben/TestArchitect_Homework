package BuildDataFactory;

public class DataProviderFactory {
    public static TestDataProvider getDataProvider(DataSourceType sourceType) {
        switch (sourceType) {
            
            case FAKER:
                return new FakerDataProvider();
            case HARDCODED:
                return new HardcodedDataProvider();
            case EXCEL:
                return new ExcelDataProvider("./TestData/01TestData.xlsx");
            default:
                throw new IllegalArgumentException("Invalid data source type");
        }
    }
}
