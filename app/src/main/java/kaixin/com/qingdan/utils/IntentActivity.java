package kaixin.com.qingdan.utils;

import android.content.Context;
import android.content.Intent;

import kaixin.com.qingdan.gui.fragment.ArticleDetailActivity;

/**
 * Created by Administrator on 2016/11/4.
 */

public class IntentActivity {
    public static void IntentToActivity(int article_ID, Context context) {
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        intent.putExtra("article_ID",article_ID);
        context.startActivity(intent);
    }
}
