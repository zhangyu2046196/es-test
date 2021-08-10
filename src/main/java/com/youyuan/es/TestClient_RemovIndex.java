package com.youyuan.es;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;
import java.util.logging.Logger;


/**
 * 类名称：TestClient <br>
 * 类描述： es删除索引操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_RemovIndex {

    private static Logger logger=Logger.getLogger(TestClient_RemovIndex.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //删除索引
        DeleteIndexRequest order = new DeleteIndexRequest("order");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(order, RequestOptions.DEFAULT);

        logger.info("删除索引返回结果="+JSON.toJSONString(delete));

        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
