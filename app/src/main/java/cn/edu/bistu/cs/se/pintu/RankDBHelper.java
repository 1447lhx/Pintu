package cn.edu.bistu.cs.se.pintu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class RankDBHelper extends SQLiteOpenHelper {

	// ���ݿ������ rank.db
	// ����
	public static final String TABLE_NAME = "Info";
	public RankDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public RankDBHelper(Context context) {
		super(context, "rank.db", null, 1);
	}

	// ������ID���Ѷȼ���ʱ�䣬����
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Info (" // ������ϸ��Ϣ���ݿ��
				+ "_id INTEGER PRIMARY KEY autoincrement,"
				+ "name TEXT,"
				+ "score integer," + "difficulty integer,ranking integer" + ");");
		
		db.execSQL("CREATE TABLE Dif (" // �����Ѷ����ݿ��
				+ "_id INTEGER,"
				+ "dif_dif TEXT" + ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
