// Generated by view binder compiler. Do not edit!
package vn.edu.usth.pj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import vn.edu.usth.pj.R;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button deleteHistory;

  @NonNull
  public final RelativeLayout historyFrame;

  @NonNull
  public final RecyclerView searchHistory;

  @NonNull
  public final AppCompatImageButton searchview;

  @NonNull
  public final TextView textHistory;

  private FragmentSearchBinding(@NonNull RelativeLayout rootView, @NonNull Button deleteHistory,
      @NonNull RelativeLayout historyFrame, @NonNull RecyclerView searchHistory,
      @NonNull AppCompatImageButton searchview, @NonNull TextView textHistory) {
    this.rootView = rootView;
    this.deleteHistory = deleteHistory;
    this.historyFrame = historyFrame;
    this.searchHistory = searchHistory;
    this.searchview = searchview;
    this.textHistory = textHistory;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delete_history;
      Button deleteHistory = ViewBindings.findChildViewById(rootView, id);
      if (deleteHistory == null) {
        break missingId;
      }

      id = R.id.history_frame;
      RelativeLayout historyFrame = ViewBindings.findChildViewById(rootView, id);
      if (historyFrame == null) {
        break missingId;
      }

      id = R.id.search_history;
      RecyclerView searchHistory = ViewBindings.findChildViewById(rootView, id);
      if (searchHistory == null) {
        break missingId;
      }

      id = R.id.searchview;
      AppCompatImageButton searchview = ViewBindings.findChildViewById(rootView, id);
      if (searchview == null) {
        break missingId;
      }

      id = R.id.text_history;
      TextView textHistory = ViewBindings.findChildViewById(rootView, id);
      if (textHistory == null) {
        break missingId;
      }

      return new FragmentSearchBinding((RelativeLayout) rootView, deleteHistory, historyFrame,
          searchHistory, searchview, textHistory);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
