package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/23 15:39
 * @description：查询索引
 * @modified By：
 * @version: $
 */
public class Ex_index_Search {
    public static void main(String[] args) throws IOException {
        //创建Es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
        GetIndexRequest request = new GetIndexRequest("student");
        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);
        //响应状态
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());
        //关闭客户端

        /**
         * @author: chenming
         * @description: TODO
         * 删除索引
         * @date: 2021/4/23 15:51
         */
        DeleteIndexRequest delete = new DeleteIndexRequest("user");
        AcknowledgedResponse delete1 = esClient.indices().delete(delete, RequestOptions.DEFAULT);
        System.out.println(delete1);
        esClient.close();
    }
}
