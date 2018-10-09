package wise.wang.blog.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * APIResponse
 *
 * @author sage.wang
 * @date 18-10-9 下午3:22
 */
@Data
@EqualsAndHashCode
public class APIResponse<T> implements Serializable {

    private static final long serialVersionUID = 5412715938795343087L;

    private final String ver = "1.0.0";

    private int status;

    private String message;

    private T data;

    private APIResponse() {}

    public static <T> APIResponse<T> success(T data) {
        APIResponse<T> result = new APIResponse<>();
        result.setStatus(0);
        result.setData(data);
        return result;
    }

    public static <T> APIResponse<T> error(String message) {
        APIResponse<T> result = new APIResponse<>();
        result.setStatus(1);
        result.setMessage(message);
        return result;
    }

    public static <T> APIResponse<T> error(int errStatus, String message) {
        APIResponse<T> result = new APIResponse<>();
        result.setStatus(errStatus);
        result.setMessage(message);
        return result;
    }

    public static <T> APIResponse<T> error(int errStatus, String message, T data) {
        APIResponse<T> result = new APIResponse<>();
        result.setStatus(errStatus);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public boolean isOk() {
        return status == 0;
    }

}