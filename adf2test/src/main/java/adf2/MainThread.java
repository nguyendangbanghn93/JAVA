package adf2;

import adf2.entity.Account;
import adf2.helper.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) throws SQLException {
        truncate();
        seeding();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChương trình Quản lý Account:");
            System.out.println("1. Hiển thị thông tin account.");
            System.out.println("2. Thoát chương trình");
            System.out.print("Chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    printAcc();
                    break;
                case "2":
                    System.out.println("Xin chào hẹn gặp lại!!!");
                    return;
                default:
                    System.out.println("Mục bạn nhập không có yêu cầu nhập lại:");
                    break;
            }
        }

    }

    // Insert vào bảng accounts 10 bản ghi.
    public static void seeding() {
        save(new Account("Hùng", "Hùng123", "Hoàng MẠnh Hùng", "04/04/2002"));
        save(new Account("Mạnh", "Mạnh123", "Hoàng MẠnh Mạnh", "04/04/2020"));
        save(new Account("Long", "Long123", "Hoàng MẠnh Long", "04/04/2020"));
        save(new Account("Nam", "Nam123", "Hoàng MẠnh Nam", "04/04/2020"));
        save(new Account("Hải", "Hải123", "Hoàng MẠnh Hải", "04/04/2020"));
        save(new Account("Bằng", "Bằng123", "Hoàng MẠnh Bằng", "04/04/2020"));
        save(new Account("Dũng", "Dũng123", "Hoàng MẠnh Dũng", "04/04/2020"));
        save(new Account("Nghĩa", "Nghĩa123", "Hoàng MẠnh Nghĩa", "04/04/2020"));
        save(new Account("Đô", "Đô123", "Hoàng MẠnh Đô", "04/04/2020"));
        save(new Account("Huấn", "Huấn123", "Hoàng MẠnh Huấn", "04/04/2020"));
    }

    public static boolean save(Account acc) {
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection()
                    .prepareStatement("insert into account (username, password, fullName, createdDate) values (?,?,?,?)");
            preparedStatement.setString(1, acc.getUsername());
            preparedStatement.setString(2, acc.getPassword());
            preparedStatement.setString(3, acc.getFullName());
            preparedStatement.setString(4, acc.getCreatedDate());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
    }

    public static void printAcc() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Account account = null;
            System.out.print("Nhập username:");
            String username = scanner.nextLine();
            System.out.print("Nhập password:");
            String password = scanner.nextLine();
            try {
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement("select * from account WHERE username = ? AND password = ?");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String u = resultSet.getString("username");
                    String p = resultSet.getString("password");
                    String f = resultSet.getString("fullName");
                    String c = resultSet.getString("createdDate");
                    account = new Account(u, p, f, c);
                }
            } catch (Exception ex) {
                System.err.println("Không thể lấy dữ liệu từ database. Message: " + ex.getMessage());
            }
            if (account == null) {
                System.out.print("Tải khoản bạn nhập không tồng tại!");
            } else {
                System.out.println("\nThông tin tài khoản vừa nhập là: ");
                System.out.println("Username: " + account.getUsername());
                System.out.println("Password: " + account.getPassword());
                System.out.println("Full name: " + account.getFullName());
                System.out.println("Created date: " + account.getCreatedDate() + "\n");
            }
            System.out.println("\nBạn có muốn nhập tiếp: (y/n)");
            String choose = scanner.nextLine();
            if (choose.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    public static void truncate() throws SQLException {
        Statement stt = ConnectionHelper.getConnection().createStatement();
        stt.execute("TRUNCATE table account");
    }
}
