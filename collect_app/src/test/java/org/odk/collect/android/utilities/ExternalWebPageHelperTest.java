package org.odk.collect.android.utilities;

import android.app.Activity;
import android.net.Uri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static android.net.Uri.parse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class ExternalWebPageHelperTest {

    @Test
    public void uriShouldBeNormalized() {
        Activity activity = Robolectric.buildActivity(Activity.class).get();

        ExternalWebPageHelper externalWebPageHelper = new ExternalWebPageHelper();
        externalWebPageHelper.openWebPage(activity, parse("HTTP://example.com"));

        Uri uri = shadowOf(activity).getNextStartedActivity().getData();
        assertThat(uri, equalTo(Uri.parse("http://example.com")));
    }
}
