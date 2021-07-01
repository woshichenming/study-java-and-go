import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/22 15:17
 * @description：mongodDb 测试
 * @modified By：
 * @version: $
 */
public class MongoDBTest2 {
    @Test
    public void testInit() {
        try {
            ServerAddress serverAddress = new ServerAddress("192.168.3.3", 217017);
            List<ServerAddress> list = new ArrayList<ServerAddress>();
            list.add(serverAddress);
            MongoCredential scramSha1Credential = MongoCredential.createScramSha1Credential("chenming", "admin", "password".toCharArray());
            List<MongoCredential> mongoCredentials = new ArrayList<MongoCredential>();
            mongoCredentials.add(scramSha1Credential);
            //通过认证 获取 MongoDb连接
            MongoClient mongoClient = new MongoClient(list, Collections.singletonList(scramSha1Credential));
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
