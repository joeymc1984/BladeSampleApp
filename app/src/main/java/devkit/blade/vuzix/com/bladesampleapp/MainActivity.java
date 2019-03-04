package devkit.blade.vuzix.com.bladesampleapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.TextView;
import com.vuzix.hud.actionmenu.ActionMenuActivity;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends ActionMenuActivity {

    private MenuItem HelloMenuItem;
    private MenuItem VuzixMenuItem;
    private MenuItem BladeMenuItem;
    private TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected boolean onCreateActionMenu(Menu menu) {
        super.onCreateActionMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        HelloMenuItem = menu.findItem(R.id.item1);
        VuzixMenuItem = menu.findItem(R.id.item2);
        BladeMenuItem = menu.findItem(R.id.item3);
        mainText = findViewById(R.id.mainTextView);
        updateMenuItems();

        return true;
    }

    @Override
    protected boolean alwaysShowActionMenu() {
        return false;
    }

    private void updateMenuItems() {
        if (HelloMenuItem == null) {
            return;
        }

        VuzixMenuItem.setEnabled(false);
        BladeMenuItem.setEnabled(false);
    }


    //Action Menu Click events
    //This events where register via the XML for the menu definitions.
    public void showHello(MenuItem item){

        showToast("Hello World!");
        mainText.setText("Hello World!");
        VuzixMenuItem.setEnabled(true);
        BladeMenuItem.setEnabled(true);
    }

    public void showVuzix(MenuItem item){
        showToast("Vuzix!");
        mainText.setText("Vuzix!");
    }

    public void showBlade(MenuItem item){
        showToast("Blade");
        mainText.setText("Blade");
    }

    private void showToast(final String text){

        final Activity activity = this;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
