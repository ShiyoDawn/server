package org.example.server.payload.response;

/**
 * DataResponse 前端HTTP请求返回数据对象
 * Integer code 返回代码 0 正确返回 1 错误返回信息
 * Object data 返回数据对象
 * String msg 返回正确错误信息
 */
public class DataResponse {
    private Integer code;
    private Object data;
    private String msg;
    public DataResponse(){

    }

    public DataResponse(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static DataResponse success(Object data){
        return new DataResponse(200,data,null);
    }

    public static DataResponse success(Object data, String msg){
        return new DataResponse(200,data,msg);
    }

    public static DataResponse ok(){
        return new DataResponse(200,null,null);
    }

    public static DataResponse ok(String msg) {
        return new DataResponse(200,null,msg);
    }

    public static DataResponse error(Integer code, String msg){
        return new DataResponse(code,null,msg);
    }
    public static DataResponse error( String msg){
        return new DataResponse(null,null,msg);
    }
}
