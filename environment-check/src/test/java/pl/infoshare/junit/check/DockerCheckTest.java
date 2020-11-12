package pl.infoshare.junit.check;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
public class DockerCheckTest {

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);

    @Test
    public void testSimplePutAndGet() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        assertNotNull(address);
        assertNotNull(port);
    }
}
