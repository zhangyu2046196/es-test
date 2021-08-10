package com.youyuan.es;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.logging.Logger;


/**
 * 类名称：TestClient <br>
 * 类描述： es保存文档操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_CreateDoc {

    private static Logger logger = Logger.getLogger(TestClient_CreateDoc.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //保存文档
        IndexRequest indexRequest = new IndexRequest();
        //指定要保存文档的索引和id
        indexRequest.index("user").id("2001");
        //文档基础类
        User user = new User("北京", "男", 38);
        //基础类转为json
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        //设置保存的文档
        indexRequest.source(userJson,XContentType.JSON);

        IndexResponse re = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        logger.info("保存文档返回结果=" + JSON.toJSONString(re));

        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
