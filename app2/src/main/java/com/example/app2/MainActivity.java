package com.example.app2;

import java.lang.reflect.InvocationTargetException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static String LOG = MainActivity.class.getCanonicalName();

    // UI components
    Button button1;
    Button button2;
    Button button3;
    TextView tv1;

    Long test;

    int testCases = 1000;

    // button listener
    OnClickListener onclicker = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == button1) {
                button1Clicked();
            }
            if (v == button2) {
                button2Clicked();
            }
            if (v == button3) {
                button3Clicked();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG, "--onCreate() called.");
        super.onCreate(savedInstanceState);

        test = Long.valueOf(0);

        setupUI();

        tv1.setText("test 1");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void button1Clicked() {
        LibInterfaceOneTest app2class = new LibInterfaceOneTest(
                getApplicationContext());

        tv1.setText("test 2" + app2class.testMethodCall(" YAY!!! "));
        MyRunnable4 r = new MyRunnable4();
        r.run();
    }

    private void button2Clicked() {
        MyRunnable2 r = new MyRunnable2();
        r.run();
    }

    private void button3Clicked() {
        MyRunnable3 r = new MyRunnable3();
        r.run();
    }

    public static int intMethod2(int param) {
        return (param + 1);
    }

    public int intMethod(int param) {
        return (param + 1);
    }

    private void setupUI() {
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(onclicker);
        button2.setOnClickListener(onclicker);
        button3.setOnClickListener(onclicker);

        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public class MyRunnable1 implements Runnable {

        Long longToChange;

        public void init(Long value) {
            longToChange = value;
        }

        // int numTimesLooped = 10000;

        @Override
        public void run() {
            long startTime = System.nanoTime();

            int value = 0;
            int i = 0;
            LibInterfaceOneTest app2class = new LibInterfaceOneTest(
                    getApplicationContext());
            System.gc();

            for (; i < testCases; i++) {
                value += app2class.testMethodCall2(value);
            }

            long finishTime = System.nanoTime();

            long totalTime = finishTime - startTime;

            long displayTime1 = (totalTime / 1000);
            long displayTime2 = (displayTime1 / 1000);
            long displayTime3 = (displayTime2 / 1000);
            Log.d("MAIN ACTIVITY", "Total: " + value + " total time: "
                    + totalTime + " display: " + displayTime1 + ", "
                    + displayTime2 + ", " + displayTime3);
            longToChange = displayTime1;
            Toast.makeText(
                    getApplicationContext(),
                    "Total Time : " + displayTime1 + " μs. " + displayTime2
                            + " ms. " + displayTime3 + " ns.",
                    Toast.LENGTH_LONG).show();

        }
    }

    public class MyRunnable4 implements Runnable {

        Long longToChange;

        public void init(Long value) {
            longToChange = value;
        }

        // int numTimesLooped = 10000;
        int outerLoops = 10;

        @Override
        public void run() {
            try {
                long totalTime = 0;

                int TestCases2 = (testCases / outerLoops);

                int value = 0;
                int i = 0;
                LibInterfaceOneTest app2class = new LibInterfaceOneTest(
                        getApplicationContext());
                for (int i2 = 0; i2 < outerLoops; i2++) {
                    System.gc();
                    long startTime = System.nanoTime();
                    for (; i < TestCases2; i++) {

                        value += app2class.testMethodCall3(value);

                    }
                    long finishTime = System.nanoTime();

                    totalTime += totalTime + (finishTime - startTime);
                }

                long displayTime1 = (totalTime / 1000);
                long displayTime2 = (displayTime1 / 1000);
                long displayTime3 = (displayTime2 / 1000);
                Log.d("MAIN ACTIVITY", "total time: " + totalTime
                        + " display: " + displayTime1 + ", " + displayTime2
                        + ", " + displayTime3);
                longToChange = displayTime1;
                Toast.makeText(
                        getApplicationContext(),
                        "Total: " + value + " Total Time : " + displayTime1
                                + " μs. " + displayTime2 + " ms. "
                                + displayTime3 + " ns.", Toast.LENGTH_LONG)
                        .show();

            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public class MyRunnable2 implements Runnable {

        Long longToChange;

        public void init(Long value) {
            longToChange = value;
        }

        // int numTimesLooped = 10000;

        @Override
        public void run() {
            long startTime = System.nanoTime();

            int value = 0;
            int i = 0;
            MainActivity tester = new MainActivity();
            System.gc();

            for (; i < testCases; i++) {
                value += tester.intMethod(value);
            }

            long finishTime = System.nanoTime();

            Log.d("MAIN ACTIVITY",
                    "************** math =  " + tester.intMethod(100));

            long totalTime = finishTime - startTime;

            long displayTime1 = (totalTime / 1000);
            long displayTime2 = (displayTime1 / 1000);
            long displayTime3 = (displayTime2 / 1000);
            Log.d("MAIN ACTIVITY", "value: " + value + " total time: "
                    + totalTime + " display: " + displayTime1 + ", "
                    + displayTime2 + ", " + displayTime3);
            longToChange = displayTime1;
            Toast.makeText(
                    getApplicationContext(),
                    "Total: " + value + " Total Time : " + displayTime1
                            + " μs. " + displayTime2 + " ms. " + displayTime3
                            + " ns.", Toast.LENGTH_LONG).show();

        }
    }

    public class MyRunnable3 implements Runnable {

        Long longToChange;

        public void init(Long value) {
            longToChange = value;
        }

        // int numTimesLooped = 10000;

        @Override
        public void run() {
            long startTime = System.nanoTime();

            int value = 0;
            int i = 0;
            System.gc();

            for (; i < testCases; i++) {
                value += MainActivity.intMethod2(value);
            }

            long finishTime = System.nanoTime();

            long totalTime = finishTime - startTime;

            long displayTime1 = (totalTime / 1000);
            long displayTime2 = (displayTime1 / 1000);
            long displayTime3 = (displayTime2 / 1000);
            Log.d("MAIN ACTIVITY", "total time: " + totalTime + " display: "
                    + displayTime1 + ", " + displayTime2 + ", " + displayTime3);
            longToChange = displayTime1;
            Toast.makeText(
                    getApplicationContext(),
                    "Value: " + value + "Total Time : " + displayTime1
                            + " μs. " + displayTime2 + " ms. " + displayTime3
                            + " ns.", Toast.LENGTH_LONG).show();

        }
    }

    public class MyRunnable5 implements Runnable {

        Long longToChange;

        public void init(Long value) {
            longToChange = value;
        }

        // int numTimesLooped = 10000;

        @Override
        public void run() {
            long startTime = System.nanoTime();

            int value = 99;
            int i = 0;
            System.gc();

            int time1 =  MainActivity.intMethod2(value);
            MainActivity tester = new MainActivity();
            int time2 =  tester.intMethod(value);;
          
            long finishTime = System.nanoTime();

            long totalTime = finishTime - startTime;

            long displayTime1 = (totalTime / 1000);
            long displayTime2 = (displayTime1 / 1000);
            long displayTime3 = (displayTime2 / 1000);
            Log.d("MAIN ACTIVITY", "total time: " + totalTime + " display: "
                    + displayTime1 + ", " + displayTime2 + ", " + displayTime3);
            longToChange = displayTime1;
            Toast.makeText(
                    getApplicationContext(),
                    "Value: " + value + "Total Time : " + displayTime1
                            + " μs. " + displayTime2 + " ms. " + displayTime3
                            + " ns.", Toast.LENGTH_LONG).show();

        }
    }

}
