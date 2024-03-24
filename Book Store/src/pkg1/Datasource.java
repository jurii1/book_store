/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juri
 */
public class Datasource {
    public static final String DB_NAME = "book_store.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Juri\\Documents\\NetBeansProjects\\Book Store\\" + DB_NAME;
    
    public static final int DEFAULT_CREDITS = 0;
    
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERS_ID = "_id";
    public static final String COLUMN_USERS_NAME = "name";
    public static final String COLUMN_USERS_LAST_NAME = "last_name";
    public static final String COLUMN_USERS_EMAIL = "email";
    public static final String COLUMN_USERS_PASSWORD = "password";
    public static final String COLUMN_USERS_CREDITS = "credits";
    public static final int INDEX_USERS_ID = 1;
    public static final int INDEX_USERS_NAME = 2;
    public static final int INDEX_USERS_LAST_NAME = 3;
    public static final int INDEX_USERS_EMAIL = 4;
    public static final int INDEX_USERS_PASSWORD = 5;
    public static final int INDEX_USERS_CREDITS = 6;
    
    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_BOOKS_ISBN = "_isbn";
    public static final String COLUMN_BOOKS_TITLE = "title";
    public static final String COLUMN_BOOKS_YEAR = "year";
    public static final String COLUMN_BOOKS_PRICE = "price";
    public static final String COLUMN_BOOKS_AUTHOR_ID = "author_id";
    public static final int INDEX_BOOKS_ISBN = 1;
    public static final int INDEX_BOOKS_TITLE = 2;
    public static final int INDEX_BOOKS_YEAR = 3;
    public static final int INDEX_BOOKS_PRICE = 4;
    public static final int INDEX_BOOKS_AUTHOR_ID = 5;
    
    public static final String TABLE_AUTHORS = "authors";
    public static final String COLUMN_AUTHORS_ID = "_id";
    public static final String COLUMN_AUTHORS_NAME = "name";
    public static final String COLUMN_AUTHORS_LAST_NAME = "last_name";
    public static final int INDEX_AUTHORS_ID = 1;
    public static final int INDEX_AUTHORS_NAME = 2;
    public static final int INDEX_AUTHORS_LAST_NAME = 3;
    
    public static final String TABLE_TRANSACTIONS = "transactions";
    public static final String COLUMN_TRANSACTIONS_ID = "_id";
    public static final String COLUMN_TRANSACTIONS_USER_ID = "user_id";
    public static final String COLUMN_TRANSACTIONS_BOOK_ISBN = "book_isbn";
    public static final int INDEX_TRANSACTIONS_ID = 1;
    public static final int INDEX_TRANSACTIONS_USER_ID = 2;
    public static final int INDEX_TRANSACTIONS_BOOK_ISBN = 3;
    
    public static final String TABLE_COUPONS = "coupons";
    public static final String COLUMN_COUPONS_ID = "_id";
    public static final String COLUMN_COUPONS_CREDITS = "credits";
    public static final int INDEX_COUPONS_ID = 1;
    public static final int INDEX_COUPONS_CREDITS = 2;
    
    public static final String BOUGHT_BOOKS_VIEW = "bought_books_list";
    public static final String BOOKS_AUTHORS_VIEW = "books_authors_list";
    
    public static final String INSERT_USER = "INSERT INTO " + TABLE_USERS +
            '(' + COLUMN_USERS_NAME + ", " + COLUMN_USERS_LAST_NAME + ", " + COLUMN_USERS_EMAIL + ", " + COLUMN_USERS_PASSWORD + ", " + COLUMN_USERS_CREDITS +
            ") VALUES(?, ?, ?, ?, ?)";
    
    public static final String INSERT_BOOK = "INSERT INTO " + TABLE_BOOKS +
            '(' + COLUMN_BOOKS_ISBN + ", " + COLUMN_BOOKS_TITLE + ", " + COLUMN_BOOKS_YEAR + ", " + COLUMN_BOOKS_PRICE + ", " + COLUMN_BOOKS_AUTHOR_ID +
            ") VALUES(?, ?, ?, ?, ?)";
    
