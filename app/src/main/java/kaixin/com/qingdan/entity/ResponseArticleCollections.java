package kaixin.com.qingdan.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */

public class ResponseArticleCollections {

    /**
     * code : 0
     * message : Success
     * data : {"collections":{"body":{"code":0,"message":"Success","data":{"articles":[{"id":847,"title":"买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"帮大家过滤掉空气净化器的选择迷雾。","isLiked":false,"thingCount":0,"likeCount":45,"hitCount":2590,"commentCount":3,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2016-10-25 19:35:50","publishedAtDiffForHumans":"1周前","links":{"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":236,"title":"前方雾霾出没，出门请戴口罩","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/620d9cd4-6014-11e5-8896-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"9 款防雾霾口罩，你们可以各取所需。","isLiked":false,"thingCount":9,"likeCount":193,"hitCount":14029,"commentCount":9,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-12-06 16:15:41","publishedAtDiffForHumans":"10月前","links":{"self":"http://api.eqingdan.com/v1/articles/236","html":"http://www.eqingdan.com/app/articles/236","share":"http://www.eqingdan.com/mobile/articles/236","like":"http://api.eqingdan.com/v1/article/236/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/236/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":52,"title":"高性价比入门级 PK 专业级，空气净化器到底哪家强？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/516753f8-34f3-11e5-8cb7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"挑一台空气净化器，你需要知道的都在这里。","isLiked":false,"thingCount":5,"likeCount":250,"hitCount":32534,"commentCount":10,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-11-30 19:00:30","publishedAtDiffForHumans":"11月前","links":{"self":"http://api.eqingdan.com/v1/articles/52","html":"http://www.eqingdan.com/app/articles/52","share":"http://www.eqingdan.com/mobile/articles/52","like":"http://api.eqingdan.com/v1/article/52/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/52/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}],"meta":{"pagination":{"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}}}}},"collection":{"body":{"code":0,"message":"Success","data":{"_id":110,"id":110,"hash":"z18oqlo5q9er","title":"十面\u201c霾\u201d伏，你需要做好全面准备","subtitle":"无论出门还是宅家，防护工作都要做好。","featuredImageUrl":"http://img01.eqingdan.com/b8a493d2-91b8-11e6-9566-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"什么才是防雾霾口罩？空气净化器到底哪家强？这里都有答案。","isLiked":false,"likeCount":0,"articleCount":3,"publishedAt":"2016-10-14 11:00:28","publishedAtDiffForHumans":"2周前","links":{"self":"http://api.eqingdan.com/v1/collections/z18oqlo5q9er","share":"http://www.eqingdan.com/mobile/collections/z18oqlo5q9er"}}}}}
     */

    private int code;
    private String message;
    /**
     * collections : {"body":{"code":0,"message":"Success","data":{"articles":[{"id":847,"title":"买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"帮大家过滤掉空气净化器的选择迷雾。","isLiked":false,"thingCount":0,"likeCount":45,"hitCount":2590,"commentCount":3,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2016-10-25 19:35:50","publishedAtDiffForHumans":"1周前","links":{"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":236,"title":"前方雾霾出没，出门请戴口罩","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/620d9cd4-6014-11e5-8896-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"9 款防雾霾口罩，你们可以各取所需。","isLiked":false,"thingCount":9,"likeCount":193,"hitCount":14029,"commentCount":9,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-12-06 16:15:41","publishedAtDiffForHumans":"10月前","links":{"self":"http://api.eqingdan.com/v1/articles/236","html":"http://www.eqingdan.com/app/articles/236","share":"http://www.eqingdan.com/mobile/articles/236","like":"http://api.eqingdan.com/v1/article/236/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/236/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":52,"title":"高性价比入门级 PK 专业级，空气净化器到底哪家强？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/516753f8-34f3-11e5-8cb7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"挑一台空气净化器，你需要知道的都在这里。","isLiked":false,"thingCount":5,"likeCount":250,"hitCount":32534,"commentCount":10,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-11-30 19:00:30","publishedAtDiffForHumans":"11月前","links":{"self":"http://api.eqingdan.com/v1/articles/52","html":"http://www.eqingdan.com/app/articles/52","share":"http://www.eqingdan.com/mobile/articles/52","like":"http://api.eqingdan.com/v1/article/52/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/52/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}],"meta":{"pagination":{"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}}}}}
     * collection : {"body":{"code":0,"message":"Success","data":{"_id":110,"id":110,"hash":"z18oqlo5q9er","title":"十面\u201c霾\u201d伏，你需要做好全面准备","subtitle":"无论出门还是宅家，防护工作都要做好。","featuredImageUrl":"http://img01.eqingdan.com/b8a493d2-91b8-11e6-9566-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"什么才是防雾霾口罩？空气净化器到底哪家强？这里都有答案。","isLiked":false,"likeCount":0,"articleCount":3,"publishedAt":"2016-10-14 11:00:28","publishedAtDiffForHumans":"2周前","links":{"self":"http://api.eqingdan.com/v1/collections/z18oqlo5q9er","share":"http://www.eqingdan.com/mobile/collections/z18oqlo5q9er"}}}}
     */

