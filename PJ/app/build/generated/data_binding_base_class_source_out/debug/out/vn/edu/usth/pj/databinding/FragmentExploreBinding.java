// Generated by view binder compiler. Do not edit!
package vn.edu.usth.pj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import vn.edu.usth.pj.R;

public final class FragmentExploreBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView featured;

  @NonNull
  public final TextView news;

  @NonNull
  public final RecyclerView newsRecycle;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final AppCompatImageButton searchviewHome;

  @NonNull
  public final MaterialCardView tfa;

  @NonNull
  public final TextView tfaDesc;

  @NonNull
  public final TextView tfaExtract;

  @NonNull
  public final ImageView tfaImg;

  @NonNull
  public final TextView tfaTitle;

  @NonNull
  public final TextView topread;

  @NonNull
  public final RecyclerView topreadRecycle;

  private FragmentExploreBinding(@NonNull ScrollView rootView, @NonNull TextView featured,
      @NonNull TextView news, @NonNull RecyclerView newsRecycle, @NonNull ProgressBar progressBar,
      @NonNull AppCompatImageButton searchviewHome, @NonNull MaterialCardView tfa,
      @NonNull TextView tfaDesc, @NonNull TextView tfaExtract, @NonNull ImageView tfaImg,
      @NonNull TextView tfaTitle, @NonNull TextView topread, @NonNull RecyclerView topreadRecycle) {
    this.rootView = rootView;
    this.featured = featured;
    this.news = news;
    this.newsRecycle = newsRecycle;
    this.progressBar = progressBar;
    this.searchviewHome = searchviewHome;
    this.tfa = tfa;
    this.tfaDesc = tfaDesc;
    this.tfaExtract = tfaExtract;
    this.tfaImg = tfaImg;
    this.tfaTitle = tfaTitle;
    this.topread = topread;
    this.topreadRecycle = topreadRecycle;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentExploreBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentExploreBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_explore, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentExploreBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.featured;
      TextView featured = ViewBindings.findChildViewById(rootView, id);
      if (featured == null) {
        break missingId;
      }

      id = R.id.news;
      TextView news = ViewBindings.findChildViewById(rootView, id);
      if (news == null) {
        break missingId;
      }

      id = R.id.news_recycle;
      RecyclerView newsRecycle = ViewBindings.findChildViewById(rootView, id);
      if (newsRecycle == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.searchview_home;
      AppCompatImageButton searchviewHome = ViewBindings.findChildViewById(rootView, id);
      if (searchviewHome == null) {
        break missingId;
      }

      id = R.id.tfa;
      MaterialCardView tfa = ViewBindings.findChildViewById(rootView, id);
      if (tfa == null) {
        break missingId;
      }

      id = R.id.tfa_desc;
      TextView tfaDesc = ViewBindings.findChildViewById(rootView, id);
      if (tfaDesc == null) {
        break missingId;
      }

      id = R.id.tfa_extract;
      TextView tfaExtract = ViewBindings.findChildViewById(rootView, id);
      if (tfaExtract == null) {
        break missingId;
      }

      id = R.id.tfa_img;
      ImageView tfaImg = ViewBindings.findChildViewById(rootView, id);
      if (tfaImg == null) {
        break missingId;
      }

      id = R.id.tfa_title;
      TextView tfaTitle = ViewBindings.findChildViewById(rootView, id);
      if (tfaTitle == null) {
        break missingId;
      }

      id = R.id.topread;
      TextView topread = ViewBindings.findChildViewById(rootView, id);
      if (topread == null) {
        break missingId;
      }

      id = R.id.topread_recycle;
      RecyclerView topreadRecycle = ViewBindings.findChildViewById(rootView, id);
      if (topreadRecycle == null) {
        break missingId;
      }

      return new FragmentExploreBinding((ScrollView) rootView, featured, news, newsRecycle,
          progressBar, searchviewHome, tfa, tfaDesc, tfaExtract, tfaImg, tfaTitle, topread,
          topreadRecycle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
