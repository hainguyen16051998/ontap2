package LogicHandle;

import Run.MainRun;
import entity.Post;
import entity.PostDetail;
import entity.PostManagement;
import entity.Writer;

import java.util.Scanner;

public class PostManagementLogic {
    public static void addNewPostManagements() {
        if (!check()) {
            System.out.println("chưa có dữ liệu");
            return;
        }
        int writerNum;
        System.out.print("Bảng tính công cho bao nhiêu phóng viên: ");
        do {
            writerNum = new Scanner(System.in).nextByte();
            if (writerNum > 0)
                break;
            System.out.print("Số lượng phóng viên phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < writerNum; i++) {
            System.out.println("Nhập thông tin tính công cho phóng viên thứ " + (i + 1));
            System.out.println("Mã phóng viên cần tính công: ");
            Writer writer = null;
            int writerID = -1;
            do {
                writerID = new Scanner(System.in).nextInt();
                for (int k = 0; k < MainRun.writers.length; k++) {
                    if (MainRun.writers[k].getId() == writerID) {
                        writer = MainRun.writers[k];
                        break;
                    }
                }
                if (writer != null)
                    break;
                System.out.println("k có phóng viên nào mang mã " + writerID + " trong hệ thống, vui lòng nhập lại: ");
            } while (true);
            System.out.print("Nhập số lượng kiểu bài đã viết: ");
            int postNum;
            do {
                postNum = new Scanner(System.in).nextByte();
                if (postNum > 0 && postNum <= 5)
                    break;
                System.out.print("Số lượng bài viết phải là số dương và bé hơn 5, mời nhập lại: ");
            } while (true);
            PostDetail[] postDetails = new PostDetail[postNum];
            int count = 0;
            int total = 0;
            for (int j = 0; j < postNum; j++) {
                System.out.println("Nhập thông tin thể loại bài thứ " + (j + 1) + " mà phóng viên " + writer.getName() + " đã viết");
                System.out.print("Nhập id của loại bài viết thứ " + (j + 1) + ": ");
                Post post = null;
                int postID = -1;
                do {
                    postID = new Scanner(System.in).nextByte();
                    for (int k = 0; j < MainRun.posts.length; k++) {
                        if (MainRun.posts[k].getId() == postID) {
                            post = MainRun.posts[k];
                            break;
                        }
                    }
                    if (post == null) {
                        System.out.println("k có bài viết nào mang mã " + postID + " trong hệ thống, vui lòng nhập lại: ");
                        continue;
                    }

                    boolean xemdanhapchua = false;
                    for (int k = 0; k < count; k++) {
                        if (postDetails[k].getPost().getId() == postID) {
                            xemdanhapchua = true;
                            break;
                        }
                    }
                    if (!xemdanhapchua)
                        break;
                    System.out.println("loại này mới nhập, nhập loại khác: ");
                } while (true);
                System.out.print("Nhập số lượng bài ở thể loại này đã viết: ");
                int quatity = new Scanner(System.in).nextInt();
                postDetails[count] = new PostDetail(post, quatity);
                total += quatity;
                count++;
            }
            PostManagement postManagement = new PostManagement(writer, postDetails);
            postManagement.setTotalPost(total);
            savePostManagement(postManagement);

        }

    }

    private static boolean check() {
        boolean ValidPost = false;
        for (int i = 0; i < MainRun.posts.length; i++) {
            if (MainRun.posts[i] != null) {
                ValidPost = true;
                break;
            }
        }

        boolean ValidWriter = false;
        for (int i = 0; i < MainRun.writers.length; i++) {
            if (MainRun.posts[i] != null) {
                ValidWriter = true;
                break;
            }
        }
        return ValidPost && ValidWriter;
    }

    public static void savePostManagement(PostManagement postManagement) {
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            if (MainRun.postManagements[i] == null)
                MainRun.postManagements[i] = postManagement;
            break;
        }
    }

    public static void showPostManagementInfo() {
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            if (MainRun.postManagements[i] != null)
                System.out.println(MainRun.postManagements[i]);
            break;
        }
    }

    public static void sortWriterByName() {
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            for (int j = i + 1; j < MainRun.postManagements.length; j++) {
                PostManagement post1 = MainRun.postManagements[i];
                PostManagement post2 = MainRun.postManagements[j];
                if (post1.getWriter().getName().compareTo(post2.getWriter().getName()) > 1) {
                    PostManagement temp = post1;
                    post1 = post2;
                    post2 = temp;
                }
            }
        }
    }

    public static void sortPostNumber() {
        //tính tổng bài viết 1 phóng viên thực hiện
//        for (int i = 0; i < MainRun.postManagements.length; i++) {
//            PostManagement postManagement = MainRun.postManagements[i];
//            PostDetail[] postDetails = postManagement.getPostDetails();
//            int total = 0;
//            for (int j = 0; j < postDetails.length; j++) {
//                total += postDetails[j].getQuatity();
//            }
//            postManagement.setTotalPost(total);
//        }
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            for (int j = i + 1; j < MainRun.postManagements.length; j++) {
                PostManagement post1 = MainRun.postManagements[i];
                PostManagement post2 = MainRun.postManagements[j];
                if (post1.getTotalPost() < (post2.getTotalPost())) {
                    PostManagement temp = post1;
                    post1 = post2;
                    post2 = temp;

                }
            }
        }
    }

    public static void calculateSalarry() {
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            double salary = 0;
            Writer writer = MainRun.postManagements[i].getWriter();
            PostDetail[] postDetails = MainRun.postManagements[i].getPostDetails();
            for (int j = 0; j < postDetails.length; j++) {
                salary += postDetails[j].getPost().getPrice() * postDetails[j].getQuatity();
            }
            System.out.println("lương của phóng viên " + writer.getName() + " là: " + salary);
        }
    }
}