    private DataBean1 data;

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

    public DataBean1 getData() {
        return data;
    }

    public void setData(DataBean1 data) {
        this.data = data;
    }

    public static class DataBean1 {
        /**
         * body : {"code":0,"message":"Success","data":{"articles":[{"id":847,"title":"买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"帮大家过滤掉空气净化器的选择迷雾。","isLiked":false,"thingCount":0,"likeCount":45,"hitCount":2590,"commentCount":3,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2016-10-25 19:35:50","publishedAtDiffForHumans":"1周前","links":{"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":236,"title":"前方雾霾出没，出门请戴口罩","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/620d9cd4-6014-11e5-8896-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"9 款防雾霾口罩，你们可以各取所需。","isLiked":false,"thingCount":9,"likeCount":193,"hitCount":14029,"commentCount":9,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-12-06 16:15:41","publishedAtDiffForHumans":"10月前","links":{"self":"http://api.eqingdan.com/v1/articles/236","html":"http://www.eqingdan.com/app/articles/236","share":"http://www.eqingdan.com/mobile/articles/236","like":"http://api.eqingdan.com/v1/article/236/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/236/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":52,"title":"高性价比入门级 PK 专业级，空气净化器到底哪家强？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/516753f8-34f3-11e5-8cb7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"挑一台空气净化器，你需要知道的都在这里。","isLiked":false,"thingCount":5,"likeCount":250,"hitCount":32534,"commentCount":10,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-11-30 19:00:30","publishedAtDiffForHumans":"11月前","links":{"self":"http://api.eqingdan.com/v1/articles/52","html":"http://www.eqingdan.com/app/articles/52","share":"http://www.eqingdan.com/mobile/articles/52","like":"http://api.eqingdan.com/v1/article/52/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/52/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}],"meta":{"pagination":{"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}}}}
         */

        private CollectionsBean collections;
        /**
         * body : {"code":0,"message":"Success","data":{"_id":110,"id":110,"hash":"z18oqlo5q9er","title":"十面\u201c霾\u201d伏，你需要做好全面准备","subtitle":"无论出门还是宅家，防护工作都要做好。","featuredImageUrl":"http://img01.eqingdan.com/b8a493d2-91b8-11e6-9566-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"什么才是防雾霾口罩？空气净化器到底哪家强？这里都有答案。","isLiked":false,"likeCount":0,"articleCount":3,"publishedAt":"2016-10-14 11:00:28","publishedAtDiffForHumans":"2周前","links":{"self":"http://api.eqingdan.com/v1/collections/z18oqlo5q9er","share":"http://www.eqingdan.com/mobile/collections/z18oqlo5q9er"}}}
         */

        private CollectionBean collection;

        public CollectionsBean getCollections() {
            return collections;
        }

        public void setCollections(CollectionsBean collections) {
            this.collections = collections;
        }

        public CollectionBean getCollection() {
            return collection;
        }

        public void setCollection(CollectionBean collection) {
            this.collection = collection;
        }

