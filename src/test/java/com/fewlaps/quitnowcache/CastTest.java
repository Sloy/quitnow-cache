package com.fewlaps.quitnowcache;

import com.fewlaps.quitnowcache.bean.ObjectTestOne;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class CastTest extends BaseTest {
    QNCache<ObjectTestOne> cache;

    @Before
    public void init() {
        cache = new QNCacheBuilder().createQNCache();
    }

    @Test
    public void saveObjectAndReturnSameInstance() {
        cache.set(A_KEY, new ObjectTestOne());

        assertThat(cache.getOptional(A_KEY).get(), instanceOf(ObjectTestOne.class));
    }

    @Test
    public void shouldCastObject() {
        cache.set(A_KEY, new ObjectTestOne());

        ObjectTestOne objectTestOne = cache.getOptional(A_KEY).get();

        assertThat(objectTestOne, instanceOf(ObjectTestOne.class));
    }

}
