package classWork20january;

public class MainRead {
    public static void main(String[] args) {
            String[][] product = {
                    {"apple","kalam","azad","100","2020-1-1","2020-1-2"},
                    {"orrange","abul","molla","200"," 2020-1-2"," 2020-1-3"},
                    {"banana","bashir","mollik","300","2020-1-3","2020-1-4"}
            };
        InsertProduct oracle = new InsertProduct();
        oracle.insertDummyData(product);
    }
}



