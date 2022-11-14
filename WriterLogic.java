package LogicHandle;

import Run.MainRun;
import entity.Writer;

import java.util.Scanner;

public class WriterLogic {

    public static void showWriterInfo() {
        for (int i = 0; i < MainRun.writers.length; i++) {
            if (MainRun.writers[i] != null) {
                System.out.println(MainRun.writers[i]);
            }
        }
    }

    public static void addNewWriter() {
        int writerNum;
        System.out.print("Nhấp số lượng phóng viên muốn thêm mới: ");
        do {
            writerNum = new Scanner(System.in).nextByte();
            if (writerNum > 0)
                break;
            System.out.print("Số lượng phóng viên phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < writerNum; i++) {
            Writer writer = new Writer();
            writer.nhapThongTin();
            saveWriter(writer);
        }
    }

    public static void saveWriter(Writer writer) {
        for (int i = 0; i < MainRun.writers.length; i++) {
            if (MainRun.writers[i] == null) {
                MainRun.writers[i] = writer;
                break;
            }
        }
    }
}