        public static class CollectionsBean {
            /**
             * code : 0
             * message : Success
             * data : {"articles":[{"id":847,"title":"买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"帮大家过滤掉空气净化器的选择迷雾。","isLiked":false,"thingCount":0,"likeCount":45,"hitCount":2590,"commentCount":3,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2016-10-25 19:35:50","publishedAtDiffForHumans":"1周前","links":{"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":236,"title":"前方雾霾出没，出门请戴口罩","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/620d9cd4-6014-11e5-8896-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"9 款防雾霾口罩，你们可以各取所需。","isLiked":false,"thingCount":9,"likeCount":193,"hitCount":14029,"commentCount":9,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-12-06 16:15:41","publishedAtDiffForHumans":"10月前","links":{"self":"http://api.eqingdan.com/v1/articles/236","html":"http://www.eqingdan.com/app/articles/236","share":"http://www.eqingdan.com/mobile/articles/236","like":"http://api.eqingdan.com/v1/article/236/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/236/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":52,"title":"高性价比入门级 PK 专业级，空气净化器到底哪家强？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/516753f8-34f3-11e5-8cb7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"挑一台空气净化器，你需要知道的都在这里。","isLiked":false,"thingCount":5,"likeCount":250,"hitCount":32534,"commentCount":10,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-11-30 19:00:30","publishedAtDiffForHumans":"11月前","links":{"self":"http://api.eqingdan.com/v1/articles/52","html":"http://www.eqingdan.com/app/articles/52","share":"http://www.eqingdan.com/mobile/articles/52","like":"http://api.eqingdan.com/v1/article/52/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/52/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}],"meta":{"pagination":{"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}}}
             */

            private BodyBean body;

            public BodyBean getBody() {
                return body;
            }

            public void setBody(BodyBean body) {
                this.body = body;
            }

            public static class BodyBean {
                private int code;
                private String message;
                /**
                 * articles : [{"id":847,"title":"买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"帮大家过滤掉空气净化器的选择迷雾。","isLiked":false,"thingCount":0,"likeCount":45,"hitCount":2590,"commentCount":3,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2016-10-25 19:35:50","publishedAtDiffForHumans":"1周前","links":{"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":236,"title":"前方雾霾出没，出门请戴口罩","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/620d9cd4-6014-11e5-8896-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"9 款防雾霾口罩，你们可以各取所需。","isLiked":false,"thingCount":9,"likeCount":193,"hitCount":14029,"commentCount":9,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-12-06 16:15:41","publishedAtDiffForHumans":"10月前","links":{"self":"http://api.eqingdan.com/v1/articles/236","html":"http://www.eqingdan.com/app/articles/236","share":"http://www.eqingdan.com/mobile/articles/236","like":"http://api.eqingdan.com/v1/article/236/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/236/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":52,"title":"高性价比入门级 PK 专业级，空气净化器到底哪家强？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/516753f8-34f3-11e5-8cb7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"挑一台空气净化器，你需要知道的都在这里。","isLiked":false,"thingCount":5,"likeCount":250,"hitCount":32534,"commentCount":10,"categories":[{"name":"家居","slug":"housing"}],"publishedAt":"2015-11-30 19:00:30","publishedAtDiffForHumans":"11月前","links":{"self":"http://api.eqingdan.com/v1/articles/52","html":"http://www.eqingdan.com/app/articles/52","share":"http://www.eqingdan.com/mobile/articles/52","like":"http://api.eqingdan.com/v1/article/52/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/52/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}]
                 * meta : {"pagination":{"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}}
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
                    /**
                     * pagination : {"total":3,"count":3,"per_page":10,"current_page":1,"total_pages":1,"links":{}}
                     */

