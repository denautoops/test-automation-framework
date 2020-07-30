package core.test;

import core.test.extentions.CallbackExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CallbackExtension.class)
public abstract class BaseWebTest {

    @BeforeEach
    public void preCondition() {
    }

    @AfterEach
    public void postCondition() {
    }

}
