package com.example.devicevisionserver.controller;
import com.example.devicevisionserver.model.DeviceData;
import com.example.devicevisionserver.model.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeviceController {

    private static final String[] required_fields = {"username", "token", "deviceId", "imageData"};

    @PostMapping("/receive")
    public Response handlePrediction(@RequestBody DeviceData requestData) {

        StringBuilder missing = new StringBuilder();

        if (requestData.getUsername() == null || requestData.getUsername().trim().isEmpty()) {
            missing.append("username, ");
        }
        if (requestData.getToken() == null || requestData.getToken().trim().isEmpty()) {
            missing.append("token, ");
        }
        if (requestData.getDeviceId() == null || requestData.getDeviceId().trim().isEmpty()) {
            missing.append("deviceId, ");
        }
        if (requestData.getImageData() == null || requestData.getImageData().trim().isEmpty()) {
            missing.append("imageData, ");
        }


        if (!missing.isEmpty()) {
            String errorMsg = "缺少必填字段：" + missing.substring(0, missing.length() - 2);
            return new Response(400, errorMsg);
        }

        return new Response(200, "JSON字段检测通过，所有必填字段都已包含");
    }
}
