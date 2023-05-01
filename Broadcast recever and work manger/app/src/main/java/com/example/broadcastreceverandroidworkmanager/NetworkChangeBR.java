package com.example.broadcastreceverandroidworkmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NetworkChangeBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.no_network_connection);
        Button button = dialog.findViewById(R.id.retry_button_id);
        dialog.show();
        dialog.setCancelable(false);
        try {

            if (isOnline(context)) {

                dialog.dismiss();
                dialog.cancel();
                Toast.makeText(context, "Net connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network not connected", Toast.LENGTH_SHORT).show();


            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}