// Generated by view binder compiler. Do not edit!
package com.example.TrackYourSleep.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.TrackYourSleep.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentStatsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView fragmentStatsAverage;

  @NonNull
  public final LinearLayout fragmentStatsAverageLayout;

  @NonNull
  public final TextView fragmentStatsDaily;

  @NonNull
  public final LinearLayout fragmentStatsDailyLayout;

  @NonNull
  public final TextView fragmentStatsSleeps;

  @NonNull
  public final LinearLayout lastWeekBody;

  private FragmentStatsBinding(@NonNull LinearLayout rootView,
      @NonNull TextView fragmentStatsAverage, @NonNull LinearLayout fragmentStatsAverageLayout,
      @NonNull TextView fragmentStatsDaily, @NonNull LinearLayout fragmentStatsDailyLayout,
      @NonNull TextView fragmentStatsSleeps, @NonNull LinearLayout lastWeekBody) {
    this.rootView = rootView;
    this.fragmentStatsAverage = fragmentStatsAverage;
    this.fragmentStatsAverageLayout = fragmentStatsAverageLayout;
    this.fragmentStatsDaily = fragmentStatsDaily;
    this.fragmentStatsDailyLayout = fragmentStatsDailyLayout;
    this.fragmentStatsSleeps = fragmentStatsSleeps;
    this.lastWeekBody = lastWeekBody;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentStatsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentStatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_stats, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentStatsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fragment_stats_average;
      TextView fragmentStatsAverage = ViewBindings.findChildViewById(rootView, id);
      if (fragmentStatsAverage == null) {
        break missingId;
      }

      id = R.id.fragment_stats_average_layout;
      LinearLayout fragmentStatsAverageLayout = ViewBindings.findChildViewById(rootView, id);
      if (fragmentStatsAverageLayout == null) {
        break missingId;
      }

      id = R.id.fragment_stats_daily;
      TextView fragmentStatsDaily = ViewBindings.findChildViewById(rootView, id);
      if (fragmentStatsDaily == null) {
        break missingId;
      }

      id = R.id.fragment_stats_daily_layout;
      LinearLayout fragmentStatsDailyLayout = ViewBindings.findChildViewById(rootView, id);
      if (fragmentStatsDailyLayout == null) {
        break missingId;
      }

      id = R.id.fragment_stats_sleeps;
      TextView fragmentStatsSleeps = ViewBindings.findChildViewById(rootView, id);
      if (fragmentStatsSleeps == null) {
        break missingId;
      }

      LinearLayout lastWeekBody = (LinearLayout) rootView;

      return new FragmentStatsBinding((LinearLayout) rootView, fragmentStatsAverage,
          fragmentStatsAverageLayout, fragmentStatsDaily, fragmentStatsDailyLayout,
          fragmentStatsSleeps, lastWeekBody);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
