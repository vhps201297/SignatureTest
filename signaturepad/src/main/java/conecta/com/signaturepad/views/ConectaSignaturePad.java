package conecta.com.signaturepad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.util.AttributeSet;

public class ConectaSignaturePad extends SignaturePad {


    private int strokeCount = 0;
    private int idGeneration = 0;
    private Bitmap bitmap;
    private CountDownTimer timer;
    private long elapsedTime = 0;
    private long lastMillisInFuture;

    public ConectaSignaturePad(Context context, AttributeSet attrs) {
        super(context, attrs);
        timer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                lastMillisInFuture = millisUntilFinished;
            }

            @Override
            public void onFinish() {
            }
        };
        setOnSignedListener(new OnSignedListener() {
            @Override
            public void onStartSigning() {
                strokeCount++;
                //System.out.println("count");
                timer.start();

            }

            @Override
            public void onSigned() {
                timer.cancel();
                elapsedTime += (60000 - lastMillisInFuture);
            }

            @Override
            public void onClear() {
                strokeCount = 0;
                elapsedTime = 0;
            }
        });
    }

    public int getStrokeCount() {
        return strokeCount;
    }

    public Bitmap getBitmap(){
        return super.getSignatureBitmap();
    }

    public int getIdGeneration() {
        return idGeneration;
    }

    @Override
    public String getSignatureSvg() {
        return super.getSignatureSvg();
    }

    @Override
    public Bitmap getTransparentSignatureBitmap() {
        return super.getTransparentSignatureBitmap();
    }

    public void finishSignature(){
        bitmap = getSignatureBitmap();
        idGeneration = bitmap.getGenerationId();
    }
    public long getElapsedTime() {
        return elapsedTime;
    }
}
