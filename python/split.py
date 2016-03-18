
sigs = """public class com.opera.mini.android.Browser extends android.app.Activity {
  public static final java.lang.String GA_WEB_PROPERTY_ID_MINI;
    Signature: Ljava/lang/String;
  private static final java.lang.String FIRST_RUN_FLAG;
    Signature: Ljava/lang/String;
  static com.opera.mini.android.AndroidApplication app;
    Signature: Lcom/opera/mini/android/AndroidApplication;
  static com.opera.mini.android.Browser instance;
    Signature: Lcom/opera/mini/android/Browser;
  private android.content.res.Configuration currentConfiguration;
    Signature: Landroid/content/res/Configuration;
  private android.content.Intent launchIntent;
    Signature: Landroid/content/Intent;
  protected boolean started;
    Signature: Z
  private boolean inLandscapeMode;
    Signature: Z
  private boolean hardKeyboardOut;
    Signature: Z
  private boolean isFullScreen;
    Signature: Z
  private boolean beingDestroyed;
    Signature: Z
  private boolean isInBackground;
    Signature: Z
  static boolean nativeLibraryLoaded;
    Signature: Z
  public com.opera.mini.android.Browser();
    Signature: ()V

  private native void nativeOnCreate();
    Signature: ()V

  public native void destroyNative();
    Signature: ()V

  protected void onStart();
    Signature: ()V

  public void onCreate(android.os.Bundle);
    Signature: (Landroid/os/Bundle;)V

  private boolean hasTopStatusBar();
    Signature: ()Z

  protected void onNewIntent(android.content.Intent);
    Signature: (Landroid/content/Intent;)V

  public void onWindowFocusChanged(boolean);
    Signature: (Z)V

  public boolean onSearchRequested();
    Signature: ()Z

  protected void setFullScreen(boolean);
    Signature: (Z)V

  protected void onPause();
    Signature: ()V

  public boolean allowNetworkUsage();
    Signature: ()Z

  public boolean networkAvailableAndAllowed();
    Signature: ()Z

  protected void onResume();
    Signature: ()V

  boolean isBeingDestroyed();
    Signature: ()Z

  protected void onDestroy();
    Signature: ()V

  protected void onStop();
    Signature: ()V

  protected void onRestart();
    Signature: ()V

  public void onConfigurationChanged(android.content.res.Configuration);
    Signature: (Landroid/content/res/Configuration;)V

  protected void onActivityResult(int, int, android.content.Intent);
    Signature: (IILandroid/content/Intent;)V

  public boolean getCurrentScreenRotation();
    Signature: ()Z

  private boolean updateScreenRotation(android.content.res.Configuration);
    Signature: (Landroid/content/res/Configuration;)Z

  private boolean updateHardKeyboard(android.content.res.Configuration);
    Signature: (Landroid/content/res/Configuration;)Z

  public boolean hasHardwareKeyboard();
    Signature: ()Z

  public boolean usingHardwareKeyboard();
    Signature: ()Z

  public void openURL(java.lang.String);
    Signature: (Ljava/lang/String;)V

  private void handleIntent(android.content.Intent);
    Signature: (Landroid/content/Intent;)V

  static void loadNativeLibrary();
    Signature: ()V

  public boolean isFirstApplicationRun();
    Signature: ()Z

  static {};
    Signature: ()V
}"""


#for line in sigs.splitlines(): #filter(None, sigs.splitlines()):
#	print line
print '-----------\n'
#for line in sigs.split('\n'):
#	print line
print '-----------'


mulLine = """Hello!!! 
FLASE
False
false

Wellcome to Python's world! 
There are a lot of interesting things! 
Enjoy yourself. Thank you!"""

for line in filter(None, mulLine.split('\n')): #mulLine.splitlines()):
	print line
