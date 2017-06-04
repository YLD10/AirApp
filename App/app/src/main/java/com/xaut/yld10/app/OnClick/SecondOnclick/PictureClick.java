package com.xaut.yld10.app.OnClick.SecondOnclick;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xaut.yld10.app.ContextUtil;
import com.xaut.yld10.app.DensityUtil;
import com.xaut.yld10.app.R;

/**
 * PictureClick.java
 * @Author : YLD10
 * @EditTime : 2017/5/21 13:53
 **/
public class PictureClick {
    private static PopupWindow popupWindow;
    private static EditText editText;
    private static ImageButton imageButton;
    private static ImageView imageView;
    private static TextView dividerLineVertical, textViewTempMe, textViewHumiMe, textViewAirMe,
                    textViewTempFri, textViewHumiFri, textViewAirFri;
    private static RelativeLayout relativeInfoMe, relativeInfoFriend;
    private static int i = 0;
    private final int popupwindow_width = 260, popupwindow_height = 300;

    public PictureClick(final AppCompatActivity act, View view) {

        View contentView = LayoutInflater.from(act)
                            .inflate(R.layout.infomation_popupwindow,null);
        setPopupWindow(new PopupWindow(contentView,
                        DensityUtil.dp2px(ContextUtil.getInstance(),getPopupwindow_width()),
                        DensityUtil.dp2px(ContextUtil.getInstance(),getPopupwindow_height()),true));
        getPopupWindow().setContentView(contentView);

        setEditText((EditText) contentView.findViewById(R.id.editText_Comment));
        setImageButton((ImageButton) contentView.findViewById(R.id.imageButton_Comment));
        setImageView((ImageView) contentView.findViewById(R.id.imageView_Like));
        setDividerLineVertical((TextView) contentView.findViewById(R.id.textView_DividerLine_Vertical));
        setTextViewTempMe((TextView) contentView.findViewById(R.id.textView_Info_Me_Temp));
        setTextViewHumiMe((TextView) contentView.findViewById(R.id.textView_Info_Me_Humi));
        setTextViewAirMe((TextView) contentView.findViewById(R.id.textView_Info_Me_Air));
        setTextViewTempFri((TextView) contentView.findViewById(R.id.textView_Info_Fri_Temp));
        setTextViewHumiFri((TextView) contentView.findViewById(R.id.textView_Info_Fri_Humi));
        setTextViewAirFri((TextView) contentView.findViewById(R.id.textView_Info_Fri_Air));
        setRelativeInfoMe((RelativeLayout) contentView.findViewById(R.id.relativeLayout_Info_Me));
        setRelativeInfoFriend((RelativeLayout) contentView.findViewById(R.id.relativeLayout_Info_Friend));

        showPopupWindow(act,view);
    }

    public void showPopupWindow(AppCompatActivity act, View view) {
        getEditText().setText("");
        getTextViewTempMe().setText("温度：23℃");
        getTextViewHumiMe().setText("湿度：52%");
        getTextViewAirMe().setText("空气质量：80");

        if (view.getId() == R.id.imageView_Me) {
            getDividerLineVertical().setVisibility(View.GONE);
            getRelativeInfoFriend().setVisibility(View.GONE);
            getImageView().setVisibility(View.GONE);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            getRelativeInfoMe().setLayoutParams(param);
        }else {
            getTextViewTempFri().setText("温度：25℃");
            getTextViewHumiFri().setText("湿度：70%");
            getTextViewAirFri().setText("空气质量：110");
            getImageView().setSelected(false);
            getDividerLineVertical().setVisibility(View.VISIBLE);
            getRelativeInfoFriend().setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                                DensityUtil.dp2px(ContextUtil.getInstance(),getPopupwindow_width()/2),
                                LinearLayout.LayoutParams.MATCH_PARENT);
            getRelativeInfoMe().setLayoutParams(param);
        }

        getPopupWindow().setBackgroundDrawable(new ColorDrawable(0));
        getPopupWindow().setFocusable(true);
        getPopupWindow().setTouchable(true);
        getPopupWindow().setOutsideTouchable(true);
        getPopupWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getPopupWindow().showAtLocation(LayoutInflater.from(act)
                .inflate(R.layout.fragment_friends,null),Gravity.CENTER,0,0);

        clickListener(act);
    }

    public void clickListener(final AppCompatActivity act) {
        getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 1) {
                    getImageView().setSelected(false);
                    i = 0;
                }else {
                    getImageView().setSelected(true);
                    ++ i;
                }
            }
        });

        getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = getEditText().getText().toString().trim();
                if (!comment.equals("") && comment != null) {
                    getEditText().setText("");
                    Toast.makeText(act, "您的评论是：" + comment, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public static void setPopupWindow(PopupWindow popupWindow) {
        PictureClick.popupWindow = popupWindow;
    }

    public static EditText getEditText() {
        return editText;
    }

    public static void setEditText(EditText editText) {
        PictureClick.editText = editText;
    }

    public static ImageButton getImageButton() {
        return imageButton;
    }

    public static void setImageButton(ImageButton imageButton) {
        PictureClick.imageButton = imageButton;
    }

    public static ImageView getImageView() {
        return imageView;
    }

    public static void setImageView(ImageView imageView) {
        PictureClick.imageView = imageView;
    }

    public static TextView getDividerLineVertical() {
        return dividerLineVertical;
    }

    public static void setDividerLineVertical(TextView dividerLineVertical) {
        PictureClick.dividerLineVertical = dividerLineVertical;
    }

    public static TextView getTextViewTempMe() {
        return textViewTempMe;
    }

    public static void setTextViewTempMe(TextView textViewTempMe) {
        PictureClick.textViewTempMe = textViewTempMe;
    }

    public static TextView getTextViewHumiMe() {
        return textViewHumiMe;
    }

    public static void setTextViewHumiMe(TextView textViewHumiMe) {
        PictureClick.textViewHumiMe = textViewHumiMe;
    }

    public static TextView getTextViewAirMe() {
        return textViewAirMe;
    }

    public static void setTextViewAirMe(TextView textViewAirMe) {
        PictureClick.textViewAirMe = textViewAirMe;
    }

    public static TextView getTextViewTempFri() {
        return textViewTempFri;
    }

    public static void setTextViewTempFri(TextView textViewTempFri) {
        PictureClick.textViewTempFri = textViewTempFri;
    }

    public static TextView getTextViewHumiFri() {
        return textViewHumiFri;
    }

    public static void setTextViewHumiFri(TextView textViewHumiFri) {
        PictureClick.textViewHumiFri = textViewHumiFri;
    }

    public static TextView getTextViewAirFri() {
        return textViewAirFri;
    }

    public static void setTextViewAirFri(TextView textViewAirFri) {
        PictureClick.textViewAirFri = textViewAirFri;
    }

    public static RelativeLayout getRelativeInfoMe() {
        return relativeInfoMe;
    }

    public static void setRelativeInfoMe(RelativeLayout relativeInfoMe) {
        PictureClick.relativeInfoMe = relativeInfoMe;
    }

    public static RelativeLayout getRelativeInfoFriend() {
        return relativeInfoFriend;
    }

    public static void setRelativeInfoFriend(RelativeLayout relativeInfoFriend) {
        PictureClick.relativeInfoFriend = relativeInfoFriend;
    }

    public int getPopupwindow_width() {
        return popupwindow_width;
    }

    public int getPopupwindow_height() {
        return popupwindow_height;
    }
}
