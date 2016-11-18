package kaixin.com.qingdan.gui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kaixin.com.qingdan.BuildConfig;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseArticleComments;
import kaixin.com.qingdan.entity.ResponseArticlesTitle;
import kaixin.com.qingdan.entity.ResponseRelatedArticles;
import kaixin.com.qingdan.gui.Activity.ActivityBase;
import kaixin.com.qingdan.gui.adapter.MyRecycleAdapter;
import kaixin.com.qingdan.mvp.presenter.ArticlePresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.ArticlePresenterImpl;
import kaixin.com.qingdan.mvp.view.ArticleView;
import kaixin.com.qingdan.utils.IntentActivity;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ArticleDetailActivity extends ActivityBase implements ArticleView {
    @BindView(R.id.textview_article_subview_title)
    TextView textviewArticleSubviewTitle;
    @BindView(R.id.imageview_article_back_key)
    ImageView imageviewArticleBackKey;
    @BindView(R.id.imageView_article_subview_title)
    SimpleDraweeView imageViewArticleSubviewTitle;
    @BindView(R.id.textview_articlt_big_title)
    TextView textviewArticltBigTitle;
    @BindView(R.id.image_article_anthor_pic)
    SimpleDraweeView imageArticleAnthorPic;
    @BindView(R.id.textview_article_subview_anthor)
    TextView textviewArticleSubviewAnthor;
    @BindView(R.id.textview_article_publishtime)
    TextView textviewArticlePublishtime;
    @BindView(R.id.textview_article_tag_anthor)
    TextView textviewArticleTagAnthor;
    @BindView(R.id.textview_article_subview_lick_count)
    TextView textviewArticleSubviewLickCount;
    @BindView(R.id.linear_like_count)
    LinearLayout linearLikeCount;
    @BindView(R.id.textview_article_subview_commnets_count)
    TextView textviewArticleSubviewCommnetsCount;
    @BindView(R.id.linear_comments_count)
    LinearLayout linearCommentsCount;
    @BindView(R.id.linear_shared)
    LinearLayout linearShared;
    @BindView(R.id.textview_article_subview_lookup_goods)
    TextView textviewArticleSubviewLookupGoods;
    WebView webView;
    @BindView(R.id.webview_article)
    WebView webviewArticle;
    @BindView(R.id.textview_write_comment)
    TextView textviewWriteComment;
    @BindView(R.id.linear_hit_comment)
    LinearLayout linearHitComment;
    @BindView(R.id.linear_comment_content)
    LinearLayout linearCommentContent;
    @BindView(R.id.linear_no_comment)
    LinearLayout linearNoComment;
    @BindView(R.id.article_subview_tag_title)
    TextView articleSubviewTagTitle;
    @BindView(R.id.materRefresh)
    MaterialRefreshLayout materRefresh;
    @BindView(R.id.article_related_recycler_view)
    RecyclerView articleRelatedRecyclerView;
    @BindView(R.id.root)
    LinearLayout root;
    private ArticlePresenter articlePresenter;
    private int articledID;
    private GridLayoutManager manager;

    @Override
    protected void initViews() {
        // 下载数据

        webView = (WebView) findViewById(R.id.webview_article);
        articlePresenter = new ArticlePresenterImpl(this);
        articledID = getIntent().getIntExtra("article_ID", 0);
        articlePresenter.loadDatas(articledID);
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                materRefresh.autoRefresh();
            }
        }.sendEmptyMessageDelayed(0, 500);


    }

    @Override
    public int getContentViewResId() {
        return R.layout.articled_activity;
    }

    @Override
    public void showArticleTitle(ResponseArticlesTitle articlesTitle) {
        materRefresh.finishRefresh();
        //显示文章头部信息
        Log.d("ArticleDetailActivity", "文章的作者:" + articlesTitle.getData().getAuthor().getNickname());
        imageViewArticleSubviewTitle.setImageURI(articlesTitle.getData().getFeaturedImageUrl());
        imageArticleAnthorPic.setImageURI(articlesTitle.getData().getAuthor().getAvatarUrl());
        textviewArticltBigTitle.setText(articlesTitle.getData().getTitle());
        textviewArticleSubviewAnthor.setText(articlesTitle.getData().getAuthor().getNickname());
        textviewArticleTagAnthor.setText(articlesTitle.getData().getAuthor().getTagline());
        textviewArticlePublishtime.setText(articlesTitle.getData().getPublishedAtDiffForHumans());
        if (articlesTitle.getData().getCategories() != null && articlesTitle.getData().getCategories().size() != 0) {
            articleSubviewTagTitle.setText(articlesTitle.getData().getCategories().get(0).getName());
        }
    }

    @Override
    public void showArticleComments(List<ResponseArticleComments.DataBean.CommentsBean> comments) {
        if (comments == null || comments.size() == 0) {
            linearNoComment.setVisibility(View.VISIBLE);
            return;
        }
        linearCommentContent.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < comments.size(); i++) {
            View view = inflater.inflate(R.layout.article_comment_content, linearCommentContent, false);
            MyCommentViewHolder commentHolder = new MyCommentViewHolder(view);
            commentHolder.imageCommentAnhorImg.setImageURI(comments.get(i).getUser().getAvatarUrl());
            commentHolder.textviewCommentAnhor.setText(comments.get(i).getUser().getNickname());
            commentHolder.textviewCommentTime.setText(comments.get(i).getCreatedAtDiffForHumans());
            commentHolder.textviewCommentAnhorComment.setText(comments.get(i).getBody());
            commentHolder.textviewDianzanCount.setText(comments.get(i).getUpvoteCount() + "");
            linearCommentContent.addView(view);
        }
    }

    @Override
    public void showArticle(final String url) {
        if (BuildConfig.DEBUG) Log.d("ArticleDetailActivity", "文章链接url: " + url);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//设置支持JavaScript
        settings.setAppCacheEnabled(true);//设置缓存
    }

    @Override
    public void showRelatedAtricles(List<ResponseRelatedArticles.DataBean.ArticlesBean> articles) {
        Log.d("ArticleDetailActivity", "articles.get(0).getAuthor():" + articles.size());
        if (articles == null || articles.size() == 0) {
            return;
        }
        MyRecycleAdapter adapter = new MyRecycleAdapter(this, articles);
        articleRelatedRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int article_ID) {
                IntentActivity.IntentToActivity(article_ID, ArticleDetailActivity.this);
            }
        });
    }

    @Override
    public void showLikedCount(int likeCount) {
        if (BuildConfig.DEBUG) Log.d("ArticleDetailActivity", "文章喜欢次数:" + likeCount);
        textviewArticleSubviewLickCount.setText(getString(R.string.like_count, likeCount));
    }

    @Override
    public void showCommentsCount(int commentCount) {
        if (BuildConfig.DEBUG)
            Log.d("ArticleDetailActivity", "文章评论次数:" + commentCount);
        textviewArticleSubviewCommnetsCount.setText(getString(R.string.commentCount, commentCount));
    }

    @Override
    public void showLookUpGoods() {
        textviewArticleSubviewLookupGoods.setVisibility(View.VISIBLE);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        root.setPadding(0,getStatusHeight(),0,0);
        imageviewArticleBackKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        });
        materRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                articlePresenter.loadDatas(articledID);
            }
        });
        //recycleView 设置manage
        manager = new GridLayoutManager(this, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        articleRelatedRecyclerView.setLayoutManager(manager);
    }

    @OnClick({R.id.imageview_article_back_key, R.id.linear_like_count, R.id.linear_comments_count, R.id.linear_shared, R.id.textview_article_subview_lookup_goods})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_article_back_key:
                break;
            case R.id.linear_like_count:
                break;
            case R.id.linear_comments_count:
                break;
            case R.id.linear_shared:
                break;
            case R.id.textview_article_subview_lookup_goods:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
        return true;

    }


    static class MyCommentViewHolder {
        @BindView(R.id.image_comment_anhor_img)
        SimpleDraweeView imageCommentAnhorImg;
        @BindView(R.id.textview_comment_anhor)
        TextView textviewCommentAnhor;
        @BindView(R.id.textview_comment_time)
        TextView textviewCommentTime;
        @BindView(R.id.textview_comment_anhor_comment)
        TextView textviewCommentAnhorComment;
        @BindView(R.id.textview_dianzan_count)
        TextView textviewDianzanCount;
        @BindView(R.id.image_comment_dianzan)
        ImageView imageCommentDianzan;
        @BindView(R.id.image_comment_reply)
        ImageView imageCommentReply;
        @BindView(R.id.relative_hit_reply)
        RelativeLayout relativeHitReply;

        MyCommentViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
