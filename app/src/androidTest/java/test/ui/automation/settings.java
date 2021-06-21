package test.ui.automation;

import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.lang.invoke.LambdaConversionException;
import java.util.concurrent.TimeUnit;

import de.danoeh.antennapod.activity.MainActivity;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class settings {
    private static final String BASIC_SAMPLE_PACKAGE
            = "test.ui.automation";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
//    open settings
    public void init() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject menu = mDevice.findObject(new UiSelector().clickable(true));
        menu.waitForExists(LAUNCH_TIMEOUT);
        if (menu == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        menu.click();
        UiObject settings = mDevice.findObject(new UiSelector().textStartsWith("Settings"));
        settings.waitForExists(LAUNCH_TIMEOUT);
        if (settings == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        settings.click();
        UiObject interfaceMenu =
                mDevice.findObject(new UiSelector().textStartsWith("User Interface"));
        interfaceMenu.waitForExists(LAUNCH_TIMEOUT);
        if (interfaceMenu == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        interfaceMenu.click();
    }

    @Test
//    11
    public void changeTheme() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject theme = mDevice.findObject(new UiSelector().textStartsWith("Select Theme"));
        theme.waitForExists(LAUNCH_TIMEOUT);
        if (theme == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        theme.click();
        UiObject light = mDevice.findObject(new UiSelector().textStartsWith("Light"));
        light.waitForExists(LAUNCH_TIMEOUT);
        if (light == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        light.click();
        theme.click();
        assertTrue(light.isChecked());
        UiObject dark = mDevice.findObject(new UiSelector().textStartsWith("Dark"));
        dark.waitForExists(LAUNCH_TIMEOUT);
        if (dark == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        dark.click();
        theme.click();
        assertTrue(dark.isChecked());
        light.click();
    }

    @Test
//    12
    public void menuConfiguration() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject items =
                mDevice.findObject(new UiSelector().textStartsWith("Set Navigation Drawer items"));
        items.waitForExists(LAUNCH_TIMEOUT);
        if (items == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        items.click();
        UiObject queue = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        queue.waitForExists(LAUNCH_TIMEOUT);
        if (queue == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!queue.isChecked()) {
            queue.click();
        }
        UiObject episodes = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        episodes.waitForExists(LAUNCH_TIMEOUT);
        if (episodes == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!episodes.isChecked()) {
            episodes.click();
        }
        UiObject subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.waitForExists(LAUNCH_TIMEOUT);
        if (subs == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!subs.isChecked()) {
            subs.click();
        }
        UiObject downloads = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        downloads.waitForExists(LAUNCH_TIMEOUT);
        if (downloads == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!downloads.isChecked()) {
            downloads.click();
        }
        UiObject hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.waitForExists(LAUNCH_TIMEOUT);
        if (hist == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!hist.isChecked()) {
            hist.click();
        }
        UiObject add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.waitForExists(LAUNCH_TIMEOUT);
        if (add == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!add.isChecked()) {
            add.click();
        }
        UiObject list = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions List"));
        list.waitForExists(LAUNCH_TIMEOUT);
        if (list == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!list.isChecked()) {
            list.click();
        }
        UiObject confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.waitForExists(LAUNCH_TIMEOUT);
        if (confirm == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        confirm.click();
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

        queue = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        queue.waitForExists(LAUNCH_TIMEOUT);
        assertThat(queue, notNullValue());
        episodes = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        episodes.waitForExists(LAUNCH_TIMEOUT);
        assertThat(episodes, notNullValue());
        subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.waitForExists(LAUNCH_TIMEOUT);
        assertThat(subs, notNullValue());
        downloads = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        downloads.waitForExists(LAUNCH_TIMEOUT);
        assertThat(downloads, notNullValue());
        hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.waitForExists(LAUNCH_TIMEOUT);
        assertThat(hist, notNullValue());
        add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.waitForExists(LAUNCH_TIMEOUT);
        assertThat(add, notNullValue());
    }

    @Test
//    13
    public void menuChangeConfiguration() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject items =
                mDevice.findObject(new UiSelector().textStartsWith("Set Navigation Drawer items"));
        items.waitForExists(LAUNCH_TIMEOUT);
        if (items == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        items.click();
        UiObject queue = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        queue.waitForExists(LAUNCH_TIMEOUT);
        if (queue == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (queue.isChecked()) {
            queue.click();
        }
        UiObject episodes = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        episodes.waitForExists(LAUNCH_TIMEOUT);
        if (episodes == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (episodes.isChecked()) {
            episodes.click();
        }
        UiObject subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.waitForExists(LAUNCH_TIMEOUT);
        if (subs == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (subs.isChecked()) {
            subs.click();
        }
        UiObject downloads = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        downloads.waitForExists(LAUNCH_TIMEOUT);
        if (downloads == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (downloads.isChecked()) {
            downloads.click();
        }
        UiObject hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.waitForExists(LAUNCH_TIMEOUT);
        if (hist == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (hist.isChecked()) {
            hist.click();
        }
        UiObject add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.waitForExists(LAUNCH_TIMEOUT);
        if (add == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (add.isChecked()) {
            add.click();
        }
        UiObject list = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions List"));
        list.waitForExists(LAUNCH_TIMEOUT);
        if (list == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (list.isChecked()) {
            list.click();
        }
        UiObject confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.waitForExists(LAUNCH_TIMEOUT);
        if (confirm == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        confirm.click();
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
        UiSelector selec = new UiSelector();
        try {
            selec.textStartsWith("Queue");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        try {
            selec.textStartsWith("Episodes");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        try {
            selec.textStartsWith("Subscriptions");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        try {
            selec.textStartsWith("Downloads");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        try {
            selec.textStartsWith("Playback History");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        try {
            selec.textStartsWith("Add Podcast");
        } catch (NullPointerException e) {
            assertThat(selec, null);
        }
        UiObject settings = mDevice.findObject(new UiSelector().textStartsWith("Settings"));
        settings.waitForExists(LAUNCH_TIMEOUT);
        if (settings == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        settings.click();
        UiObject interfaceMenu =
                mDevice.findObject(new UiSelector().textStartsWith("User Interface"));
        interfaceMenu.waitForExists(LAUNCH_TIMEOUT);
        if (interfaceMenu == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        interfaceMenu.click();
        items =
                mDevice.findObject(new UiSelector().textStartsWith("Set Navigation Drawer items"));
        items.waitForExists(LAUNCH_TIMEOUT);
        if (items == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        items.click();
        queue = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        queue.waitForExists(LAUNCH_TIMEOUT);
        if (queue == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!queue.isChecked()) {
            queue.click();
        }
        episodes = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        episodes.waitForExists(LAUNCH_TIMEOUT);
        if (episodes == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!episodes.isChecked()) {
            episodes.click();
        }
        subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.waitForExists(LAUNCH_TIMEOUT);
        if (subs == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!subs.isChecked()) {
            subs.click();
        }
        downloads = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        downloads.waitForExists(LAUNCH_TIMEOUT);
        if (downloads == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!downloads.isChecked()) {
            downloads.click();
        }
        hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.waitForExists(LAUNCH_TIMEOUT);
        if (hist == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!hist.isChecked()) {
            hist.click();
        }
        add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.waitForExists(LAUNCH_TIMEOUT);
        if (add == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!add.isChecked()) {
            add.click();
        }
        list = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions List"));
        list.waitForExists(LAUNCH_TIMEOUT);
        if (list == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!list.isChecked()) {
            list.click();
        }
        confirm = mDevice.findObject(new UiSelector().textStartsWith("Confirm"));
        confirm.waitForExists(LAUNCH_TIMEOUT);
        if (confirm == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        confirm.click();
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

        queue = mDevice.findObject(new UiSelector().textStartsWith("Queue"));
        queue.waitForExists(LAUNCH_TIMEOUT);
        assertThat(queue, notNullValue());
        episodes = mDevice.findObject(new UiSelector().textStartsWith("Episodes"));
        episodes.waitForExists(LAUNCH_TIMEOUT);
        assertThat(episodes, notNullValue());
        subs = mDevice.findObject(new UiSelector().textStartsWith("Subscriptions"));
        subs.waitForExists(LAUNCH_TIMEOUT);
        assertThat(subs, notNullValue());
        downloads = mDevice.findObject(new UiSelector().textStartsWith("Downloads"));
        downloads.waitForExists(LAUNCH_TIMEOUT);
        assertThat(downloads, notNullValue());
        hist = mDevice.findObject(new UiSelector().textStartsWith("Playback History"));
        hist.waitForExists(LAUNCH_TIMEOUT);
        assertThat(hist, notNullValue());
        add = mDevice.findObject(new UiSelector().textStartsWith("Add Podcast"));
        add.waitForExists(LAUNCH_TIMEOUT);
        assertThat(add, notNullValue());
    }

    @Test
//    14
    public void authorization() throws UiObjectNotFoundException, InterruptedException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject back = mDevice.findObject(new UiSelector().clickable(true));
        back.waitForExists(LAUNCH_TIMEOUT);
        if (back == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        back.click();
        UiObject sync = mDevice.findObject(new UiSelector().textStartsWith("Synchronization"));
        sync.waitForExists(LAUNCH_TIMEOUT);
        if (sync == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        sync.click();
        UiObject login = mDevice.findObject(new UiSelector().textStartsWith("Login"));
        login.waitForExists(LAUNCH_TIMEOUT);
        if (login == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        login.click();
        UiObject custom = mDevice.findObject(new UiSelector().textStartsWith("Custom server"));
        custom.waitForExists(LAUNCH_TIMEOUT);
        if (custom == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        if (!custom.isChecked()) {
            custom.click();
        }
        UiObject server = mDevice.findObject(new UiSelector().textStartsWith("Hostname"));
        server.waitForExists(LAUNCH_TIMEOUT);
        if (server == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        server.setText("gpodder.net");
        UiObject select = mDevice.findObject(new UiSelector().textStartsWith("Select server"));
        select.waitForExists(LAUNCH_TIMEOUT);
        if (select == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        select.click();
        UiObject name = mDevice.findObject(new UiSelector().textStartsWith("Username"));
        name.waitForExists(LAUNCH_TIMEOUT);
        if (name == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        name.setText("test-test");
        UiObject password = mDevice.findObject(new UiSelector().textStartsWith("Password"));
        password.waitForExists(LAUNCH_TIMEOUT);
        if (password == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        password.setText("145test823");
        login = mDevice.findObject(new UiSelector().textStartsWith("Login"));
        login.waitForExists(LAUNCH_TIMEOUT);
        if (login == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        login.clickAndWaitForNewWindow();
        UiObject device = mDevice.findObject(new UiSelector().textStartsWith("Create device"));
        device.waitForExists(LAUNCH_TIMEOUT);
        if (device == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        device.clickAndWaitForNewWindow();
        sync = mDevice.findObject(new UiSelector().textStartsWith("Start sync now"));
        sync.waitForExists(LAUNCH_TIMEOUT);
        if (sync == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        sync.clickAndWaitForNewWindow();
        TimeUnit.SECONDS.sleep(20);
        UiObject logout = mDevice.findObject(new UiSelector().textStartsWith("Logout"));
        assertThat(logout, notNullValue());
        logout.click();
    }
}
