package com.atguigu.es.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/23 15:54
 * @description：索引修改
 * @modified By：
 * @version: $
 */
public class Ex_index_Search_insertandUpdate {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
        //插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1002");
        User user = new User();
        user.setAge(32);
        user.setName("11");
        user.setSex("男");

        //向 es 中插入数据
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);
        IndexResponse index = esClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("index.getResult()---------"+index.getResult());
        /**
         * @author: chenming
         * @description: TODO
         * 进行修改操作
         * @date: 2021/4/23 16:03
         */

//        UpdateRequest indexRequest1 = new UpdateRequest();
//
//        indexRequest1.index("user").id("1002");
//        User user1 = new User();
//        user1.setAge(312);
//        user1.setName("1121");
//        user1.setSex("男3");
//
//        //向 es 中插入数据
//        ObjectMapper mapper1 = new ObjectMapper();
//        String userJson1 = mapper1.writeValueAsString(user);
//        indexRequest.source(userJson1, XContentType.JSON);
//        UpdateResponse update = esClient.update(indexRequest1, RequestOptions.DEFAULT);
//        System.out.println("index.getResult()---------"+update.getResult());
    }
}
