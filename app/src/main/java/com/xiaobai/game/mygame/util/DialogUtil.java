package com.xiaobai.game.mygame.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.xiaobai.game.mygame.R;

/**
 * Created on 2018/5/24.
 *  弹窗油条
 * @author wr
 * @version 1.0.0
 */

public class DialogUtil {
    private static AlertDialog alertDialog;
    public static void exit(final Activity activity) {
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            builder.setTitle(activity.getResources().getString(R.string.exit))
                    .setMessage(activity.getResources().getString(R.string.sure_to_exit))
                    .setNegativeButton(activity.getResources().getString(R.string.exit), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            activity.finish();
                            alertDialog = null; //置空
                        }
                    }).setPositiveButton(activity.getResources().getString(R.string.cancle), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog = builder.create();
        }
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(activity.getResources().getColor(R.color.light_dark_text_color));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(activity.getResources().getColor(R.color.blue_text_color));
    }
}
