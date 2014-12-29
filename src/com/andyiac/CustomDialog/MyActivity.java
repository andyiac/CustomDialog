package com.andyiac.CustomDialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MyActivity extends Activity {

    private Dialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showDeleteItemDialog(this);
    }

    public void showDeleteItemDialog(Activity activity) {

        View view = activity.getLayoutInflater().inflate(R.layout.delete_item_dialog, null);
        Button btnDelete = (Button) view.findViewById(R.id.id_dialog_btn_delete);

        // todo  添加回调
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialog = new Dialog(activity, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);

        WindowManager.LayoutParams wl = window.getAttributes();
        // dialog in bottom
        wl.x = 0;
        wl.y = activity.getWindowManager().getDefaultDisplay().getHeight();

        // dialog in center
//        wl.x = 0;
//        wl.y = 0;

        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

}
