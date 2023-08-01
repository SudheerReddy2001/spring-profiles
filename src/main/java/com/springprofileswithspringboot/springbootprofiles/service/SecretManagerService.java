package com.springprofileswithspringboot.springbootprofiles.service;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

public class SecretManagerService {

    public static AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIA5PSSY57QQLPBNGGV","gx+k6nKO7BV69dAmh9XFP+ecTGPsjfFUEAwFCoHZ");
        return credentials;
    }

    public static void main(String[] args) {
        AWSSecretsManager client=	AWSSecretsManagerClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials())).withRegion("eu-north-1").build();

        GetSecretValueRequest secretValueRequest=new GetSecretValueRequest().withSecretId("Myprodsecret");
        GetSecretValueResult secretValueResult=null;
        secretValueResult=client.getSecretValue(secretValueRequest);
        String secretValue=secretValueResult.getSecretString();
        System.out.println("secretValue:"+secretValue);
        Gson gson=new Gson();
        Map<String,Object> map=gson.fromJson(secretValue, Map.class);
        map.forEach((k,v)->System.err.println("key:"+k+",value:"+v));
    }

}
