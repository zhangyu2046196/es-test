package com.youyuan.es;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
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
 * 类描述： es批量插入文档操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_BatchCreateDoc {

    private static Logger logger = Logger.getLogger(TestClient_BatchCreateDoc.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //批量插入文档
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("2001").source(JSON.toJSONString(new User("北京","男",18)
        ),XContentType.JSON));
        bulkRequest.add(new IndexRequest().index("user").id("2002").source(JSON.toJSONString(new User("上海","女",28)
        ),XContentType.JSON));
        bulkRequest.add(new IndexRequest().index("user").id("2003").source(JSON.toJSONString(new User("深圳","男",38)
        ),XContentType.JSON));
        bulkRequest.add(new IndexRequest().index("user").id("2004").source(JSON.toJSONString(new User("广州","男",22)
        ),XContentType.JSON));
        bulkRequest.add(new IndexRequest().index("user").id("2005").source(JSON.toJSONString(new User("香港","女",98)
        ),XContentType.JSON));
        bulkRequest.add(new IndexRequest().index("user").id("2006").source(JSON.toJSONString(new User("太原","男",79)
        ),XContentType.JSON));

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        logger.info("批量插入文档返回结果=" + JSON.toJSONString(bulkResponse));

        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
