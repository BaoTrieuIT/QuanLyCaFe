package Utils;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Image;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class XImage {

    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/Image/logo.jpg");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("image", src.getName());
        if (!dst.exists()) {
            dst.mkdirs();
            // tạo thư mục logo nếu chưa tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            // Copy file vào thư mục logo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("image", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }

     public static void saveAvartars(File src) {
        File dst = new File("avatars", src.getName());
        if (!dst.exists()) {
            dst.mkdirs();
            // tạo thư mục logo nếu chưa tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            // Copy file vào thư mục logo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ImageIcon readAvatars(String fileName) {
        File path = new File("avatars", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }
    public static void saveProducts(File src) {
        File dst = new File("products", src.getName());
        if (!dst.exists()) {
            dst.mkdirs();
            // tạo thư mục logo nếu chưa tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            // Copy file vào thư mục logo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ImageIcon readProducts(String fileName) {
        File path = new File("products", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }
}
