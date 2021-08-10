package com.youyuan.es;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.lucene.queryparser.flexible.core.nodes.FuzzyQueryNode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.logging.Logger;


/**
 * 类名称：TestClient <br>
 * 类描述： es多条件查询文档操作 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/8/8 22:26<br>
 */
public class TestClient_QueryDoc {

    private static Logger logger = Logger.getLogger(TestClient_QueryDoc.class.getName());

    public static void main(String[] args) throws IOException {

        //创建es客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost
                ("localhost", 9200, "http")));

        //1.全量查询文档
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("全量查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //2.条件查询文档  termQuery
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.termQuery("age",28));
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("条件查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //3.分页查询文档
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        //分页公式(当前页数-1)*每页显示数量
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(2);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("分页查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //4.排序查询文档
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.sort("age", SortOrder.DESC);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("分页查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //5.查询结果排除显示字段  fetchSource
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        String[] includes={"name"};//包涵列
//        String[] excludes={"age"};//排除列
//        searchSourceBuilder.fetchSource(includes, excludes);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("分页查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //6.组合查询
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchQuery("name","北京"));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age",18));
//        searchSourceBuilder.query(boolQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("组合查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //7.范围查询
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//        rangeQueryBuilder.gte(18);
//        rangeQueryBuilder.lt(90);
//        searchSourceBuilder.query(rangeQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("组合查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //8.模糊查询
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "北");
//        fuzzyQueryBuilder.fuzziness(Fuzziness.ONE);
//        searchSourceBuilder.query(fuzzyQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("模糊查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //9.高亮查询
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "北京");
//        HighlightBuilder highlightBuilder=new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        searchSourceBuilder.highlighter(highlightBuilder);
//        searchSourceBuilder.query(matchQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("高亮查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }

        //10.聚合查询
//        SearchRequest searchRequest=new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        AggregationBuilder aggregationBuilder= AggregationBuilders.max("maxAge").field("age");
//        searchSourceBuilder.aggregation(aggregationBuilder);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        logger.info("聚合查询文档返回结果=" + JSON.toJSONString(searchResponse));
//
//        SearchHits hits = searchResponse.getHits();
//        for (SearchHit hit : hits) {
//            logger.info("查询结果信息:"+hit.getSourceAsString());
//        }


        //11.分组查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        searchSourceBuilder.aggregation(aggregationBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        logger.info("聚合查询文档返回结果=" + JSON.toJSONString(searchResponse));

        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            logger.info("查询结果信息:" + hit.getSourceAsString());
        }


        //关闭es客户端连接
        restHighLevelClient.close();
    }

}