    public static final String INSERT_AUTHOR = "INSERT INTO " + TABLE_AUTHORS +
            '(' + COLUMN_AUTHORS_NAME + ", " + COLUMN_AUTHORS_LAST_NAME +
            ") VALUES(?, ?)";
    
    public static final String INSERT_TRANSACTION = "INSERT INTO " + TABLE_TRANSACTIONS +
            '(' + COLUMN_TRANSACTIONS_USER_ID + ", " + COLUMN_TRANSACTIONS_BOOK_ISBN +
            ") VALUES(?, ?)";
    
    public static final String INSERT_COUPON = "INSERT INTO " + TABLE_COUPONS +
            '(' + COLUMN_COUPONS_CREDITS +
            ") VALUES(?)";
    
    public static final String QUERY_COUPONS = "SELECT * FROM " +
            TABLE_COUPONS;
    
    public static final String QUERY_COUPONS_BY_ID = "SELECT * FROM " +
            TABLE_COUPONS + 
            " WHERE " + COLUMN_COUPONS_ID + " = ?";
    
    public static final String QUERY_BOUGHT_BOOKS_VIEW = "SELECT " + COLUMN_BOOKS_TITLE + ", " +
            COLUMN_AUTHORS_NAME + ", " + COLUMN_AUTHORS_LAST_NAME + ", " + COLUMN_BOOKS_YEAR + " FROM " + BOUGHT_BOOKS_VIEW +
            " WHERE " + COLUMN_TRANSACTIONS_USER_ID + " = ?";
    
    public  final String QUERY_BOOKS_AUTHORS_VIEW_FROM_TITLE = "SELECT " + COLUMN_BOOKS_TITLE + ", " +
            COLUMN_AUTHORS_NAME + ", " + COLUMN_AUTHORS_LAST_NAME + ", " + COLUMN_BOOKS_YEAR + ", " + COLUMN_BOOKS_ISBN + ", " + COLUMN_BOOKS_PRICE + " FROM " + BOOKS_AUTHORS_VIEW +
            " WHERE " + COLUMN_BOOKS_TITLE + " like UPPER(?) COLLATE NOCASE";
    
    public static final String QUERY_BOOKS_AUTHORS_VIEW_FROM_AUTHOR = "SELECT " + COLUMN_BOOKS_TITLE + ", " +
            COLUMN_AUTHORS_NAME + ", " + COLUMN_AUTHORS_LAST_NAME + ", " + COLUMN_BOOKS_YEAR + ", " + COLUMN_BOOKS_ISBN + ", " + COLUMN_BOOKS_PRICE + " FROM " + BOOKS_AUTHORS_VIEW +
            " WHERE UPPER(" + COLUMN_AUTHORS_NAME + ") = UPPER(?)" + " AND UPPER(" + COLUMN_AUTHORS_LAST_NAME + ") = UPPER(?)";
    
    public static final String QUERY_USERS_BY_ID = "SELECT " + COLUMN_USERS_NAME + ", " +
            COLUMN_USERS_LAST_NAME + ", " + COLUMN_USERS_EMAIL + ", "+ COLUMN_USERS_CREDITS + " FROM " + TABLE_USERS +
            " WHERE " + COLUMN_USERS_ID + " = ?";
    
    public static final String QUERY_USERS_BY_EMAIL = "SELECT " + COLUMN_USERS_ID + ", " + COLUMN_USERS_NAME + ", " +
            COLUMN_USERS_LAST_NAME + ", " + COLUMN_USERS_EMAIL + ", "+ COLUMN_USERS_CREDITS + " FROM " + TABLE_USERS +
            " WHERE " + COLUMN_USERS_EMAIL + " = ?";
    
    public static final String QUERY_AUTHORS = "SELECT * FROM " + TABLE_AUTHORS + 
            " WHERE " + COLUMN_AUTHORS_NAME + " = ?" + " AND " + COLUMN_AUTHORS_LAST_NAME + " = ?";
    
