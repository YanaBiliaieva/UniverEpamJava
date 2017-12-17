package task13_12_12_2017_GroceryStoreTests;

import org.junit.Before;
import org.junit.Test;
import task13_12_12_2017_GroceryStore.GroceryStore;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroceryStoreTest {
    GroceryStore groceryStore;

    @Before
    public void init() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        groceryStore = new GroceryStore();
    }

    @Test
    public void testCategoryInsertTest() {
        String categoryName = "fish";
        boolean b = false;
        groceryStore.createCategory(9, "fish");
        String result = groceryStore.selectCategoryById(9);
        System.out.println(result);
        if (result.toLowerCase().contains(categoryName.toLowerCase())) b = true;
        assertTrue(b);
    }

    @Test
    public void productInsertTest() {
        String productName = "salmon";
        boolean b = false;
        groceryStore.createProduct(11, 1, "salmon", 77);
        String result = groceryStore.selectProductById(11);
        System.out.println(result);
        groceryStore.deleteProduct(11);
        if (result.toLowerCase().contains(productName.toLowerCase())) b = true;
        assertTrue(b);
    }

    @Test
    public void deleteProductTest() {
        boolean b = false;
        groceryStore.createProduct(14, 1, "salmon", 77);
        groceryStore.deleteProduct(14);
        String result = groceryStore.selectProductById(14);
        System.out.println("String result ="+result);
        if (result.isEmpty()) b = true;
        assertTrue(b);
    }

    @Test
    public void deleteCategoryTest() {
        boolean b = false;
        groceryStore.createCategory(13, "fish");
        groceryStore.deleteCategory(13);
        String result = groceryStore.selectCategoryById(13);
        if (result.isEmpty()) b = true;
        assertTrue(b);
    }

    @Test
    public void selectCategoryByIdTest() {
        boolean b = false;
        String categoryName = "fish";
        groceryStore.createCategory(12, categoryName);
        String result = groceryStore.selectCategoryById(12);
        if (result.toLowerCase().contains(categoryName.toLowerCase())) b = true;
        groceryStore.deleteCategory(12);
        assertTrue(b);
    }

    @Test
    public void selectProductByIdTest() {
        boolean b = false;
        String productName = "banana";
        groceryStore.createProduct(10, 1, productName, 77);
        String result = groceryStore.selectProductById(10);
        if (result.toLowerCase().contains(productName.toLowerCase())) b = true;
        groceryStore.deleteProduct(10);
        assertTrue(b);
    }
    @Test
    public void selectAllCategoriesTest() {
        boolean b = false;
        String allCategories = groceryStore.selectAllCategories();
        if(!allCategories.isEmpty())b=true;
        assertTrue(b);
    }
    @Test
    public void updateProductPriceTest(){
        boolean b = false;
        String productName = "coconut";
        groceryStore.createProduct(20, 1, productName, 77);
        groceryStore.updateProductPrice(70,20);
        String result=groceryStore.selectProductById(20);
        String price="70";
        if (result.toLowerCase().contains(price.toLowerCase())) b = true;
        groceryStore.deleteProduct(20);
        assertTrue(b);
    }
    @Test
    public void updateProductNameTest(){
        boolean b = false;
        String productName = "coconut";
        groceryStore.createProduct(20, 1, productName, 77);
        groceryStore.updateProductName("coconuttt",20);
        String result=groceryStore.selectProductById(20);
        String name="coconuttt";
        if (result.toLowerCase().contains(name.toLowerCase())) b = true;
        groceryStore.deleteProduct(20);
        assertTrue(b);
    }
}
