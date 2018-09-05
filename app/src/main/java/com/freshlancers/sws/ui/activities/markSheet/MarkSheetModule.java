package com.freshlancers.sws.ui.activities.markSheet;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.recyclerAdapter.mark.MarkSheetListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.mark.MarkSheetRecyclerAdapter;
import com.freshlancers.sws.ui.models.MarkSheet;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 23-12-17.
 */

@Module(includes = {ActivityContext.class})
@PerActivityScope
public class MarkSheetModule {

    @Provides
    @PerActivityScope
    MarkSheetPresenter providesMarkSheetPresenter(Context context) {
        return new MarkSheetPresenter(context);
    }

    @Provides
    @PerActivityScope
    ArrayList<MarkSheet> providesMarkSheetArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    MarkSheetListPresenter providesMarkSheetListPresenter(Context context, ArrayList<MarkSheet> markSheets) {
        return new MarkSheetListPresenter(context, markSheets);
    }

    @Provides
    @PerActivityScope
    MarkSheetRecyclerAdapter providesEventsRecyclerAdapter(MarkSheetListPresenter marksheetListPresenter) {
        return new MarkSheetRecyclerAdapter(marksheetListPresenter);
    }

}