    public static final String QUERY_AUTHORS_BY_ID = "SELECT * FROM " + TABLE_AUTHORS + 
            " WHERE " + COLUMN_AUTHORS_ID + " = ?";
    
    public static final String QUERY_BOOKS_BY_ISBN = "SELECT " + COLUMN_BOOKS_TITLE  +
             ", " + COLUMN_BOOKS_YEAR + " FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOKS_ISBN + " = ?";
    
    public static final String QUERY_CREDITS = "SELECT " + COLUMN_USERS_CREDITS + 
             " FROM " + TABLE_USERS +
            " WHERE " + COLUMN_USERS_ID + " = ?";
    
    public static final String QUERY_CREDITS_FROM_COUPONS = "SELECT * "  + 
             " FROM " + TABLE_COUPONS +
            " WHERE " + COLUMN_COUPONS_ID + " = ?";
     
    public static final String QUERY_PRICE_BY_ISBN = "SELECT " + COLUMN_BOOKS_PRICE  +
               " FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOKS_ISBN + " = ?";
    /*UPDATE users
SET credits = credits - 5
WHERE _id = 2*/
    public static final String UPDATE_CREDITS_DECREASE = "UPDATE " + TABLE_USERS  +
               " SET " + COLUMN_USERS_CREDITS + " = " + COLUMN_USERS_CREDITS + " - ?" +
            " WHERE " + COLUMN_USERS_ID + " = ?";
    
    public static final String UPDATE_CREDITS_ICREASE = "UPDATE " + TABLE_USERS  +
               " SET " + COLUMN_USERS_CREDITS + " = " + COLUMN_USERS_CREDITS + " + ?" +
            " WHERE " + COLUMN_USERS_ID + " = ?";

    public static final String DELETE_COUPON = "DELETE FROM " + TABLE_COUPONS  +
            " WHERE " + COLUMN_COUPONS_ID + " = ?";
    
    /*SELECT _id, name, last_name, credits FROM users 
WHERE email = "juri@gmail.com"
AND password = "123asdf"*/
    public static final String QUERY_USER_BY_EMAIL_PASSWORD = "SELECT " + COLUMN_USERS_ID + ", "  + COLUMN_USERS_NAME + ", " +
             COLUMN_USERS_LAST_NAME + ", " + COLUMN_USERS_CREDITS +
               " FROM " + TABLE_USERS +
            " WHERE " + COLUMN_USERS_EMAIL + " = ? AND " + COLUMN_USERS_PASSWORD + " = ?";
    
    /*SELECT * FROM transactions WHERE user_id = ? AND book_isbn = ?*/
    public static final String QUERY_TRANSACTIONSS = "SELECT * " + 
               " FROM " + TABLE_TRANSACTIONS +
            " WHERE " + COLUMN_TRANSACTIONS_USER_ID + " = ? AND " + COLUMN_TRANSACTIONS_BOOK_ISBN + " = ?";
    
    
    
    private Connection conn;

    private PreparedStatement insertIntoUsers;
    private PreparedStatement insertIntoBooks;
    private PreparedStatement insertIntoAuthors;
    private PreparedStatement insertIntoTransactions;
    private PreparedStatement insertIntoCoupons;

    private PreparedStatement queryCoupons;
    private PreparedStatement queryCouponsById;
    private PreparedStatement queryBoughtBooksView;
    private PreparedStatement queryBooksAuthorsViewFromTitle;
    private PreparedStatement queryBooksAuthorsViewFromAuthor;
    private PreparedStatement queryUsersById;
    private PreparedStatement queryUsersByEmail;
    private PreparedStatement queryAuthors;
    private PreparedStatement queryAuthorsById;
    private PreparedStatement queryBooksByIsbn;
    private PreparedStatement queryCredits;
    private PreparedStatement queryCreditsFromCoupons;
    private PreparedStatement queryPrice;
    private PreparedStatement updateCreditsDecrease;
    private PreparedStatement updateCreditsIncrease;
    private PreparedStatement deleteCoupon;
    private PreparedStatement queryUsersByEmailPassword;
    private PreparedStatement queryTransactions;

