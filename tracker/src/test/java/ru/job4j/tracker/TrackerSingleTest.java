package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerSingleTest {
    AllSingleton list = new AllSingleton();

    @Before
    public void afterMethod() {
        list.fill();
    }

    @Test
    public void whenEnum() {
        EnumEagerLoading first = (EnumEagerLoading) list.acr.get(0);
        EnumEagerLoading second = EnumEagerLoading.INSTANCE;
        assertThat(first, is(second));
    }

    @Test
    public void whenSingleLazyLoadingStaticField() {
        SingleLazyLoading first = (SingleLazyLoading) list.acr.get(1);
        SingleLazyLoading second = SingleLazyLoading.getInstance();
        assertThat(first, is(second));
    }

    @Test
    public void whenEagerLoadingStaticFinalField() {
        EagerLoading first = (EagerLoading) list.acr.get(2);
        EagerLoading second = EagerLoading.getInstance();
        assertThat(first, is(second));
    }

    @Test
    public void whenTrackerSingleStaticFinalClassLazyLoading() {
        TrackerSingle first = (TrackerSingle) list.acr.get(3);
        TrackerSingle second = TrackerSingle.getInstance();
        assertThat(first, is(second));
    }

}
