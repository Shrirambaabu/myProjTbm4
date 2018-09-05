package com.freshlancers.sws.ui.fragments.paymentHistory;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BaseView;
import com.freshlancers.sws.base.FragmentContext;
import com.freshlancers.sws.ui.models.Payment;
import com.freshlancers.sws.ui.recyclerAdapter.payment.PaymentListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.payment.PaymentRecyclerAdapter;
import com.freshlancers.sws.utils.EmptyRecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PaymentHistoryFragment extends Fragment implements PaymentHistoryFragmentContract.View, BaseView {

    @Inject
    PaymentHistoryFragmentPresenter paymentHistoryFragmentPresenter;
    @Inject
    PaymentRecyclerAdapter mPaymentRecyclerAdapter;
    @Inject
    ArrayList<Payment> mPaymentArrayList;
    @Inject
    PaymentListPresenter paymentListPresenter;

    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView recyclerView;
    @BindView(R.id.empty_view)
    RelativeLayout emptyView;

    private Context context;

    public PaymentHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

        DaggerPaymentHistoryFragmentComponent.builder()
                .fragmentContext(new FragmentContext(context))
                .build()
                .inject(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_history, container, false);
        ButterKnife.bind(PaymentHistoryFragment.this, view);

        paymentHistoryFragmentPresenter.attach(this);
        paymentHistoryFragmentPresenter.setupShowsRecyclerView(recyclerView, emptyView);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        paymentHistoryFragmentPresenter.detach();
    }

    @Override
    public void showRecyclerView() {
        recyclerView.setAdapter(mPaymentRecyclerAdapter);
        paymentHistoryFragmentPresenter.populateRecyclerView(mPaymentArrayList);
    }

    @Override
    public void updateAdapter() {
        mPaymentRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {

    }
}
