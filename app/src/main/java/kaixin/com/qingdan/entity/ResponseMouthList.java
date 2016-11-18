package kaixin.com.qingdan.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class ResponseMouthList {
    /**
     * code : 0
     * message : Success
     * data : {"rankings":[{"id":41,"title":"止汗露","slug":"deodorant","featuredImageUrl":"http://img01.eqingdan.com/dbf4b2fa-a32d-11e6-9ef7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/dd19e344-a32d-11e6-8350-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-05 20:31:28","publishedAtDiffForHumans":"2天前","badgeUrl":"http://img01.eqingdan.com/c2f270ee-9cf7-11e6-af44-00163e004c5e.png","thingCount":30,"reviewCount":82,"links":{"self":"http://api.eqingdan.com/v1/rankings/41","share":"http://www.eqingdan.com/mobile/rankings/deodorant"}},{"id":40,"title":"洗手液","slug":"liquid_soap","featuredImageUrl":"http://img01.eqingdan.com/d42ffb88-a189-11e6-91b8-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/d529a278-a189-11e6-bc16-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-03 19:24:17","publishedAtDiffForHumans":"4天前","badgeUrl":"http://img01.eqingdan.com/c2f270ee-9cf7-11e6-af44-00163e004c5e.png","thingCount":27,"reviewCount":100,"links":{"self":"http://api.eqingdan.com/v1/rankings/40","share":"http://www.eqingdan.com/mobile/rankings/liquid_soap"}},{"id":28,"title":"眼霜","slug":"eye_cream","featuredImageUrl":"http://img01.eqingdan.com/c41d8d14-8bcc-11e6-8d90-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/c73f1440-8bcc-11e6-bd87-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-02 13:00:00","publishedAtDiffForHumans":"5天前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":58,"reviewCount":679,"links":{"self":"http://api.eqingdan.com/v1/rankings/28","share":"http://www.eqingdan.com/mobile/rankings/eye_cream"}},{"id":26,"title":"化妆棉","slug":"cosmetic_cotton","featuredImageUrl":"http://img01.eqingdan.com/e4188138-8ae5-11e6-8f25-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/0e418bf8-8af0-11e6-a8d8-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-01 13:15:00","publishedAtDiffForHumans":"6天前","badgeUrl":"","thingCount":13,"reviewCount":112,"links":{"self":"http://api.eqingdan.com/v1/rankings/26","share":"http://www.eqingdan.com/mobile/rankings/cosmetic_cotton"}},{"id":33,"title":"乳液","slug":"lotion","featuredImageUrl":"http://img01.eqingdan.com/a5767c94-91c2-11e6-92a3-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/a9108836-91c2-11e6-ae5a-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 13:16:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":36,"reviewCount":180,"links":{"self":"http://api.eqingdan.com/v1/rankings/33","share":"http://www.eqingdan.com/mobile/rankings/lotion"}},{"id":6,"title":"磨砂膏","slug":"scrub","featuredImageUrl":"http://img01.eqingdan.com/e0295626-6dc9-11e6-8230-00163e004c5e.png?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/fd37266a-73de-11e6-a71a-00163e004c5e.png?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 08:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":42,"reviewCount":167,"links":{"self":"http://api.eqingdan.com/v1/rankings/6","share":"http://www.eqingdan.com/mobile/rankings/scrub"}},{"id":39,"title":"身体乳","slug":"body_lotion","featuredImageUrl":"http://img01.eqingdan.com/2b3beae4-9f33-11e6-b277-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/2c11a418-9f33-11e6-a554-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 07:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":52,"reviewCount":222,"links":{"self":"http://api.eqingdan.com/v1/rankings/39","share":"http://www.eqingdan.com/mobile/rankings/body_lotion"}},{"id":20,"title":"睫毛膏","slug":"mascara","featuredImageUrl":"http://img01.eqingdan.com/ddb5ea3a-8179-11e6-ab70-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/61d1a6de-85e8-11e6-9c17-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-30 13:18:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":69,"reviewCount":373,"links":{"self":"http://api.eqingdan.com/v1/rankings/20","share":"http://www.eqingdan.com/mobile/rankings/mascara"}},{"id":35,"title":"美容仪器","slug":"beauty","featuredImageUrl":"http://img01.eqingdan.com/addfa5d2-9685-11e6-83ab-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/aef30d7e-9685-11e6-9cc3-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-30 12:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":23,"reviewCount":87,"links":{"self":"http://api.eqingdan.com/v1/rankings/35","share":"http://www.eqingdan.com/mobile/rankings/beauty"}},{"id":2,"title":"卫生巾&棉条","slug":"tampon","featuredImageUrl":"http://img01.eqingdan.com/ccb2f0d0-6dc8-11e6-9db5-00163e002745.png?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/6a42b44a-765f-11e6-b675-00163e002745.png?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-29 12:00:00","publishedAtDiffForHumans":"1周前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":97,"reviewCount":565,"links":{"self":"http://api.eqingdan.com/v1/rankings/2","share":"http://www.eqingdan.com/mobile/rankings/tampon"}}],"meta":{"pagination":{"total":34,"count":10,"per_page":10,"current_page":1,"total_pages":4,"links":{"next":"http://api.eqingdan.com/v1/rankings?page=2"}}}}
     */

    private int code;
    private String message;
    /**
     * rankings : [{"id":41,"title":"止汗露","slug":"deodorant","featuredImageUrl":"http://img01.eqingdan.com/dbf4b2fa-a32d-11e6-9ef7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/dd19e344-a32d-11e6-8350-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-05 20:31:28","publishedAtDiffForHumans":"2天前","badgeUrl":"http://img01.eqingdan.com/c2f270ee-9cf7-11e6-af44-00163e004c5e.png","thingCount":30,"reviewCount":82,"links":{"self":"http://api.eqingdan.com/v1/rankings/41","share":"http://www.eqingdan.com/mobile/rankings/deodorant"}},{"id":40,"title":"洗手液","slug":"liquid_soap","featuredImageUrl":"http://img01.eqingdan.com/d42ffb88-a189-11e6-91b8-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/d529a278-a189-11e6-bc16-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-03 19:24:17","publishedAtDiffForHumans":"4天前","badgeUrl":"http://img01.eqingdan.com/c2f270ee-9cf7-11e6-af44-00163e004c5e.png","thingCount":27,"reviewCount":100,"links":{"self":"http://api.eqingdan.com/v1/rankings/40","share":"http://www.eqingdan.com/mobile/rankings/liquid_soap"}},{"id":28,"title":"眼霜","slug":"eye_cream","featuredImageUrl":"http://img01.eqingdan.com/c41d8d14-8bcc-11e6-8d90-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/c73f1440-8bcc-11e6-bd87-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-02 13:00:00","publishedAtDiffForHumans":"5天前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":58,"reviewCount":679,"links":{"self":"http://api.eqingdan.com/v1/rankings/28","share":"http://www.eqingdan.com/mobile/rankings/eye_cream"}},{"id":26,"title":"化妆棉","slug":"cosmetic_cotton","featuredImageUrl":"http://img01.eqingdan.com/e4188138-8ae5-11e6-8f25-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/0e418bf8-8af0-11e6-a8d8-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-11-01 13:15:00","publishedAtDiffForHumans":"6天前","badgeUrl":"","thingCount":13,"reviewCount":112,"links":{"self":"http://api.eqingdan.com/v1/rankings/26","share":"http://www.eqingdan.com/mobile/rankings/cosmetic_cotton"}},{"id":33,"title":"乳液","slug":"lotion","featuredImageUrl":"http://img01.eqingdan.com/a5767c94-91c2-11e6-92a3-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/a9108836-91c2-11e6-ae5a-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 13:16:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":36,"reviewCount":180,"links":{"self":"http://api.eqingdan.com/v1/rankings/33","share":"http://www.eqingdan.com/mobile/rankings/lotion"}},{"id":6,"title":"磨砂膏","slug":"scrub","featuredImageUrl":"http://img01.eqingdan.com/e0295626-6dc9-11e6-8230-00163e004c5e.png?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/fd37266a-73de-11e6-a71a-00163e004c5e.png?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 08:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":42,"reviewCount":167,"links":{"self":"http://api.eqingdan.com/v1/rankings/6","share":"http://www.eqingdan.com/mobile/rankings/scrub"}},{"id":39,"title":"身体乳","slug":"body_lotion","featuredImageUrl":"http://img01.eqingdan.com/2b3beae4-9f33-11e6-b277-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/2c11a418-9f33-11e6-a554-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-31 07:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":52,"reviewCount":222,"links":{"self":"http://api.eqingdan.com/v1/rankings/39","share":"http://www.eqingdan.com/mobile/rankings/body_lotion"}},{"id":20,"title":"睫毛膏","slug":"mascara","featuredImageUrl":"http://img01.eqingdan.com/ddb5ea3a-8179-11e6-ab70-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/61d1a6de-85e8-11e6-9c17-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-30 13:18:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":69,"reviewCount":373,"links":{"self":"http://api.eqingdan.com/v1/rankings/20","share":"http://www.eqingdan.com/mobile/rankings/mascara"}},{"id":35,"title":"美容仪器","slug":"beauty","featuredImageUrl":"http://img01.eqingdan.com/addfa5d2-9685-11e6-83ab-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/aef30d7e-9685-11e6-9cc3-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-30 12:30:00","publishedAtDiffForHumans":"1周前","badgeUrl":"","thingCount":23,"reviewCount":87,"links":{"self":"http://api.eqingdan.com/v1/rankings/35","share":"http://www.eqingdan.com/mobile/rankings/beauty"}},{"id":2,"title":"卫生巾&棉条","slug":"tampon","featuredImageUrl":"http://img01.eqingdan.com/ccb2f0d0-6dc8-11e6-9db5-00163e002745.png?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/6a42b44a-765f-11e6-b675-00163e002745.png?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-29 12:00:00","publishedAtDiffForHumans":"1周前","badgeUrl":"http://img01.eqingdan.com/ff772f6e-9cf7-11e6-bbb3-00163e004c5e.png","thingCount":97,"reviewCount":565,"links":{"self":"http://api.eqingdan.com/v1/rankings/2","share":"http://www.eqingdan.com/mobile/rankings/tampon"}}]
     * meta : {"pagination":{"total":34,"count":10,"per_page":10,"current_page":1,"total_pages":4,"links":{"next":"http://api.eqingdan.com/v1/rankings?page=2"}}}
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
         * pagination : {"total":34,"count":10,"per_page":10,"current_page":1,"total_pages":4,"links":{"next":"http://api.eqingdan.com/v1/rankings?page=2"}}
         */

        private MetaBean meta;
        /**
         * id : 41
         * title : 止汗露
         * slug : deodorant
         * featuredImageUrl : http://img01.eqingdan.com/dbf4b2fa-a32d-11e6-9ef7-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
         * thumbnailImageUrl : http://img01.eqingdan.com/dd19e344-a32d-11e6-8350-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75
         * body :
         * publishedAt : 2016-11-05 20:31:28
         * publishedAtDiffForHumans : 2天前
         * badgeUrl : http://img01.eqingdan.com/c2f270ee-9cf7-11e6-af44-00163e004c5e.png
         * thingCount : 30
         * reviewCount : 82
         * links : {"self":"http://api.eqingdan.com/v1/rankings/41","share":"http://www.eqingdan.com/mobile/rankings/deodorant"}
         */

        private List<RankingsBean> rankings;

        public MetaBean getMeta() {
            return meta;
        }

        public void setMeta(MetaBean meta) {
            this.meta = meta;
        }

        public List<RankingsBean> getRankings() {
            return rankings;
        }

        public void setRankings(List<RankingsBean> rankings) {
            this.rankings = rankings;
        }

        public static class MetaBean {
            /**
             * total : 34
             * count : 10
             * per_page : 10
             * current_page : 1
             * total_pages : 4
             * links : {"next":"http://api.eqingdan.com/v1/rankings?page=2"}
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
                /**
                 * next : http://api.eqingdan.com/v1/rankings?page=2
                 */

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
                    private String next;

                    public String getNext() {
                        return next;
                    }

                    public void setNext(String next) {
                        this.next = next;
                    }
                }
            }
        }

        public static class RankingsBean {
            private int id;
            private String title;
            private String slug;
            private String featuredImageUrl;
            private String thumbnailImageUrl;
            private String body;
            private String publishedAt;
            private String publishedAtDiffForHumans;
            private String badgeUrl;
            private int thingCount;
            private int reviewCount;
            /**
             * self : http://api.eqingdan.com/v1/rankings/41
             * share : http://www.eqingdan.com/mobile/rankings/deodorant
             */

            private LinksBean links;

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

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getFeaturedImageUrl() {
                return featuredImageUrl;
            }

            public void setFeaturedImageUrl(String featuredImageUrl) {
                this.featuredImageUrl = featuredImageUrl;
            }

            public String getThumbnailImageUrl() {
                return thumbnailImageUrl;
            }

            public void setThumbnailImageUrl(String thumbnailImageUrl) {
                this.thumbnailImageUrl = thumbnailImageUrl;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
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

            public String getBadgeUrl() {
                return badgeUrl;
            }

            public void setBadgeUrl(String badgeUrl) {
                this.badgeUrl = badgeUrl;
            }

            public int getThingCount() {
                return thingCount;
            }

            public void setThingCount(int thingCount) {
                this.thingCount = thingCount;
            }

            public int getReviewCount() {
                return reviewCount;
            }

            public void setReviewCount(int reviewCount) {
                this.reviewCount = reviewCount;
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
