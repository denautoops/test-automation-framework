package core.test.extentions;

import core.report.AllureManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CallbackExtension implements AfterEachCallback, BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        //AllureManager.addBrowserInformationOnAllureReport();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        //AllureManager.takeScreenshotToAttachOnAllureReport();
    }
}
