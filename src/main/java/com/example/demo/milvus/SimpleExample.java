package com.example.demo.milvus;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.ConnectParam;
import io.milvus.param.R;
import io.milvus.param.collection.HasCollectionParam;

public class SimpleExample {

    private static MilvusServiceClient milvusClient = new MilvusServiceClient(ConnectParam.newBuilder()
            .withHost("localhost")
            .withPort(19530)
            .build());

    public static void main(String[] args) {
        // list collections
        R<Boolean> response = milvusClient.hasCollection(
                HasCollectionParam.newBuilder()
                        .withCollectionName("hello_milvus")
                        .build());

        System.out.println("milvus status is : " + response.getStatus());

        System.out.println("good boy!!!");
    }
}
