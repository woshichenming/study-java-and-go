package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/23 16:06
 * @description：
 * @modified By：
 * @version: $
 */
public class Ex_Doc_Get {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
        //查询数据
        GetRequest getRequest = new GetRequest();
        getRequest.index("user").id("1002");
        GetResponse documentFields = esClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSourceAsString());
        esClient.close();
    }
}
