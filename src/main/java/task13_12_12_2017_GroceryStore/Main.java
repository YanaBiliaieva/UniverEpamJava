package task13_12_12_2017_GroceryStore;

public class Main {
    public static void main(String[] args) throws Exception {
        GroceryStore groceryStore = new GroceryStore();
        String productName = "salmon";
        groceryStore.createProduct(11, 1, productName, 77);
        String result = groceryStore.selectProductById(11);
        System.out.println(result);
        groceryStore.deleteProduct(11);
        String categories=groceryStore.selectAllCategories();
        System.out.println(categories);
        String products=groceryStore.selectAllProducts();
        System.out.println(products);
        System.out.println("Select all: ");
        groceryStore.selectAllProductsAndCategories();
    }
}
