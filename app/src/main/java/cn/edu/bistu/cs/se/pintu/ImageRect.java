package cn.edu.bistu.cs.se.pintu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * �и�ͼƬ
 * @author Administrator
 *
 */
	public class ImageRect {
		public int xline,yline;//ͼƬ����ʾ����
		public static int rectW,rectH;//�и��ͼƬ�Ŀ��
		Bitmap rectBitmap;//��ǰ��Ϸ��ͼƬ
/**
 * 
 * @param currentIMG ͼƬ
 * @param size��Ϸ�Ѷ�3*3 
 * @param id��Ӧ����id id= 0 1 2 3 4 5 6 7 8
 */
		public ImageRect(Bitmap currentIMG,int size,int id){
			xline = id%size;//0 1 2 0 1 2 0 1 2
			yline = id/size;//0 0 0 1 1 1 2 2 2 
			rectW = currentIMG.getWidth()/size;
			rectH = currentIMG.getHeight()/size;
			if (id ==size*size-1) {
				/**
				 * Config:�洢��ɫֵ��λ��Խ�ߣ�ͼ��Խ����
				 */
				rectBitmap= Bitmap.createBitmap(rectW, rectH, Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(rectBitmap);
				canvas.drawColor(Color.WHITE);
			}else {
				rectBitmap = Bitmap.createBitmap(currentIMG, xline*rectW, yline*rectH, rectW, rectH);
			}
	
		}
		public void paint(Canvas canvas,int x,int y,Paint paint) {
			
			canvas.drawBitmap(rectBitmap, x, y,null);
		}
		
		
}
