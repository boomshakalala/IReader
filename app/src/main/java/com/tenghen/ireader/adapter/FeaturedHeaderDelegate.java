package com.tenghen.ireader.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chengx.mvp.adapter.ItemViewDelegate;
import com.chengx.mvp.adapter.RecyclerViewHolder;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.tenghen.ireader.R;
import com.tenghen.ireader.module.Banner;
import com.tenghen.ireader.ui.activity.BookTypeActivity;
import com.tenghen.ireader.ui.activity.FreeBookActivity;
import com.tenghen.ireader.ui.activity.MonthlyActivity;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class FeaturedHeaderDelegate  implements ItemViewDelegate<Object>,XBanner.XBannerAdapter {

    private List<String> imgs = new ArrayList<>();
    private Context context;

    public FeaturedHeaderDelegate(Context context) {
        this.context = context;
        imgs.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
        imgs.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
        imgs.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_featured_head;
    }

    @Override
    public boolean isForViewType(Object o, int position) {

        return o instanceof Banner;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {
        XBanner banner = holder.getView(R.id.common_Banner);
        banner.removeAllViews();
        banner.setData(imgs,null);
        banner.setPageTransformer(Transformer.Rotate);
        banner.setmAdapter(this);
        holder.setOnclickListener(R.id.featuredMonthlyBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonthlyActivity.launch(context);
            }
        });
        holder.setOnclickListener(R.id.featuredFreeBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FreeBookActivity.launch(context);
            }
        });
        holder.setOnclickListener(R.id.featuredModernBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookTypeActivity.launch(context);
            }
        });
        holder.setOnclickListener(R.id.featuredAncientBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookTypeActivity.launch(context);
            }
        });
        holder.setOnclickListener(R.id.featuredSupernaturalBtn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookTypeActivity.launch(context);
            }
        });

    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(context).load(imgs.get(position)).into((ImageView) view);
    }
}
