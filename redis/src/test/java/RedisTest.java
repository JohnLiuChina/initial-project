import com.demo.redis.RedisApplication;
import com.demo.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Slf4j
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void set() throws Exception {
        redisUtils.set("a", "b", 25);
        System.out.println(redisUtils.get("a"));
    }

    @Test
    public void lockTest() throws InterruptedException {

        new Thread(this::working).start();
        new Thread(this::working).start();
        new Thread(this::working).start();
        new Thread(this::working).start();
        new Thread(this::working).start();
        TimeUnit.SECONDS.sleep(30);

    }

    private void working() {

        String lockId = "A";
        if (redisUtils.tryLock(lockId, 30, 0)) {
            System.out.println(Thread.currentThread().getName() + "get lock");
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "release lock");
                redisUtils.releaseLock(lockId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void expireTest() {

        System.out.println(redisUtils.expire("a", 110));

    }

    @Test
    public void snowFlake() {

        long t = -1;
        System.out.println(Long.toBinaryString(t));
        long shift = 12L;
        System.out.println(Long.toBinaryString(shift));
        System.out.println(Long.toBinaryString(-1L << shift));
        long max = -1 ^ (-1L << shift);
        System.out.println(Long.toBinaryString(max));
        long sequence = 4096 & max;
        System.out.println(Long.toBinaryString(sequence));

    }

}
