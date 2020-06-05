package com.comaiot.net.library.bean;

import java.io.Serializable;

public class SmsEntity extends BaseAppEntity {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StorageEntity{" +
                "content=" + content +
                '}';
    }

    public static class Content implements Serializable {
        private String verify_code;
        private Response_Msg response_msg;

        public String getVerify_code() {
            return verify_code;
        }

        public void setVerify_code(String verify_code) {
            this.verify_code = verify_code;
        }

        public Response_Msg getResponse_msg() {
            return response_msg;
        }

        public void setResponse_msg(Response_Msg response_msg) {
            this.response_msg = response_msg;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "verify_code='" + verify_code + '\'' +
                    ", response_msg=" + response_msg +
                    '}';
        }
    }

    private static class Response_Msg implements Serializable{
        private String Message;
        private String RequestId;
        private String BizId;
        private String Code;

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        public String getRequestId() {
            return RequestId;
        }

        public void setRequestId(String requestId) {
            RequestId = requestId;
        }

        public String getBizId() {
            return BizId;
        }

        public void setBizId(String bizId) {
            BizId = bizId;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }

        @Override
        public String toString() {
            return "Response_Msg{" +
                    "Message='" + Message + '\'' +
                    ", RequestId='" + RequestId + '\'' +
                    ", BizId='" + BizId + '\'' +
                    ", Code='" + Code + '\'' +
                    '}';
        }
    }
}
