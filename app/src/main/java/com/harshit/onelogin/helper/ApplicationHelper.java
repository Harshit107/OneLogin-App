package com.harshit.onelogin.helper;

import android.content.Context;
import android.content.Intent;

public class ApplicationHelper {

    public static void startActivityAndClearTask(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

}
