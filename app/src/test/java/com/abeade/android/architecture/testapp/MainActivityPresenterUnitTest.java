package com.abeade.android.architecture.testapp;


import com.abeade.android.architecture.testapp.domain.interactor.UseCaseExecutor;
import com.abeade.android.architecture.testapp.domain.interactor.UsersUseCase;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenter;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenterImpl;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class MainActivityPresenterUnitTest {

    @Mock
    UsersUseCase useCase;
    @Mock
    MainActivityView view;
    @Mock
    Navigator navigator;

    private MainActivityPresenter presenter;
    private UseCaseExecutor<UserViewItem, Integer> useCaseExecutor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCaseExecutor = new TestUseCaseExecutor<>(useCase);
        presenter = new MainActivityPresenterImpl(view, useCaseExecutor, navigator);
    }

    @Test
    public void testLoadInitialDataSuccess() {
        reset(view, useCase, navigator);

        when(useCase.getObservable(0)).thenReturn(Observable.just(new UserViewItem(0, "Test", null, null, null, null)));
        presenter.loadData();

        verify(view, times(1)).setText(R.string.loading);
        verify(view, times(1)).setText("Test");
        verifyNoMoreInteractions(view);
    }
}