package kaixin.com.qingdan.gui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kaixin.com.qingdan.R;
import kaixin.com.qingdan.entity.ResponseArticleCollections;
import kaixin.com.qingdan.gui.Activity.ActivityBase;
import kaixin.com.qingdan.mvp.presenter.ArticleCollectionsPresenter;
import kaixin.com.qingdan.mvp.presenter.presenterImpl.ArticleCollectionsPresenterImpl;
import kaixin.com.qingdan.mvp.view.ArticleColltationsView;

/**
 * Created by Administrator on 2016/11/3.
 */
public class ArticleCollectionActivity extends ActivityBase implements ArticleColltationsView {
    @BindView(R.id.textview_article_subview_title)
    TextView textviewArticleSubviewTitle;
    @BindView(R.id.imageview_article_back_key)
    ImageView imageviewArticleBackKey;
    @BindView(R.id.imageView_article_subview_title)
    SimpleDraweeView imageViewArticleSubviewTitle;
    @BindView(R.id.article_subview_tag_title)
    TextView articleSubviewTagTitle;
    @BindView(R.id.textview_big_title)
    TextView textviewBigTitle;
    @BindView(R.id.textview_little_title)
    TextView textviewLittleTitle;
    @BindView(R.id.linear_collection_comment)
    LinearLayout linearCollectionComment;
    private ArticleCollectionsPresenter presenter;

    @Override
    protected void initViews() {

        presenter = new ArticleCollectionsPresenterImpl(this);
        int article_ID = getIntent().getIntExtra("article_ID", 0);
        presenter.loadDatas(article_ID);
    }

    @Override
    public int getContentViewResId() {
        return R.layout.article_collections_activity;
    }

    @Override
    public void showDatas(ResponseArticleCollections articleCollections) {
        ResponseArticleCollections.DataBean1.CollectionBean collectionTitle = articleCollections.getData().getCollection();
        ResponseArticleCollections.DataBean1.CollectionsBean collections = articleCollections.getData().getCollections();
        imageViewArticleSubviewTitle.setImageURI(collectionTitle.getBody().getData().getFeaturedImageUrl());
        textviewBigTitle.setText(collectionTitle.getBody().getData().getTitle());
        textviewLittleTitle.setText(collectionTitle.getBody().getData().getSubtitle());
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < collections.getBody().getData().getArticles().size(); i++) {
            View view = inflater.inflate(R.layout.article_item_collections, linearCollectionComment, false);
            MyCollectionViewHolder mholder = new MyCollectionViewHolder(view);
            mholder.imageCollectionItme.setImageURI(collections.getBody().getData().getArticles().get(i).getFeaturedImageUrl());
            mholder.textviewCollectionContent.setText(collections.getBody().getData().getArticles().get(i).getPublishedAtDiffForHumans());
            mholder.textviewLickLookCount.setText(collections.getBody().getData().getArticles().get(i).getLikeCount()+"");
            mholder.textviewLickCountArticle.setText(collections.getBody().getData().getArticles().get(i).getHitCount()+"");
            linearCollectionComment.addView(view);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        imageviewArticleBackKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    static class MyCollectionViewHolder {
        @BindView(R.id.image_collection_itme)
        SimpleDraweeView imageCollectionItme;
        @BindView(R.id.textview_collection_content)
        TextView textviewCollectionContent;
        @BindView(R.id.textview_lick_count_article)
        TextView textviewLickCountArticle;
        @BindView(R.id.textview_lick_look_count)
        TextView textviewLickLookCount;

        MyCollectionViewHolder(View view) {
            ButterKnife.bind(this, view);

        }
    }
}
