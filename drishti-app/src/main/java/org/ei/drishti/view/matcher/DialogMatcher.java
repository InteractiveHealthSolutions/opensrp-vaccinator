package org.ei.drishti.view.matcher;

import android.view.View;
import org.ei.drishti.view.AfterChangeListener;
import org.ei.drishti.view.DialogAction;
import org.ei.drishti.view.OnSelectionChangeListener;

public abstract class DialogMatcher<T> implements Matcher<T> {
    private DialogAction dialogForChoosingAnOption;
    private T currentValue;
    private final T defaultValue;

    public DialogMatcher(DialogAction<T> dialogForChoosingAnOption, T defaultValue) {
        this.dialogForChoosingAnOption = dialogForChoosingAnOption;
        this.defaultValue = defaultValue;
        currentValue = this.defaultValue;
    }

    public void setOnChangeListener(final AfterChangeListener afterChangeListener) {
        dialogForChoosingAnOption.setOnSelectionChangedListener(new OnSelectionChangeListener<T>() {
            public void selectionChanged(View actionItemView, T selection) {
                currentValue = selection;
                actionItemView.setSelected(!selection.equals(defaultValue));
                afterChangeListener.afterChangeHappened();
            }
        });
    }

    public T currentValue() {
        return currentValue;
    }
}