                    private MetaBean meta;
                    /**
                     * id : 847
                     * title : 买净化器不能只看 CADR 值！一篇所有人都能看懂的挑选指南
                     * subtitle :
                     * featuredImageUrl : http://img01.eqingdan.com/c10b8b82-9aa2-11e6-bfe3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
                     * excerpt : 帮大家过滤掉空气净化器的选择迷雾。
                     * isLiked : false
                     * thingCount : 0
                     * likeCount : 45
                     * hitCount : 2590
                     * commentCount : 3
                     * categories : [{"name":"家居","slug":"housing"}]
                     * publishedAt : 2016-10-25 19:35:50
                     * publishedAtDiffForHumans : 1周前
                     * links : {"self":"http://api.eqingdan.com/v1/articles/847","html":"http://www.eqingdan.com/app/articles/847","share":"http://www.eqingdan.com/mobile/articles/847","like":"http://api.eqingdan.com/v1/article/847/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/847/actions/cancel-like"}
                     * author : {"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}
                     */

                    private List<ArticlesBean> articles;

                    public MetaBean getMeta() {
                        return meta;
                    }

                    public void setMeta(MetaBean meta) {
                        this.meta = meta;
                    }

                    public List<ArticlesBean> getArticles() {
                        return articles;
                    }

                    public void setArticles(List<ArticlesBean> articles) {
                        this.articles = articles;
                    }

                    public static class MetaBean {
                        /**
                         * total : 3
                         * count : 3
                         * per_page : 10
                         * current_page : 1
                         * total_pages : 1
                         * links : {}
                         */

                        private PaginationBean pagination;

                        public PaginationBean getPagination() {
                            return pagination;
                        }

                        public void setPagination(PaginationBean pagination) {
                            this.pagination = pagination;
                        }

                        public static class PaginationBean {
                            private int total;
                            private int count;
                            private int per_page;
                            private int current_page;
                            private int total_pages;
                            private LinksBean links;

                            public int getTotal() {
                                return total;
                            }

                            public void setTotal(int total) {
                                this.total = total;
                            }

                            public int getCount() {
                                return count;
                            }

                            public void setCount(int count) {
                                this.count = count;
                            }

                            public int getPer_page() {
                                return per_page;
                            }

                            public void setPer_page(int per_page) {
                                this.per_page = per_page;
                            }

                            public int getCurrent_page() {
                                return current_page;
                            }

                            public void setCurrent_page(int current_page) {
                                this.current_page = current_page;
                            }

                            public int getTotal_pages() {
                                return total_pages;
                            }

                            public void setTotal_pages(int total_pages) {
                                this.total_pages = total_pages;
                            }

                            public LinksBean getLinks() {
                                return links;
                            }

                            public void setLinks(LinksBean links) {
                                this.links = links;
                            }

                            public static class LinksBean {
                            }
                        }
                    }

                    public static class ArticlesBean {
                        private int id;
                        private String title;
                        private String subtitle;
                        private String featuredImageUrl;
                        private String excerpt;
                        private boolean isLiked;
                        private int thingCount;
                        private int likeCount;
                        private int hitCount;
                        private int commentCount;
                        private String publishedAt;
                        private String publishedAtDiffForHumans;
                        /**
                         * self : http://api.eqingdan.com/v1/articles/847
                         * html : http://www.eqingdan.com/app/articles/847
                         * share : http://www.eqingdan.com/mobile/articles/847
                         * like : http://api.eqingdan.com/v1/article/847/actions/like
                         * cancelLike : http://api.eqingdan.com/v1/article/847/actions/cancel-like
                         */

                        private LinksBean links;
                        /**
                         * id : 5
                         * username : list
                         * nickname : 李斯特
                         * tagline : 从一个枕头到全世界
                         * avatarUrl : http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75
                         */

                        private AuthorBean author;
                        /**
                         * name : 家居
                         * slug : housing
                         */

                        private List<CategoriesBean> categories;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getSubtitle() {
                            return subtitle;
                        }

                        public void setSubtitle(String subtitle) {
                            this.subtitle = subtitle;
                        }

                        public String getFeaturedImageUrl() {
                            return featuredImageUrl;
                        }

                        public void setFeaturedImageUrl(String featuredImageUrl) {
                            this.featuredImageUrl = featuredImageUrl;
                        }

                        public String getExcerpt() {
                            return excerpt;
                        }

