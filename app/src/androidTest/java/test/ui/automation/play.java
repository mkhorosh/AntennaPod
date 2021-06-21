package test.ui.automation;

import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import de.danoeh.antennapod.activity.MainActivity;
import de.danoeh.antennapod.activity.MediaplayerActivity;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class play {
    private static final String BASIC_SAMPLE_PACKAGE
            = "test.ui.automation";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
//    21
    public void subscribe() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject editText = mDevice.findObject(new UiSelector().textStartsWith("Search"));
        editText.waitForExists(LAUNCH_TIMEOUT);
        if (editText == null) {
            throw new UiObjectNotFoundException("search element not found :(");
        }
        editText.setText("kuji podcast");
        mDevice.pressEnter();
        UiObject findText = mDevice.findObject(new UiSelector().textStartsWith("kuji podcast"));
        findText.waitForExists(LAUNCH_TIMEOUT);
        if (findText == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        findText.setText(" ");
        findText = mDevice.findObject(new UiSelector().textStartsWith("kuji podcast"));
        findText.waitForExists(LAUNCH_TIMEOUT);
        if (findText == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        findText.click();
        UiObject sub = mDevice.findObject(new UiSelector().textStartsWith("Subscribe"));
        sub.waitForExists(LAUNCH_TIMEOUT);
        if (sub == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        sub.click();
        UiObject back = mDevice.findObject(new UiSelector().clickable(true));
        back.waitForExists(LAUNCH_TIMEOUT);
        if (back == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        back.click();
        back = mDevice.findObject(new UiSelector().clickable(true));
        back.waitForExists(LAUNCH_TIMEOUT);
        if (back == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        back.click();
        mDevice.pressEnter();
        back = mDevice.findObject(new UiSelector().clickable(true));
        back.waitForExists(LAUNCH_TIMEOUT);
        if (back == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        back.click();
        back = mDevice.findObject(new UiSelector().clickable(true));
        back.waitForExists(LAUNCH_TIMEOUT);
        if (back == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        back.click();
        sub = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        sub.waitForExists(LAUNCH_TIMEOUT);
        if (sub == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        sub.dragTo(sub, 2);
        UiObject ep = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        ep.click();
        UiObject subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.click();
        UiObject down = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        down.click();
        UiObject hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.click();
        UiObject add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.click();
        UiObject confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.click();
        UiSelector select = new UiSelector().textStartsWith("kuji podcast");
        assertThat(select, notNullValue());
        UiObject podcast = mDevice.findObject(new UiSelector().textStartsWith("kuji podcast"));
        podcast.waitForExists(LAUNCH_TIMEOUT);
        if (podcast == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        podcast.dragTo(podcast, 2);
        UiObject remove = mDevice.findObject(new UiSelector().textStartsWith("Remove podcast"));
        remove.waitForExists(LAUNCH_TIMEOUT);
        if (remove == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        remove.click();
        confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.waitForExists(LAUNCH_TIMEOUT);
        if (confirm == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        confirm.click();
        sub = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        sub.waitForExists(LAUNCH_TIMEOUT);
        if (sub == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        sub.dragTo(sub, 2);
        ep = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        ep.click();
        subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.click();
        down = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        down.click();
        hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.click();
        add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.click();
        confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.click();
    }
}
