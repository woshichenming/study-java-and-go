import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/22 15:17
 * @description：mongodDb 测试
 * @modified By：
 * @version: $
 */
public class MongoDBTest {
    @Test
    public void testInit() {
        try {
            MongoClient mongoClient = new MongoClient("192.168.3.3", 27017);
            //连接数据库


            MongoDatabase admin = mongoClient.getDatabase("admin");
            if (admin != null) {
                System.out.println("连接成功");
                mongoClient.close();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ".---" + e.getMessage());
        }
    }
}
