package com.example.devicevisionserver.model;

// 返回给设备的响应数据格式
public class Response {
    private int statusCode;
    private Result result;
    private String message;
    public Response(int statusCode, Result result, String message) {
        this.statusCode = statusCode;
        this.result = result;
        this.message = message;
    }

    public static class Result {
        private String prediction;
        private double confidence;

        public Result(String prediction, double confidence) {
            this.prediction = prediction;
            this.confidence = confidence;
        }

        public String getPrediction() { return prediction; }
        public double getConfidence() { return confidence; }
    }

    public int getStatusCode() { return statusCode; }
    public Result getResult() { return result; }
    public String getMessage() { return message; }
}
