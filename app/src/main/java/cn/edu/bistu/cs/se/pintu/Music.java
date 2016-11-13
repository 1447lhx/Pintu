package cn.edu.bistu.cs.se.pintu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import android.content.Context;
import android.media.MediaPlayer;
   
//�����ֽ��в���
public class Music {
	static MediaPlayer player = null;
	static Context mContext;//���������Ķ���
	public static void start(Context context,int musicid,boolean loop){
		if (mContext == null) {
			mContext = context;
		}
				
		if (player!=null&&player.isPlaying()) {
			player.reset();
			player = null;
		}
		player = MediaPlayer.create(context, musicid);	
		if (loop) {

			player.setLooping(true);
		}
		player.start();
	}

	public static boolean playing(){
		if (player!=null&&player.isPlaying()) {
			return true;
		}
		return false;
		
	}
	//ֹͣ����
	public static void stop(){
		if (player.isPlaying()) {
			player.stop();
		}
	}
	public static boolean musicState;//����״̬
	static int MyVolume;//����ֵ

	public static void saveMusic(int volume){
		FileOutputStream fos =null;
		DataOutputStream dos = null;
		try {
			fos = mContext.openFileOutput("zxsc.doc", Context.MODE_PRIVATE);
			dos = new DataOutputStream(fos);
			dos.writeBoolean(musicState);
			dos.writeInt(volume);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//������������
	public static void loadMusic(){
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			if (mContext.openFileInput("zxsc.doc")!=null) {
				fis = mContext.openFileInput("zxsc.doc");
				dis = new DataInputStream(fis);
				musicState = dis.readBoolean();
				MyVolume = dis.readInt();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (mContext.openFileInput("zxsc.doc")!=null) {
				dis.close();
				fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
