package com.freshlancers.sws.ui.fragments.paymentCurrent;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentCurrentFragment extends Fragment implements PaymentCurrentFragmentContract.View, BaseView {

    @Inject
    PaymentCurrentFragmentPresenter currentFragmentPresenter;
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

    public PaymentCurrentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

        DaggerPaymentCurrentFragmentComponent.builder()
                .fragmentContext(new FragmentContext(context))
                .build()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_curent, container, false);
        ButterKnife.bind(PaymentCurrentFragment.this, view);

        currentFragmentPresenter.attach(this);
        currentFragmentPresenter.setupShowsRecyclerView(recyclerView, emptyView);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        currentFragmentPresenter.detach();
    }

    @Override
    public void showRecyclerView() {
        recyclerView.setAdapter(mPaymentRecyclerAdapter);
        currentFragmentPresenter.populateRecyclerView(mPaymentArrayList);
    }

    @Override
    public void updateAdapter() {
        mPaymentRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {

    }

}
