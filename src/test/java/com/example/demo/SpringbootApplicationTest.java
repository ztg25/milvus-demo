package com.example.demo;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.ConnectParam;
import io.milvus.param.R;
import io.milvus.param.collection.HasCollectionParam;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpringbootApplicationTest {

	private static MilvusServiceClient milvusClient;

	@BeforeClass
	public static void init(){
		milvusClient = new MilvusServiceClient(ConnectParam.newBuilder()
				.withHost("127.0.0.1")
				.withPort(19530)
				.build());
	}

	@Test
	public void testCase1(){
		R<Boolean> response = milvusClient.hasCollection(
				HasCollectionParam.newBuilder()
						.withCollectionName("hello_milvus")
						.build());

		System.out.println("milvus status is : " + response.getStatus());
	}
}