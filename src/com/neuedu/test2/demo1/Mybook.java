package com.neuedu.test2.demo1;

/**
 * @author ldamei
 * @date 2020/2/10 14:45
 */
public class Mybook {
    private String name;  // 书名
    private Double price;  // 价格
    private String press;  // 出版社
    private String author;  // 作者
    private String bookISBN;  // ISBN号

   /* public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public Mybook[] getBooks() {
        return books;
    }

    public void setBooks(Mybook[] books) {
        this.books = books;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }*/

    public Mybook(String name, double price,String press,String author,String bookISBN){
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
        this.bookISBN = bookISBN;
    }
}
