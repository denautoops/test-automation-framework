package tests;

import core.test.extentions.CallbackExtension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CallbackExtension.class)
public abstract class BaseWebTest {

    protected SoftAssertions softly;

    @BeforeEach
    public void preCondition() {
        softly = new SoftAssertions();
    }

    @AfterEach
    public void postCondition() {
        softly.assertAll();
    }

}
