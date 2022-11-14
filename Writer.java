package entity;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import constant.WriterConstant;

import java.util.Scanner;

public class Writer extends Person {
    public static int AUTO_ID = 10000;
    private int id;
    private String level;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                ", level='" + level + '\'' +
                '}';
    }

    public void nhapThongTin() {
        super.nhapThongTin();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Mời chọn trình độ phóng viên");
        System.out.println("1. Chuyên nghiệp");
        System.out.println("2. Nghiệp dư");
        System.out.println("3. Cộng tác viên");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice < 4 && choice > 0) {
                break;
            }
            System.out.println("chọn sai, mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                this.level = WriterConstant.CHUYENNGHIEP.value;
                break;
            case 2:
                this.level = WriterConstant.NGHIEPDU.value;
                break;
            case 3:
                this.level = WriterConstant.CONGTACVIEN.value;
                break;

        }

    }

}
