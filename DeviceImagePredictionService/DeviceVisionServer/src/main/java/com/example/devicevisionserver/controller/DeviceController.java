package com.example.devicevisionserver.controller;

import com.example.devicevisionserver.model.DeviceData;
import com.example.devicevisionserver.model.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // 统一接口前缀
public class DeviceController {

    // 处理设备发送的图片数据请求
    @PostMapping("/predict")
    public Response handlePrediction(@RequestBody DeviceData requestData) {
        // 1. 验证必要字段
        if (requestData.getToken() == null || requestData.getToken().isEmpty()) {
            return new Response(400, null, "缺少token字段");
        }
        if (requestData.getImageData() == null || requestData.getImageData().isEmpty()) {
            return new Response(400, null, "缺少图片数据");
        }

        String prediction = "cat"; // 模拟预测结果
        double confidence = 0.95;  // 模拟置信度

        // 3. 构造并返回响应
        return new Response(
                200,
                new Response.Result(prediction, confidence),
                "处理成功"
        );
    }
}
