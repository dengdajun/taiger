package support.util;


import java.io.Serializable;
import java.util.Map;

/**
 * JacksonBean
 * Created by Matrix on 2016/3/31.
 */
public class ResponseMessage implements Serializable {

    private Integer status;
    private String message;
    private Map<String, Object> data;

    public ResponseMessage() {}

    public Integer getStatus() {
        return status;
    }

    public ResponseMessage setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseMessage setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

}
