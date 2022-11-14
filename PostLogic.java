package LogicHandle;

import entity.Post;
import Run.MainRun;

import java.util.Scanner;

public class PostLogic {
    public static void showPostInfo() {
        for (int i = 0; i < MainRun.posts.length; i++) {
            if (MainRun.posts[i] != null)
                System.out.println(MainRun.posts[i]);
        }
    }

    public static void addNewPost() {
        int postNum;
        System.out.print("Nhấp số lượng bài viết muốn thêm mới: ");
        do {
            postNum = new Scanner(System.in).nextByte();
            if (postNum > 0)
                break;
            System.out.print("Số lượng bài viết phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < postNum; i++) {
            Post post = new Post();
            post.nhapThongTin();
            savePost(post);
        }
    }

    public static void savePost(Post post) {
        for (int i = 0; i < MainRun.posts.length; i++) {
            if (MainRun.posts[i] == null) {
                MainRun.posts[i] = post;
                break;
            }
        }
    }
}
