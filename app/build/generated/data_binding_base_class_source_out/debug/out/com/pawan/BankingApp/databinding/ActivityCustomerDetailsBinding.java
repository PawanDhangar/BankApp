// Generated by view binder compiler. Do not edit!
package com.pawan.BankingApp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pawan.BankingApp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCustomerDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView detailsBalance;

  @NonNull
  public final TextView detailsEmail;

  @NonNull
  public final TextView detailsName;

  @NonNull
  public final EditText enterAmount;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final Button tranferButton;

  private ActivityCustomerDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView cardView, @NonNull TextView detailsBalance, @NonNull TextView detailsEmail,
      @NonNull TextView detailsName, @NonNull EditText enterAmount, @NonNull Spinner spinner,
      @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14,
      @NonNull TextView textView2, @NonNull TextView textView4, @NonNull TextView textView6,
      @NonNull Button tranferButton) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.detailsBalance = detailsBalance;
    this.detailsEmail = detailsEmail;
    this.detailsName = detailsName;
    this.enterAmount = enterAmount;
    this.spinner = spinner;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView14 = textView14;
    this.textView2 = textView2;
    this.textView4 = textView4;
    this.textView6 = textView6;
    this.tranferButton = tranferButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCustomerDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCustomerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_customer_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCustomerDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.details_balance;
      TextView detailsBalance = ViewBindings.findChildViewById(rootView, id);
      if (detailsBalance == null) {
        break missingId;
      }

      id = R.id.details_email;
      TextView detailsEmail = ViewBindings.findChildViewById(rootView, id);
      if (detailsEmail == null) {
        break missingId;
      }

      id = R.id.details_name;
      TextView detailsName = ViewBindings.findChildViewById(rootView, id);
      if (detailsName == null) {
        break missingId;
      }

      id = R.id.enterAmount;
      EditText enterAmount = ViewBindings.findChildViewById(rootView, id);
      if (enterAmount == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.tranferButton;
      Button tranferButton = ViewBindings.findChildViewById(rootView, id);
      if (tranferButton == null) {
        break missingId;
      }

      return new ActivityCustomerDetailsBinding((ConstraintLayout) rootView, cardView,
          detailsBalance, detailsEmail, detailsName, enterAmount, spinner, textView12, textView13,
          textView14, textView2, textView4, textView6, tranferButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
