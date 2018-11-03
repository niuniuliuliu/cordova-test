package ck.test;

import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

import java.util.Random;

public class TestDemo extends CordovaPlugin {
    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {

        if ("toast".equals(action)) {
            String str = args.getString(0);
            Toast.makeText(cordova.getActivity(), str, Toast.LENGTH_LONG).show();
            return true;
        } else if ("toastWithCallback".equals(action)) {
            String str = args.getString(0);
            Toast.makeText(cordova.getActivity(), str, Toast.LENGTH_LONG).show();

            Random random = new Random();
            if (random.nextBoolean()) {
                callbackContext.success("execute_callack_success");
            } else {
                callbackContext.error("execute_callack_error");
            }
            return true;
        }
        return super.execute(action, args, callbackContext);

    }