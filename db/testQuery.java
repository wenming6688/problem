

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class testQuery {

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
            //要执行的SQL语句
            String sql = "select * from url where id =1";
//            String update="update  url set area='civen' where id=1 ";
//            statement.execute(update);
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("第1次执行结果如下所示:");
            System.out.println("-----------------");  
            System.out.println("姓名" + "\t" + "职称");  
            System.out.println("-----------------");
            String job = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("area");
                //获取stuid这列数据
                id = rs.getString("url");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            System.out.println("开始睡眠睡眠1分");
            TimeUnit.SECONDS.sleep(22);
            System.out.println("睡眠结束执行第二次查询");
            ResultSet rs1 = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("姓名" + "\t" + "职称");
            System.out.println("-----------------");
            String job1= null;
            String id1 = null;
            while(rs1.next()){
                //获取stuname这列数据
                job1 = rs1.getString("area");
                //获取stuid这列数据
                id1 = rs1.getString("url");

                //输出结果
                System.out.println(id1 + "\t" + job1);
            }
            TimeUnit.SECONDS.sleep(20);
            System.out.println("开始提交事务");
            con.commit();
            System.out.println("-----提交事务END---");
            rs.close();
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