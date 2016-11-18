package kaixin.com.qingdan.utils;

/**
 * Created by LG on 2016/10/27.
 * Tips:
 */

public interface Apis {
    /**主页 口碑对应的接口**/
    String URL_REPUTATION = "http://api.eqingdan.com/v1/rankings/front";
    /****文章相关接口***/
    String URL_ARTICLE_TITLE ="http://api.eqingdan.com/v1/articles/{0}";
    String URL_ARTICLE="http://www.eqingdan.com/app/articles/{0}";
    String URL_ARTICLE_COMMENT="http://api.eqingdan.com/v1/comments/hot?target_type=article&target_id={0}&page=1&per_page=4";
    String URL_RELATED_ARTICLES ="http://api.eqingdan.com/v1/articles/{0}/related-articles";
    /******专题文章接口*******/
    String URL_ARTICLE_COLLECTION = "http://api.eqingdan.com/v1/batching";
    String URL_ARTICLE_COLLECTION_BODY ="{\"collections\":{\"method\":\"GET\",\"relative_url\":\"/v1/collections/{0}/articles\"},\"collection\":{\"method\":\"GET\",\"relative_url\":\"/v1/collections/{0}\"}}";
    /*******口碑清单接口*******/
    String URL_MOUTH_LIST = "http://api.eqingdan.com/v1/rankings?page={0}&per=10";
    String API_REPUTATION_THING_SORT_BY_REVIEW_COUNT = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=review-count-desc&page={2}&per=10";
    String API_REPUTATION_THING_SORT_BY_rating_score = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=rating-score-desc&page={2}&per=10";
    String API_REPUTATION_THING_SORT_BY_BRAND_NAME = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=brand-name-asc&page={2}&per=10";
    String URL_CATEGORY = "http://api.eqingdan.com/v1/batching";
    String URL_ALLCATEGORY = "http://api.eqingdan.com/v1/categories?depth=3";
    String URL_DAITYTOP_API = "http://api.eqingdan.com/v1/daily-tips/today";
}
