package com.cl;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RateLimiterTest {
    @Test
    public void test1() {
        RateLimiter limiter = RateLimiter.create(1000/60);
        int i = 0;
        while(true){
            if(limiter.tryAcquire(1)){
                log.info("cutTime=" + System.currentTimeMillis() + "执行" + (++i));
            }else {
//                log.info("cutTime=" + System.currentTimeMillis() + "返回" );
            }

        }
    }
}
