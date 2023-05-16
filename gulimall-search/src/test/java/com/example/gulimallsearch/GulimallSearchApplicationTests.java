package com.example.gulimallsearch;

import com.alibaba.fastjson.JSON;
import com.example.common.utils.Query;
import com.example.gulimallsearch.config.GulimallElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GulimallSearchApplicationTests {

	@Data
	class User{
		private String userName;
		private String gender;
		private Integer age;
	}

	@Autowired
	private RestHighLevelClient client;


	@Test
	public void contextLoads() {
		System.out.printf(client.toString());
	}

	@Test
	public void putDocument() throws IOException {
		IndexRequest indexRequest = new IndexRequest("users");
		indexRequest.id("1");

//		indexRequest.source("userName", "zhangsan", "age", 18);
		User user = new User();
		String jsonString = JSON.toJSONString(user);
		indexRequest.source(jsonString, XContentType.JSON);

		IndexResponse response  = client.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

		System.out.println(response);

	}

	@Test
	public void searchData() throws IOException {
		// 1 create the search request
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("bank");

		// 2 build the request body
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));

		searchRequest.source(searchSourceBuilder);

		// 3 send the request and get response
		SearchResponse response = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
		for(SearchHit s: response.getHits().getHits()) {
			System.out.println(s.toString());
		}
//		System.out.println(response);

	}


}
