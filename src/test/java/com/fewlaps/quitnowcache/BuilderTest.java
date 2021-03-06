package com.fewlaps.quitnowcache;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void testDefaultBuilder() {
        QNCache<Object> cache = new QNCacheBuilder().createQNCache();

        assertTrue(cache.isCaseSensitiveKeys());
        assertNull(cache.getAutoReleaseInSeconds());
        assertNull(cache.getDefaultKeepaliveInMillis());
    }

    @Test
    public void testSettingTrueCaseSensitiveKeysBuilder() {
        QNCache<Object>  cache = new QNCacheBuilder().setCaseSensitiveKeys(true).createQNCache();

        assertTrue(cache.isCaseSensitiveKeys());
    }

    @Test
    public void testSettingFalseCaseSensitiveKeysBuilder() {
        QNCache<Object>  cache = new QNCacheBuilder().setCaseSensitiveKeys(false).createQNCache();

        assertFalse(cache.isCaseSensitiveKeys());
    }

    @Test
    public void testSettingMinusOneAutoReleaseSecondsBuilder() {
        QNCache<Object>  cache = new QNCacheBuilder().setAutoReleaseInSeconds(-1).createQNCache();

        assertNull(cache.getAutoReleaseInSeconds());
    }

    @Test
    public void testSetting10AutoReleaseSecondsBuilder() {
        QNCache<Object>  cache = new QNCacheBuilder().setAutoReleaseInSeconds(10).createQNCache();

        assertEquals(Integer.valueOf(10), cache.getAutoReleaseInSeconds());
    }

    @Test
    public void testSettingDefaultKeepaliveBuilder_with10() {
        QNCache<Object>  cache = new QNCacheBuilder().setDefaultKeepaliveInMillis(10).createQNCache();

        assertEquals(Long.valueOf(10), cache.getDefaultKeepaliveInMillis());
    }

    @Test
    public void testSettingDefaultKeepaliveBuilder_withZero() {
        QNCache<Object>  cache = new QNCacheBuilder().setDefaultKeepaliveInMillis(0).createQNCache();

        assertNull(cache.getDefaultKeepaliveInMillis());
    }

    @Test
    public void testSettingDefaultKeepaliveBuilder_withMinusTen() {
        QNCache<Object>  cache = new QNCacheBuilder().setDefaultKeepaliveInMillis(-10).createQNCache();

        assertNull(cache.getDefaultKeepaliveInMillis());
    }

    @Test
    public void testQNCacheDefaultKeepaliveIsForever() {
        QNCache<Object>  cache = new QNCacheBuilder().setDefaultKeepaliveInMillis(QNCache.KEEPALIVE_FOREVER).createQNCache();

        assertNull(cache.getDefaultKeepaliveInMillis());
    }
}
