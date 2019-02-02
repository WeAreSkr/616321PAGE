package cap.mvc.dao;

import cap.LocalConfig;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.output.WriterOutputStream;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Repository
public class DaySentenceDao {

    public static class DayBean {
        /**
         * sid : 3034
         * tts : http://news.iciba.com/admin/tts/2018-06-18-day.mp3
         * content : If you see something wrong happening in the world, you can either do nothing, or you can do something.
         * note : ����㿴���������������⣬��Ҫô����֣�Ҫôȥ�ı�����
         * love : 1792
         * translation : Ͷ�������գ���仰���ԡ�����Ů����������˵�Ļ���ѡ���޴����ڣ���Ҫ���Ǹ����Լ������ģ����ǻ���ı䲻��ʲô���������Ǽ���Լ���ѡ��Ps:ף���������տ��֣�ͬʱҲϣ����λ��עÿ��һ���С������ڿ��֡���������Ǻ������ˣ���λ�ǵó�����Ŷ~~
         * picture : http://cdn.iciba.com/news/word/20180618.jpg
         * picture2 : http://cdn.iciba.com/news/word/big_20180618b.jpg
         * caption : �ʰ�ÿ��һ��
         * dateline : 2018-06-18
         * s_pv : 0
         * sp_pv : 0
         * tags : [{"id":null,"name":null}]
         * fenxiang_img : http://cdn.iciba.com/web/news/longweibo/imag/2018-06-18.jpg
         */

        private String sid;
        private String tts;
        private String content;
        private String note;
        private String love;
        private String translation;
        private String picture;
        private String picture2;
        private String caption;
        private String dateline;
        private String s_pv;
        private String sp_pv;
        private String fenxiang_img;
        private List<TagsBean> tags;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getTts() {
            return tts;
        }

        public void setTts(String tts) {
            this.tts = tts;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPicture2() {
            return picture2;
        }

        public void setPicture2(String picture2) {
            this.picture2 = picture2;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getS_pv() {
            return s_pv;
        }

        public void setS_pv(String s_pv) {
            this.s_pv = s_pv;
        }

        public String getSp_pv() {
            return sp_pv;
        }

        public void setSp_pv(String sp_pv) {
            this.sp_pv = sp_pv;
        }

        public String getFenxiang_img() {
            return fenxiang_img;
        }

        public void setFenxiang_img(String fenxiang_img) {
            this.fenxiang_img = fenxiang_img;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * id : null
             * name : null
             */

            private Object id;
            private Object name;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }
        }
    }

    public String getDaySentence() {
            String result = "";
            OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.SECONDS).build();
            Request request = new Request.Builder().url("http://open.iciba.com/dsapi/")
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response;
            String res = null ;
            try {
                response = httpClient.newCall(request).execute();
                res = response.body().string();
            } catch (IOException e) {
                result = "获取每日一句失败";
                e.printStackTrace();
            }
            if(res != null) {
                DayBean daybean = JSON.parseObject(res, DayBean.class);
                request = new Request.Builder().url(daybean.getPicture2()).build();

                result = daybean.getContent() + "</br>" + daybean.getNote();
            }
            return result ;

    }

}
