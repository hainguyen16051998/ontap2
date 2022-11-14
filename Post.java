package entity;

import java.util.Scanner;

public class Post implements InputAble {
    public static int AUTO_ID = 100;
    private int id;
    private String name;
    private int price;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

     public void nhapThongTin() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên kiểu bài: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập đơn giá: ");
        this.price = new Scanner(System.in).nextByte();
    }
}
