import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ResultSet rs = null;
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week6", "root", "Liyihan090311");
            //第一题
            Statement statement = connection.createStatement();
            String insert = "insert into student values('s001','老大',20,'计算机学院'),('s002','老二',19,'计算机学院'),('s003','老三',18,'计算机学院'),('s004','老四',17,'计算机学院')";
            statement.executeUpdate(insert);
            //第二题
            String infor = "select * from student";
            rs = statement.executeQuery(infor);
            while (rs.next()) {
                String sno = rs.getString(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String College = rs.getString(4);
                System.out.println(sno + ',' + name + ',' + age + ',' + College);
            }
            //第三题
            String delete = "delete from student where sno='s004'";
            statement.executeUpdate(delete);
            //第四题
            String search = "select * from student where sno='s003'";
            rs = statement.executeQuery(search);
            while (rs.next()) {
                String sno = rs.getString(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String College = rs.getString(4);
                System.out.println(sno + ',' + name + ',' + age + ',' + College);
            }
            //第五题
            String update = "update student set sno='s001',name='老大',age = 20,College='通信学院' where sno='s001'";
            statement.executeUpdate(update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