                        public void setExcerpt(String excerpt) {
                            this.excerpt = excerpt;
                        }

                        public boolean isIsLiked() {
                            return isLiked;
                        }

                        public void setIsLiked(boolean isLiked) {
                            this.isLiked = isLiked;
                        }

                        public int getThingCount() {
                            return thingCount;
                        }

                        public void setThingCount(int thingCount) {
                            this.thingCount = thingCount;
                        }

                        public int getLikeCount() {
                            return likeCount;
                        }

                        public void setLikeCount(int likeCount) {
                            this.likeCount = likeCount;
                        }

                        public int getHitCount() {
                            return hitCount;
                        }

                        public void setHitCount(int hitCount) {
                            this.hitCount = hitCount;
                        }

                        public int getCommentCount() {
                            return commentCount;
                        }

                        public void setCommentCount(int commentCount) {
                            this.commentCount = commentCount;
                        }

                        public String getPublishedAt() {
                            return publishedAt;
                        }

                        public void setPublishedAt(String publishedAt) {
                            this.publishedAt = publishedAt;
                        }

                        public String getPublishedAtDiffForHumans() {
                            return publishedAtDiffForHumans;
                        }

                        public void setPublishedAtDiffForHumans(String publishedAtDiffForHumans) {
                            this.publishedAtDiffForHumans = publishedAtDiffForHumans;
                        }

                        public LinksBean getLinks() {
                            return links;
                        }

                        public void setLinks(LinksBean links) {
                            this.links = links;
                        }

                        public AuthorBean getAuthor() {
                            return author;
                        }

                        public void setAuthor(AuthorBean author) {
                            this.author = author;
                        }

                        public List<CategoriesBean> getCategories() {
                            return categories;
                        }

                        public void setCategories(List<CategoriesBean> categories) {
                            this.categories = categories;
                        }

                        public static class LinksBean {
                            private String self;
                            private String html;
                            private String share;
                            private String like;
                            private String cancelLike;

                            public String getSelf() {
                                return self;
                            }

                            public void setSelf(String self) {
                                this.self = self;
                            }

                            public String getHtml() {
                                return html;
                            }

                            public void setHtml(String html) {
                                this.html = html;
                            }

                            public String getShare() {
                                return share;
                            }

                            public void setShare(String share) {
                                this.share = share;
                            }

                            public String getLike() {
                                return like;
                            }

                            public void setLike(String like) {
                                this.like = like;
                            }

                            public String getCancelLike() {
                                return cancelLike;
                            }

                            public void setCancelLike(String cancelLike) {
                                this.cancelLike = cancelLike;
                            }
                        }

                        public static class AuthorBean {
                            private int id;
                            private String username;
                            private String nickname;
                            private String tagline;
                            private String avatarUrl;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getUsername() {
                                return username;
                            }

                            public void setUsername(String username) {
                                this.username = username;
                            }

                            public String getNickname() {
                                return nickname;
                            }

                            public void setNickname(String nickname) {
                                this.nickname = nickname;
                            }

                            public String getTagline() {
                                return tagline;
                            }

                            public void setTagline(String tagline) {
                                this.tagline = tagline;
                            }

                            public String getAvatarUrl() {
                                return avatarUrl;
                            }

                            public void setAvatarUrl(String avatarUrl) {
                                this.avatarUrl = avatarUrl;
                            }
                        }

                        public static class CategoriesBean {
                            private String name;
                            private String slug;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getSlug() {
                                return slug;
                            }

                            public void setSlug(String slug) {
                                this.slug = slug;
                            }
                        }
                    }
                }
            }
        }

        public static class CollectionBean {
            /**
             * code : 0
             * message : Success
             * data : {"_id":110,"id":110,"hash":"z18oqlo5q9er","title":"十面\u201c霾\u201d伏，你需要做好全面准备","subtitle":"无论出门还是宅家，防护工作都要做好。","featuredImageUrl":"http://img01.eqingdan.com/b8a493d2-91b8-11e6-9566-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"什么才是防雾霾口罩？空气净化器到底哪家强？这里都有答案。","isLiked":false,"likeCount":0,"articleCount":3,"publishedAt":"2016-10-14 11:00:28","publishedAtDiffForHumans":"2周前","links":{"self":"http://api.eqingdan.com/v1/collections/z18oqlo5q9er","share":"http://www.eqingdan.com/mobile/collections/z18oqlo5q9er"}}
             */

