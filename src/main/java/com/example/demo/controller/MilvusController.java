package com.example.demo.controller;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.ConnectParam;
import io.milvus.param.R;
import io.milvus.param.collection.HasCollectionParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilvusController {

    private static MilvusServiceClient milvusClient = new MilvusServiceClient(ConnectParam.newBuilder()
            .withHost("localhost")
            .withPort(19530)
            .build());

    @GetMapping("/checkMilvusService")
    public void checkMilvusService(){
        // list collections
        R<Boolean> response = milvusClient.hasCollection(
                HasCollectionParam.newBuilder()
                        .withCollectionName("hello_milvus")
                        .withDatabaseName("default")
                        .build());

        System.out.println("milvus status is : " + response.getStatus());
        System.out.println("response : " + response.getMessage());

//        System.out.println("good boy!!!");
    }
}
