package Run;

import LogicHandle.PostLogic;
import LogicHandle.PostManagementLogic;
import LogicHandle.WriterLogic;
import entity.Post;
import entity.PostDetail;
import entity.PostManagement;
import entity.Writer;

import java.util.Scanner;

public class MainRun {

    public static Writer[] writers = new Writer[100];
    public static Post[] posts = new Post[100];
    public static PostManagement[] postManagements = new PostManagement[100];

    public static void main(String[] args) {


        menu();
    }

    private static void menu() {
        while (true) {
            showMenu();
            int functionchoice = functionchoice();

            switch (functionchoice) {
                case 1:
                    WriterLogic.addNewWriter();
                    break;
                case 2:
                    WriterLogic.showWriterInfo();
                    break;
                case 3:
                    PostLogic.addNewPost();
                    break;
                case 4:
                    PostLogic.showPostInfo();
                    break;
                case 5:
                    PostManagementLogic.addNewPostManagements();
                    PostManagementLogic.showPostManagementInfo();
                    break;
                case 6:
                    showSortMenu();
                    break;
                case 7:
                    PostManagementLogic.calculateSalarry();
                    break;
                case 8:
                    return;
            }
        }
    }



    private static void showSortMenu() {
        System.out.print("Chọn tiêu chí sắp xếp: ");
        System.out.println("1. Theo họ tên");
        System.out.println("2. Theo số lượng bài viết giảm dần");
        System.out.println("Thoát ra ngoài Menu chính");
        System.out.println(" Chọn: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.print("nhập lại tiêu chí: ");
        } while (true);
        switch (choice) {
            case 1:
                PostManagementLogic.sortWriterByName();
                break;
            case 2:
                PostManagementLogic.sortPostNumber();
                break;
            case 3:
                return;
        }
    }


    private static void showMenu() {
        System.out.println("-----PHẦN MỀM QUẢN LÝ TRẢ NHUẬN BÚT CHO PHÓNG VIÊN-----");
        System.out.println("1. Nhập danh sách phóng viên: ");
        System.out.println("2. In ra danh sách phóng viên mới");
        System.out.println("3, Nhập danh sách bài viết");
        System.out.println("4. In ra danh sách bài viết mới");
        System.out.println("5. Lập bảng tính công cho phóng viên");
        System.out.println("6. Sắp xếp danh sách bảng tính công");
        System.out.println("7. Lập bảng kê thu nhập của mỗi phóng viên");
        System.out.println("8.Thoát");
        System.out.print("Mời chọn chức năng: ");
    }

    private static int functionchoice() {
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextByte();
            if (choice > 0 && choice <= 8)
                break;
            System.out.print("nhập sai, mời nhập lại: ");
        } while (true);
        return choice;
    }

}
