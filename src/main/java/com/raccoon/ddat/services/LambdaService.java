package com.raccoon.ddat.services;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@RequiredArgsConstructor
@Component
public class LambdaService {
    AWSLambda lambda = AWSLambdaClientBuilder.standard().build();

    // Lambda 함수 이름과 입력 데이터를 설정
    String functionName = "ManageEC2InstanceState";
    String inputPayload = "{\"action\": \"status\",\"instanceId\": \"i-04c874b08641ae186\"}";

    public String getLambdaStatus() {
        // Lambda 함수 실행을 위한 요청 생성
        InvokeRequest request = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload(inputPayload);

        // Lambda 함수 실행 및 결과 수신
        InvokeResult result = lambda.invoke(request);

        // 결과 처리
        String outputPayload = new String(result.getPayload().array());

        System.out.println("outputPayload: " + outputPayload);

        return outputPayload;
    }


}
