package app.eth.myscreenon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
//makerj.tistory.com
public class ScreenOnActivity extends Activity {

	PowerManager mPM;
	PowerManager.WakeLock mWakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                |WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_on);
		mPM = (PowerManager) getSystemService(Context.POWER_SERVICE);
		mWakeLock = mPM.newWakeLock(PowerManager.FULL_WAKE_LOCK,"MY WAKE LOCK TAG");
        mWakeLock.acquire();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
	}

	public void MAIN_ONCLICK(View v) {
		switch (v.getId()) {
		case R.id.button1:
			mWakeLock.acquire();
			break;
		case R.id.button2:
			if (mWakeLock.isHeld()) {
				mWakeLock.release();
                finish();
			}
			break;
		}
	}
}
