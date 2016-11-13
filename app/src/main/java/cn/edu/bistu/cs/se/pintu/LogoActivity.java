package cn.edu.bistu.cs.se.pintu;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class LogoActivity extends Activity {
	
   public static LogoActivity logoActivity;
   public static int SCREEN_WIDTH;
   public static int SCREEN_HEIGH;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullScreen();
		//����ͼƬ��ȡ��Ļ�ֱ���
				DisplayMetrics metrics = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(metrics);
				
				SCREEN_WIDTH= metrics.widthPixels;
				SCREEN_HEIGH =metrics.heightPixels;
		LogoView lv = new LogoView(this);
		logoActivity =this;
		setContentView(lv);
		
	}
	//����ȫ��
    public  void setFullScreen(){
    	//ȥ��������
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	//ȥ����Ϣ��
    	Window window = this.getWindow();
    	window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	
    	
    }

	public void gomenu() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(LogoActivity.this,MenuActivity.class);
		LogoActivity.this.startActivity(intent);
		this.finish();
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
