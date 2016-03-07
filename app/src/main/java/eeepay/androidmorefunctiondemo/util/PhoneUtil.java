package eeepay.androidmorefunctiondemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * 
 * @author xuqingfeng 获取android系统信息及手机信息
 * 
 */
public class PhoneUtil {
	/**
	 * dp值转化成px值
	 * 
	 * @param ctx
	 * @param dpValue
	 * @return
	 */
	public static int dp2px(Context ctx, float dpValue) {
		final float scale = ctx.getResources().getDisplayMetrics().density;
		return (int) (dpValue / scale + 0.5f);
	}

	public static int px2dp(Context ctx, float pxValue) {
		final float scale = ctx.getResources().getDisplayMetrics().density;
		return (int) (pxValue * scale + 0.5f);
	}

	/**
	 * 
	 * 功能：获取屏幕宽度
	 * 
	 * @param ctx
	 * @return
	 */
	public static int getScreenWidth(Context ctx) {
		return ((Activity) ctx).getWindowManager().getDefaultDisplay()
				.getWidth();
	}

	/**
	 * 
	 * 功能：获取屏幕高度
	 * 
	 * @param ctx
	 * @return
	 */
	public static int getScreenHeight(Context ctx) {
		return ((Activity) ctx).getWindowManager().getDefaultDisplay()
				.getHeight();
	}

	/**
	 * 获取当前屏幕分辨率  px   高x宽
	 */
	public static String getScreenPx(Context ctx) {
//		double STANDARD_DENSITY = 160;//标准的密度
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) ctx).getWindowManager().getDefaultDisplay()
				.getMetrics(displayMetrics);
		double	CURRENT_SCREEN_WIDTH_PX = displayMetrics.widthPixels;// px
		double CURRENT_SCREEN_HEIGHT_PX = displayMetrics.heightPixels;// px
		double CURRENT_DENSITY_RATIO = displayMetrics.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
//		double CURRENT_DENSITY = displayMetrics.densityDpi;// 屏幕密度（每寸像素：120/160/240/320）
		int CURRENT_SCREEN_WIDTH_DP = (int)(CURRENT_SCREEN_WIDTH_PX /CURRENT_DENSITY_RATIO+0.5f);
		int CURRENT_SCREEN_HEIGHT_DP = (int)(CURRENT_SCREEN_HEIGHT_PX/CURRENT_DENSITY_RATIO+0.5f);
       return CURRENT_SCREEN_HEIGHT_PX+"x"+CURRENT_SCREEN_WIDTH_PX;
	}

	/**
	 * 
	 * 功能：获取程序版本名
	 * 
	 * @param ctx
	 * @return verName 版本名称
	 */
	public static String getVerName(Context ctx) {
		return String.valueOf(getPi(ctx).versionName);
	}

	/**
	 * 
	 * 功能：获取程序版本码
	 * 
	 * @param ctx
	 * @return verCode 版本码
	 */
	public static String getVerCode(Context ctx) {
		return String.valueOf(getPi(ctx).versionCode);
	}

	public static PackageInfo getPi(Context ctx) {
		PackageManager pm = ctx.getPackageManager();
		PackageInfo pi = null;
		try {
			pi = pm.getPackageInfo(ctx.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}// getPackageName表示获取当前ctx所在的包的名称，0表示获取版本信息
		return pi;
	}

	/**
	 * 去掉标题栏，并全屏显示
	 * 
	 * @param activity
	 */
	public static void setNoTitleFullScreen(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		activity.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	/**
	 * 获取sdk版本号 2.1: 7; 2.2: 8; 2.3.1: 9; 2.3.4: 10
	 * 
	 * @return
	 */
	static public int getSDK() {
		return Integer.valueOf(android.os.Build.VERSION.SDK_INT);
	}

	/**
	 * 获取手机型号 如: Nexus One,I9100
	 * 
	 * @return
	 */
	static public String getModel() {
		return android.os.Build.MODEL;
	}

	/**
	 * 获取发布版本号 2.1;2.2;2.3.4...
	 * 
	 * @return
	 */
	static public String getRelease() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 获取CPU处理器型号，如：armeabi-v7a
	 */
	static public String getCpu() {
		return android.os.Build.CPU_ABI;
	}

	/**
	 * 获取手机制造商，如：samsung
	 */
	static public String getManuFacturer() {
		return android.os.Build.MANUFACTURER;
	}

	/**
	 * 获取商标，如：samsung
	 */
	static public String getBrand() {
		return android.os.Build.BRAND;
	}

	/**
	 * 获取主板,如：GT-I9100
	 */
	static public String getBoard() {
		return android.os.Build.BOARD;
	}

	/**
	 * 获取用户,如：root
	 */
	static public String getUser() {
		return android.os.Build.USER;
	}
	

}
