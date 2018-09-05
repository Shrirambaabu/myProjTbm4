package com.freshlancers.sws.ui.activities.markSheet;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 23-12-17.
 */
@Component(modules = {MarkSheetModule.class})
@PerActivityScope
public interface MarkSheetComponent {

    void inject(MarkSheetActivity markSheetActivity);

}
