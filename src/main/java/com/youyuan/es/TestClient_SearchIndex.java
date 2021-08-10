package com.youyuan.es;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;
import java.util.logging.Logger;


/**
 * 类名称：TestClient <br>
 * 类描述： es查询索引操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_SearchIndex {

    private static Logger logger=Logger.getLogger(TestClient_SearchIndex.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //查询索引
        GetIndexRequest user = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(user, RequestOptions.DEFAULT);

        logger.info("查询索引返回结果="+JSON.toJSONString(getIndexResponse.getMappings()));

        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
