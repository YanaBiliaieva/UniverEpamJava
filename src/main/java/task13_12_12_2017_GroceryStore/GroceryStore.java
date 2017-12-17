package task13_12_12_2017_GroceryStore;

import java.sql.*;
import java.util.Properties;

/**
 * @task Вариант 7 Продуктовый магазин. Объекты: Категория продукта, Продукт
 * Продукты в магазине сгруппированы по категориям. Для каждой категории определено множество продуктов.
 */
public class GroceryStore {
    private static final String url = "jdbc:mysql://localhost:3306/grocery";
    private Connection connection = null;
    private PreparedStatement statement = null;

    public GroceryStore() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, "root", "root");
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }
    //CREATE TABLE `grocery`.`categories` (ID_CA INTEGER NOT NULL, ID_PO INTEGER NOT NULL, NAME CHAR(32) NOT NULL);
    //CREATE TABLE `grocery`.`products` (ID_PO INTEGER NOT NULL, ID_CA INTEGER NOT NULL, NAME CHAR(32) NOT NULL, PRICE INTEGER);
    //ALTER TABLE `grocery`.`categories` ADD PRIMARY KEY (ID_CA);
    //ALTER TABLE `grocery`.`products` ADD PRIMARY KEY (ID_PO);
    //ALTER TABLE `grocery`.`products` ADD FOREIGN KEY (ID_CA) REFERENCES `grocery`.`categories` (ID_CA);
    //ALTER TABLE `grocery`.`categories` DROP COLUMN ID_PO;

    /*categories: fish, vegetables, meat, bread*/

    public void createCategory(int id, String name)  {

        try {
            statement = this.connection.prepareStatement("INSERT INTO categories VALUES (?,?);");
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.executeUpdate();
            System.out.println("categories " + name + " успешно добавлена!");

        } catch (SQLException e) {
            System.out.println("ОШИБКА! categories " + name +
                    " не добавлена!");
            System.out.println(" >> " + e.getMessage());
        }
    }

    public void deleteCategory(int categoryId) {
        try {
            statement = this.connection.prepareStatement("DELETE FROM categories WHERE ID_CA=" + categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot delete category with id=" + categoryId);
        }
    }
    /*products: salmon, apple, banana, baton,bulka, coconut*/
    public void createProduct(int id, int categoryId, String name, int price) {
        try{
            statement=this.connection.prepareStatement("INSERT INTO PRODUCTS VALUES (?,?,?,?);");
            statement.setInt(1,id);
            statement.setInt(2,categoryId);
            statement.setString(3,name);
            statement.setInt(4,price);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Cannot create product");e.printStackTrace();
        }

    }

    public void deleteProduct(int productId) {
        try {
            statement = this.connection.prepareStatement("DELETE FROM products WHERE ID_PO=" + productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot delete category with id=" + productId);
        }

    }
    public String selectCategoryById(int id) {
        try{
            statement=this.connection.prepareStatement("SELECT NAME FROM categories WHERE ID_CA=?;");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            StringBuilder builder=new StringBuilder();
            while (resultSet.next()){
                builder.append(resultSet.getString(1));
            }
            return builder.toString();
        }catch (SQLException e){
            System.out.println("Cannot select category with id=" + id); return null;

        }
    }
    public String selectProductById(int productId) {
        try{
            statement=this.connection.prepareStatement("SELECT NAME, PRICE, ID_CA FROM products WHERE ID_PO=?;");
            statement.setInt(1,productId);
            ResultSet resultSet=statement.executeQuery();
            StringBuilder builder=new StringBuilder();
            while (resultSet.next()){
                builder.append(resultSet.getString(1));
                builder.append(resultSet.getInt(2));
                builder.append(resultSet.getString(3));
                System.out.println("in builder");
            }
            return builder.toString();
        }catch (SQLException e){
            System.out.println("Cannot select product details of product number"+productId);return null;
        }
    }

    public String selectAllProducts() {
        try{
            statement=this.connection.prepareStatement("SELECT* FROM products;");
            ResultSet resultSet=statement.executeQuery();
            StringBuilder builder=new StringBuilder();
            while (resultSet.next()){
                builder.append(resultSet.getInt(1));
                builder.append(resultSet.getInt(2));
                builder.append(resultSet.getString(3));
                builder.append(resultSet.getInt(4));
            }
            return builder.toString();
        }catch (SQLException e){
            System.out.println("Cannot select all products.");
        }return null;

    }

    public String selectAllCategories() {
        try{
            statement=this.connection.prepareStatement("SELECT* FROM categories;");
            ResultSet resultSet=statement.executeQuery();
            StringBuilder builder=new StringBuilder();
            while (resultSet.next()){
                builder.append(resultSet.getInt(1));
                builder.append(resultSet.getString(2));
            }
            return builder.toString();
        }catch (SQLException e){
            System.out.println("Cannot select all categories.");
        }return null;
    }
    public void updateProductPrice(int price, int id){
        try{
            statement=this.connection.prepareStatement("UPDATE products SET price=? WHERE ID_PO=?;");
            statement.setInt(1,price);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Cannot update product price");
        }
    }
    public void updateProductName(String name, int id){
        try{
            statement=this.connection.prepareStatement("UPDATE products SET name=? WHERE ID_PO=?;");
            statement.setString(1,name);
            statement.setInt(2,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Cannot update product "+id);
        }
    }
    public void selectAllProductsAndCategories() throws SQLException {
        Statement statement = connection.createStatement();
        String sqlString = "SELECT * FROM categories T1 INNER JOIN products T2 ON T1.ID_CA = T2.ID_CA";
        ResultSet resultSet = statement.executeQuery(sqlString);
        System.out.println("List of categories:");
        while (resultSet.next()) {
            int id = resultSet.getInt("ID_CA");
            String name = resultSet.getString("NAME");
            System.out.println(" >> " + id + " - " + name);
        }
        resultSet.close();
        //SELECT * FROM CITIES T1 INNER JOIN COUNTRIES T2 ON T1.ID_CO = T2.ID_CO;
    }

    public void stop() throws SQLException {
        connection.close();
    }
}
