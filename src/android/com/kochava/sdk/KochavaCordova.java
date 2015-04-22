package com.kochava.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.kochava.android.tracker.Feature;

public class KochavaCordova extends CordovaPlugin {

    private Feature kTracker = null;

    @Override
    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException {
        if (action.equals("initializeKochava")) {
	    
            String appToken = args.getString(0);
	    
	    kTracker = new Feature(this.cordova.getActivity().getApplicationContext(), appToken);
	    
            return true;
        } else if (action.equals("trackEvent")) {
	    
            String viewToken = args.optString(0);
            String eventToken = args.optString(1);

	    kTracker.event(viewToken, eventToken);	   

            return true;
        }

        return false;
    }

}
