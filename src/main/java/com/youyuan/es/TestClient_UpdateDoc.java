package com.youyuan.es;

import com.alibaba.fastjson.JSON;
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
import java.util.logging.Logger;


/**
 * 类名称：TestClient <br>
 * 类描述： es修改文档操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_UpdateDoc {

    private static Logger logger = Logger.getLogger(TestClient_UpdateDoc.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //修改文档
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("user").id("2001");
        updateRequest.doc(XContentType.JSON, "sex", "女");

        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);

        logger.info("修改文档返回结果=" + JSON.toJSONString(updateResponse));

        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
