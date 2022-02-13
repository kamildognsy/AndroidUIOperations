package com.my.dgnsyalertdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomAlertDialog {
    private int BUTTON_TYPE_POSITIVE = 1;
    private int BUTTON_TYPE_NEGATIVE = 2;
    private int BUTTON_TYPE_OTHER = 3;
    private Context context;
    private Activity activity;
    private int howManyToShowButton = 0;
    private String alertMessage = "";
    private String positiveButtonText = "";
    private String negativeButtonText = "";
    private String otherButtonText = "";
    private OnAlertSelectListener listener;

    public CustomAlertDialog(Activity activity,int howManyToShowButton, String alertMessage, String positiveButtonText, String negativeButtonText, String otherButtonText, OnAlertSelectListener listener) {
        this.context = activity;
        this.howManyToShowButton = howManyToShowButton;
        this.alertMessage = alertMessage;
        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
        this.otherButtonText = otherButtonText;
        this.listener = listener;
        this.activity = activity;
    }

    public void showMyCustomAlertDialog() {

        // dialog nesnesi oluştur ve layout dosyasına bağlan
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_alert_dialog);

        TextView tv_title_message = dialog.findViewById(R.id.tv_title_message);
        Button btn_positive = (Button) dialog.findViewById(R.id.btn_positive);
        Button btn_negative = (Button) dialog.findViewById(R.id.btn_negative);
        Button btn_other = (Button) dialog.findViewById(R.id.btn_other);

        tv_title_message.setText(alertMessage);
        btn_positive.setText(positiveButtonText);
        if (howManyToShowButton == 1) {
            btn_negative.setVisibility(View.GONE);
            btn_other.setVisibility(View.GONE);
        } else if (howManyToShowButton == 2) {
            btn_other.setVisibility(View.GONE);
            btn_negative.setText(negativeButtonText);
        } else {
            btn_negative.setText(negativeButtonText);
            btn_other.setText(otherButtonText);
        }


        btn_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.isSelected(BUTTON_TYPE_POSITIVE);
                dialog.dismiss();
            }
        });

        btn_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.isSelected(BUTTON_TYPE_NEGATIVE);
                dialog.dismiss();
            }
        });

        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.isSelected(BUTTON_TYPE_OTHER);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
