

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class testUpdate {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/creep";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "gao516688";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            System.out.println("sleep 1 min");
            TimeUnit.SECONDS.sleep(15);
            //要执行的SQL语句
            String sql = "select * from url";
            String update="update  url set area='civen' where id=1 ";
            System.out.println("执行更新操作");
            statement.execute(update);
            //3.ResultSet类，用来存放获取的结果集！！
            System.out.println("开始提交事务");
            con.commit();
            System.out.println("-----提交事务END---");
            con.close();
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }

}