package test.ui.automation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.widget.TextView;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import de.danoeh.antennapod.activity.MainActivity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
//@SdkSuppress(minSdkVersion = 18)

public class search {

    private static final int LAUNCH_TIMEOUT = 5000;

    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
//    31
    public void findByName() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject editText = mDevice.findObject(new UiSelector().textStartsWith("Search"));
        editText.waitForExists(LAUNCH_TIMEOUT);
        if (editText != null) {
            editText.setText("kuji podcast");
            mDevice.pressEnter();
            UiObject findText = mDevice.findObject(new UiSelector().textStartsWith("kuji podcast"));
            findText.waitForExists(LAUNCH_TIMEOUT);
            assertThat(findText, notNullValue());
        } else {
            throw new UiObjectNotFoundException("search element not found :(");
        }
    }

    @Test
//    32
    public void openCatalogOfCountry() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
//        prepare
        UiObject moreButton = mDevice.findObject(new UiSelector().textStartsWith("more"));
        moreButton.waitForExists(LAUNCH_TIMEOUT);
        if (moreButton == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        moreButton.clickAndWaitForNewWindow(LAUNCH_TIMEOUT);
        UiObject changeCountry =
                mDevice.findObject(new UiSelector().textStartsWith("Poland"));
        changeCountry.waitForExists(LAUNCH_TIMEOUT);
        if (changeCountry == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        changeCountry.click();

        UiObject country = mDevice.findObject(new UiSelector().textStartsWith("Russia"));
        country.waitForExists(LAUNCH_TIMEOUT);
        if (country == null) {
            throw new UiObjectNotFoundException("country element not found :(");
        }
        country.click();
        UiObject checkCountry = mDevice.findObject(new UiSelector().textStartsWith("Russia"));
        checkCountry.waitForExists(LAUNCH_TIMEOUT);
        assertThat(checkCountry, notNullValue());
        // after prepare
        checkCountry.click();
        changeCountry =
                mDevice.findObject(new UiSelector().textStartsWith("Russia"));
        changeCountry.waitForExists(LAUNCH_TIMEOUT);
        if (changeCountry == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        for (int i = 0; i < 10; i++) {
            changeCountry.swipeDown(10);
        }
        changeCountry = mDevice.findObject(new UiSelector().textStartsWith("Poland"));
        changeCountry.waitForExists(LAUNCH_TIMEOUT);
        if (changeCountry == null) {
            throw new UiObjectNotFoundException("ui element not found :(");
        }
        changeCountry.click();
    }

    @Test
//    33
    public void findByWrongName() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject editText = mDevice.findObject(new UiSelector().textStartsWith("Search"));
        editText.waitForExists(LAUNCH_TIMEOUT);
        if (editText != null) {
            editText.setText("the daily");
            mDevice.pressEnter();
            UiSelector podcast = new UiSelector();
            try {
                podcast.textStartsWith("kuji podcast");
            } catch (NullPointerException e) {
                assertThat(podcast, null);
            }
        } else {
            throw new UiObjectNotFoundException("search element not found :(");
        }
    }

    @Test
//    34
    public void findFake() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject editText = mDevice.findObject(new UiSelector().textStartsWith("Search"));
        editText.waitForExists(LAUNCH_TIMEOUT);
        if (editText != null) {
            editText.setText("panda 333 shark");
            mDevice.pressEnter();
            UiSelector podcast = new UiSelector();
            try {
                podcast.textStartsWith("panda 333 shark");
            } catch (NullPointerException e) {
                assertThat(podcast, null);
            }
        } else {
            throw new UiObjectNotFoundException("search element not found :(");
        }
    }
}
