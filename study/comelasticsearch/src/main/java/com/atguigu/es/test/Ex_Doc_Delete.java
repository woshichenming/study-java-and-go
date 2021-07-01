package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import javax.security.auth.kerberos.DelegationPermission;
import java.io.IOException;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/23 16:28
 * @description：删除文档
 * @modified By：
 * @version: $
 */
public class Ex_Doc_Delete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
        //查询数据
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("user").id("1002");
        DeleteResponse delete = esClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete);
        esClient.close();
    }
}
