package kaixin.com.qingdan.entity;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class ResponseDailyTips {
    /**
     * code : 0
     * message : Success
     * data : {"id":76,"date":"2016-11-13","imageUrl":"http://img01.eqingdan.com/f87eb24e-a70c-11e6-a82a-00163e004c5e.jpeg?imageView2/2/w/750/q/75"}
     */

    private int code;
    private String message;
    /**
     * id : 76
     * date : 2016-11-13
     * imageUrl : http://img01.eqingdan.com/f87eb24e-a70c-11e6-a82a-00163e004c5e.jpeg?imageView2/2/w/750/q/75
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String date;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