            private BodyBean body;

            public BodyBean getBody() {
                return body;
            }

            public void setBody(BodyBean body) {
                this.body = body;
            }

            public static class BodyBean {
                private int code;
                private String message;
                /**
                 * _id : 110
                 * id : 110
                 * hash : z18oqlo5q9er
                 * title : 十面“霾”伏，你需要做好全面准备
                 * subtitle : 无论出门还是宅家，防护工作都要做好。
                 * featuredImageUrl : http://img01.eqingdan.com/b8a493d2-91b8-11e6-9566-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
                 * excerpt : 什么才是防雾霾口罩？空气净化器到底哪家强？这里都有答案。
                 * isLiked : false
                 * likeCount : 0
                 * articleCount : 3
                 * publishedAt : 2016-10-14 11:00:28
                 * publishedAtDiffForHumans : 2周前
                 * links : {"self":"http://api.eqingdan.com/v1/collections/z18oqlo5q9er","share":"http://www.eqingdan.com/mobile/collections/z18oqlo5q9er"}
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
                    private int _id;
                    private int id;
                    private String hash;
                    private String title;
                    private String subtitle;
                    private String featuredImageUrl;
                    private String excerpt;
                    private boolean isLiked;
                    private int likeCount;
                    private int articleCount;
                    private String publishedAt;
                    private String publishedAtDiffForHumans;
                    /**
                     * self : http://api.eqingdan.com/v1/collections/z18oqlo5q9er
                     * share : http://www.eqingdan.com/mobile/collections/z18oqlo5q9er
                     */

                    private LinksBean links;

                    public int get_id() {
                        return _id;
                    }

                    public void set_id(int _id) {
                        this._id = _id;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getSubtitle() {
                        return subtitle;
                    }

                    public void setSubtitle(String subtitle) {
                        this.subtitle = subtitle;
                    }

                    public String getFeaturedImageUrl() {
                        return featuredImageUrl;
                    }

                    public void setFeaturedImageUrl(String featuredImageUrl) {
                        this.featuredImageUrl = featuredImageUrl;
                    }

                    public String getExcerpt() {
                        return excerpt;
                    }

                    public void setExcerpt(String excerpt) {
                        this.excerpt = excerpt;
                    }

                    public boolean isIsLiked() {
                        return isLiked;
                    }

                    public void setIsLiked(boolean isLiked) {
                        this.isLiked = isLiked;
                    }

                    public int getLikeCount() {
                        return likeCount;
                    }

                    public void setLikeCount(int likeCount) {
                        this.likeCount = likeCount;
                    }

                    public int getArticleCount() {
                        return articleCount;
                    }

                    public void setArticleCount(int articleCount) {
                        this.articleCount = articleCount;
                    }

                    public String getPublishedAt() {
                        return publishedAt;
                    }

                    public void setPublishedAt(String publishedAt) {
                        this.publishedAt = publishedAt;
                    }

                    public String getPublishedAtDiffForHumans() {
                        return publishedAtDiffForHumans;
                    }

                    public void setPublishedAtDiffForHumans(String publishedAtDiffForHumans) {
                        this.publishedAtDiffForHumans = publishedAtDiffForHumans;
                    }

                    public LinksBean getLinks() {
                        return links;
                    }

                    public void setLinks(LinksBean links) {
                        this.links = links;
                    }

                    public static class LinksBean {
                        private String self;
                        private String share;

                        public String getSelf() {
                            return self;
                        }

                        public void setSelf(String self) {
                            this.self = self;
                        }

                        public String getShare() {
                            return share;
                        }

                        public void setShare(String share) {
                            this.share = share;
                        }
                    }
                }
            }
        }
    }
}
