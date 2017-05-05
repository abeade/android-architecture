package com.abeade.android.architecture.testapp;


import com.abeade.android.architecture.testapp.data.network.model.response.BaseResponseDto;
import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;
import com.abeade.android.architecture.testapp.domain.interactor.UsersUseCase;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.domain.repository.UsersRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.when;

public class TestUseCaseUnitTest {

    @Mock
    UsersRepository repository;

    private UsersUseCase interactor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactor = new UsersUseCase(repository);
    }

    @Test
    public void testLoadInitialDataSuccess() {
        Mockito.reset(repository);

        BaseResponseDto<UserDto> data = new BaseResponseDto<>();
        data.setData(new UserDto(0, "Name", "test@test.com", "Address", "Bio", "Image"));
        when(repository.getUser(0)).thenReturn(Observable.just(data));

        TestObserver<UserViewItem> testObserver = new TestObserver<>();

        interactor.getObservable(0)
                .blockingSubscribe(testObserver);

        testObserver.assertComplete();
        testObserver.assertNoErrors();
        //noinspection unchecked,SuspiciousToArrayCall
        testObserver.assertResult(new UserViewItem(0, "Test", null, null, null, null));
    }
}