    private static Datasource instance = new Datasource();
    
    private Datasource(){}
    
    public static Datasource getInstance (){
        return instance;
        //Datasource.getInstance().methodName();
    }
    
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoUsers = conn.prepareStatement(INSERT_USER);
            insertIntoBooks = conn.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);
            insertIntoAuthors = conn.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            insertIntoTransactions = conn.prepareStatement(INSERT_TRANSACTION);
            insertIntoCoupons = conn.prepareStatement(INSERT_COUPON);
            
            queryCoupons = conn.prepareStatement(QUERY_COUPONS);
            queryCouponsById = conn.prepareStatement(QUERY_COUPONS_BY_ID);
            queryBoughtBooksView = conn.prepareStatement(QUERY_BOUGHT_BOOKS_VIEW);
            queryBooksAuthorsViewFromTitle = conn.prepareStatement(QUERY_BOOKS_AUTHORS_VIEW_FROM_TITLE);
            queryBooksAuthorsViewFromAuthor = conn.prepareStatement(QUERY_BOOKS_AUTHORS_VIEW_FROM_AUTHOR);
            queryUsersById = conn.prepareStatement(QUERY_USERS_BY_ID);
            queryUsersByEmail = conn.prepareStatement(QUERY_USERS_BY_EMAIL);
            queryAuthors = conn.prepareStatement(QUERY_AUTHORS);
            queryAuthorsById = conn.prepareStatement(QUERY_AUTHORS_BY_ID);
            queryBooksByIsbn = conn.prepareStatement(QUERY_BOOKS_BY_ISBN);
            queryCredits = conn.prepareStatement(QUERY_CREDITS);
            queryCreditsFromCoupons = conn.prepareStatement(QUERY_CREDITS_FROM_COUPONS);
            queryPrice = conn.prepareStatement(QUERY_PRICE_BY_ISBN);
            updateCreditsDecrease = conn.prepareStatement(UPDATE_CREDITS_DECREASE);
            updateCreditsIncrease = conn.prepareStatement(UPDATE_CREDITS_ICREASE);
            deleteCoupon = conn.prepareStatement(DELETE_COUPON);
            queryUsersByEmailPassword = conn.prepareStatement(QUERY_USER_BY_EMAIL_PASSWORD);
            queryTransactions = conn.prepareStatement(QUERY_TRANSACTIONSS);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if(insertIntoUsers != null) {
                insertIntoUsers.close();
            }

            if(insertIntoBooks != null) {
                insertIntoBooks.close();
            }

            if(insertIntoAuthors != null) {
                insertIntoAuthors.close();
            }

            if(insertIntoTransactions !=  null) {
                insertIntoTransactions.close();
            }

            if(insertIntoCoupons != null) {
                insertIntoCoupons.close();
            }

            if(queryCoupons != null) {
                queryCoupons.close();
            }
            if(queryCouponsById != null) {
                queryCouponsById.close();
            }
            if(queryBoughtBooksView != null) {
                queryBoughtBooksView.close();
            }
            if(queryBooksAuthorsViewFromTitle != null) {
                queryBooksAuthorsViewFromTitle.close();
            }
            if(queryBooksAuthorsViewFromAuthor != null) {
                queryBooksAuthorsViewFromAuthor.close();
            }
            if(queryUsersById != null) {
                queryUsersById.close();
            }
            if(queryUsersByEmail != null) {
                queryUsersByEmail.close();
            }
            
            if(queryAuthors != null) {
                queryAuthors.close();
            }
            if(queryAuthorsById != null) {
                queryAuthorsById.close();
            }
            if(queryBooksByIsbn != null) {
                queryBooksByIsbn.close();
            }
            if(queryCredits != null) {
                queryCredits.close();
            }
             if(queryCreditsFromCoupons != null) {
                queryCreditsFromCoupons.close();
            }
            if(queryPrice != null) {
                queryPrice.close();
            }
            if(updateCreditsDecrease != null) {
                updateCreditsDecrease.close();
            }
            if(updateCreditsIncrease != null) {
                updateCreditsIncrease.close();
            }
            if(deleteCoupon != null) {
                deleteCoupon.close();
            }
            if(queryUsersByEmailPassword != null) {
                queryUsersByEmailPassword.close();
            }
            if(queryTransactions != null) {
                queryTransactions.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }
    
    
    public int insertUser(String name, String lastName, String email, String password) throws SQLException {

        queryUsersByEmail.setString(1, email);
        ResultSet results = queryUsersByEmail.executeQuery();
        if(!validateName(name))
            throw new SQLException("Enter a valid name!"); 
        if(!validateLastName(lastName))
            throw new SQLException("Enter a valid last name!"); 
        if(!validateEmail(email))
            throw new SQLException("Enter a valid email!"); 
        if(!validatePassword(password))
            throw new SQLException("Enter a valid last password!"); 
        if(results.next()) {
            throw new SQLException("This email is already registered!");
        } else {
            // Insert the user
            insertIntoUsers.setString(1, name);
            insertIntoUsers.setString(2, lastName);
            insertIntoUsers.setString(3, email);
            insertIntoUsers.setString(4, password);
            insertIntoUsers.setInt(5, DEFAULT_CREDITS);
            int affectedRows = insertIntoUsers.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert user!");
            }

            ResultSet generatedKeys = insertIntoUsers.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for user!");
            }
        }
    }
    
    public int insertAuthor(String name, String lastName) throws SQLException {

        queryAuthors.setString(1, name);
        queryAuthors.setString(2, lastName);
        ResultSet results = queryAuthors.executeQuery();
        
        if(!validateName(name))
            throw new SQLException("Enter a valid name!"); 
        if(!validateLastName(lastName))
            throw new SQLException("Enter a valid last name!"); 
        if(results.next()) {
            throw new SQLException("This author is already registered!!");
        } else {
            // Insert the author
            insertIntoAuthors.setString(1, name);
            insertIntoAuthors.setString(2, lastName);

            int affectedRows = insertIntoAuthors.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert author!");
            }

            ResultSet generatedKeys = insertIntoAuthors.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for author!");
            }
        }
    }
    
    public int insertBook(String isbn, String title, int year, int price, int author_id) throws SQLException {

        queryAuthorsById.setInt(1, author_id);
        queryBooksByIsbn.setString(1, isbn);
        ResultSet results = queryAuthorsById.executeQuery();
        ResultSet results2 = queryBooksByIsbn.executeQuery();
        
        
        if(!validateISBN(isbn))
            throw new SQLException("Enter a valid ISBN format!"); 
        if(year <= 0)
            throw new SQLException("Enter a valid year!");
        if(!results.next()) {
            throw new SQLException("Enter a correct author ID!");
            
        } else if(results2.next()){
            throw new SQLException("This book is already stored in database!");
        }
        else {
            // Insert the book
            insertIntoBooks.setString(1, isbn);
            insertIntoBooks.setString(2, title);
            insertIntoBooks.setInt(3, year);
            insertIntoBooks.setInt(4, price);
            insertIntoBooks.setInt(5, author_id);
            
            int affectedRows = insertIntoBooks.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert book!");
            }

            ResultSet generatedKeys = insertIntoBooks.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for books");
            }
        }
    }
    
    public int insertTransaction(int id, String isbn) throws SQLException {
        
        queryUsersById.setInt(1, id);
        ResultSet results = queryUsersById.executeQuery();
        queryBooksByIsbn.setString(1, isbn);
        ResultSet results2 = queryBooksByIsbn.executeQuery();
        queryTransactions.setInt(1, id);
        queryTransactions.setString(2, isbn);
        ResultSet tr = queryTransactions.executeQuery();
        
        if(!validateISBN(isbn))
            throw new SQLException("Enter a valid ISBN format!");
        if(!results.next()) {
            return results.getInt(1);
        } else if (!results2.next()){
            throw new SQLException("We do not have the book you are looking for!");
        } 
        else if (tr.next()){
            throw new SQLException("You have already bought this book!");
            //return tr.getInt(1);
        } 
        else if (!enoughCredits(id, isbn)){
            throw new SQLException("You do not have enough credits");
        } 
        else{
            
            insertIntoTransactions.setInt(1, id);
            insertIntoTransactions.setString(2, isbn);
  
            int affectedRows = insertIntoTransactions.executeUpdate();
            
            queryPrice.setString(1, isbn);
            ResultSet priceResult = queryPrice.executeQuery();
            int price = priceResult.getInt(COLUMN_BOOKS_PRICE);
            
            updateCreditsDecrease.setInt(1, price);
            updateCreditsDecrease.setInt(2, id);
            
            updateCreditsDecrease.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't make transaction!");
            }

            ResultSet generatedKeys = insertIntoTransactions.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for transaction");
            }
        }
    }
    
    public int insertCoupons(int credits) throws SQLException {

            if(credits <= 0)
                throw new SQLException("Enter a valid price!");
            // Insert the coupon
            insertIntoCoupons.setInt(1, credits);
            
            
            int affectedRows = insertIntoCoupons.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert coupon!");
            }

            ResultSet generatedKeys = insertIntoCoupons.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for coupon!");
            }
        
    }
    
    public int reedemCoupon(int user_id, int coupon_id) throws SQLException {

        queryCouponsById.setInt(1, coupon_id);
        ResultSet results = queryCouponsById.executeQuery();
        if(!results.next()) {
            throw new SQLException("Please enter a valid coupon!");
        } else {
            queryCreditsFromCoupons.setInt(1, coupon_id);
            ResultSet creditsResult = queryCreditsFromCoupons.executeQuery();
            int credits = creditsResult.getInt(COLUMN_COUPONS_CREDITS);
            
            updateCreditsIncrease.setInt(1, credits);
            updateCreditsIncrease.setInt(2, user_id);

            int affectedRows = updateCreditsIncrease.executeUpdate();
            
            deleteCoupon.setInt(1, coupon_id);
            deleteCoupon.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't reedem coupon!");
            }

            ResultSet generatedKeys = updateCreditsIncrease.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for coupon");
            }
        }
    }
   
    public int getCredits(int user_id) throws SQLException {

 
            queryCredits.setInt(1, user_id);
            ResultSet creditsResult = queryCredits.executeQuery();
            int credits = creditsResult.getInt(COLUMN_USERS_CREDITS);
            
 
            return credits;     
    }
    
    public int getId(String email) throws SQLException {

 
            queryUsersByEmail.setString(1,email);
            ResultSet creditsResult = queryUsersByEmail.executeQuery();
            int id = creditsResult.getInt(COLUMN_USERS_ID);
            
 
            return id;     
    }
    public String getName(String email) throws SQLException {

 
            queryUsersByEmail.setString(1,email);
            ResultSet creditsResult = queryUsersByEmail.executeQuery();
            String name = creditsResult.getString(COLUMN_USERS_NAME);
            
 
            return name;     
    }
    public String getLastName(String email) throws SQLException {

 
            queryUsersByEmail.setString(1,email);
            ResultSet creditsResult = queryUsersByEmail.executeQuery();
            String lastname = creditsResult.getString(COLUMN_USERS_LAST_NAME);
            
 
            return lastname;     
    }
    
    public boolean loginCompleted(String email, String password) throws SQLException{
  
        queryUsersByEmail.setString(1, email);
        ResultSet results = queryUsersByEmail.executeQuery();

        if(!results.next()) {
            return false;
        }
        
        queryUsersByEmailPassword.setString(1, email);
        queryUsersByEmailPassword.setString(2, password);
        ResultSet result = queryUsersByEmailPassword.executeQuery();
  
        if(result.next()) {
            return true;
        }
        else
            return false;
    }
    
    public boolean enoughCredits(int id, String isbn) throws SQLException{
        
        boolean possible = false;
        
        queryUsersById.setInt(1, id);
        ResultSet results = queryUsersById.executeQuery();
        queryBooksByIsbn.setString(1, isbn);
        ResultSet results2 = queryBooksByIsbn.executeQuery();
        if(!results.next()) {
            return possible;
        }
        if (!results2.next()){
            return possible;
        } 
        queryCredits.setInt(1, id);
        queryPrice.setString(1, isbn);
        ResultSet creditsResult = queryCredits.executeQuery();
        ResultSet priceResult = queryPrice.executeQuery();
        int price, credits;
        price= priceResult.getInt(COLUMN_BOOKS_PRICE);
        credits= creditsResult.getInt(COLUMN_USERS_CREDITS);
        
        
        if (credits >= price){
            possible = true;
            return possible;
        }
        else
            return possible;
    }
    
    
    public List<Coupon> queryCouponsList() {

        try {
            
            ResultSet results = queryCoupons.executeQuery();

            List<Coupon> coupons = new ArrayList<>();
            while (results.next()) {
                Coupon coupon = new Coupon(results.getInt(1), results.getInt(2));         
                coupons.add(coupon);
            }

            return coupons;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    
    public List<BookAuthor> queryBoughtBooksView(int id) {

        try {
            queryBoughtBooksView.setInt(1, id);
            ResultSet results = queryBoughtBooksView.executeQuery();

            List<BookAuthor> b = new ArrayList<>();
            while (results.next()) {
                BookAuthor boughtBook = new BookAuthor(results.getString(1), results.getString(2), results.getString(3), results.getInt(4));
                b.add(boughtBook);
            }

            return b;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    
    public List<BookAuthor> queryBooksAuthorsViewFromTitle(String title) {

        try {
            queryBooksAuthorsViewFromTitle.setString(1, "%"+title+"%");
            ResultSet results = queryBooksAuthorsViewFromTitle.executeQuery();
            
            List<BookAuthor> b = new ArrayList<>();
            while (results.next()) {
                BookAuthor bookAuthor = new BookAuthor(results.getString(1),results.getString(2),results.getString(3), results.getInt(4), results.getString(5), results.getInt(6));
                b.add(bookAuthor);
            }

            return b;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    
    public List<BookAuthor> queryBooksAuthorsViewFromAuthor(String name, String lastName) {

        try {
            queryBooksAuthorsViewFromAuthor.setString(1, name);
            queryBooksAuthorsViewFromAuthor.setString(2, lastName);
            ResultSet results = queryBooksAuthorsViewFromAuthor.executeQuery();
            
            
            List<BookAuthor> b = new ArrayList<>();
            while (results.next()) {
                BookAuthor bookAuthor = new BookAuthor(results.getString(1),results.getString(2),results.getString(3), results.getInt(4), results.getString(5), results.getInt(6));
                b.add(bookAuthor);
            }

            return b;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    
    public int getBooksCount(int id) {
        /*SELECT count(*) FROM bought_books_list WHERE user_id = 4*/
        String sql = "SELECT count(*) FROM " + BOUGHT_BOOKS_VIEW + " WHERE user_id = " + id;
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt(1);

            return count;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }
    
    public boolean validateName(String name){
      return name.matches("[A-Z][a-z]+");
    }
    public boolean validateLastName(String name){
      return name.matches("[A-Z][a-z]+");
    }
    public boolean validateISBN(String name){
      return name.matches("\\d+-\\d+-\\d+-\\d+(-\\d+)*");
    }
    public boolean validateEmail(String name){
        if((name.contains("@") && name.endsWith(".com")) || (name.contains("@") && name.endsWith(".al")))
            return true;
        else
            return false;
    }
    public boolean validatePassword(String name){
      return name.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
