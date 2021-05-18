package org.apache.cordova.preventoverride;

import org.apache.cordova.CordovaPlugin;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;

public class PreventOverride extends CordovaPlugin {

    private static final String TAG = "PreventOverride";

    /**
     * Allows plugins to handle a link being clicked. Return true here to cancel the navigation.
     *
     * @param url           The URL that is trying to be loaded in the Cordova webview.
     * @return              Return true to prevent the URL from loading. Default is false.
     */
    public boolean onOverrideUrlLoading(String url) {
        Log.d(TAG, "On override URL loading: " + url);

        if (!url.startsWith("http://localhost")) {
            // External site, open it in browser.
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            cordova.getActivity().startActivity(browserIntent);

            return true;
        }

        return false;
    }

}

