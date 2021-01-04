package com.tz.leo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Author: tz_wl
 * Date: 2020/7/26 19:00
 * Content:
 */
@Slf4j
public class logTest {

    @Test
   public void testLog() {
        String testInfo = "Free flying flowers are like dreams";
        log.info("The test info is :{}", testInfo);
    }

}
