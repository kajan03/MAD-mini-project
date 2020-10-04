package com.example.myapplication1;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class LoginTest {
    @Rule
    public ActivityTestRule<Login> loginActivityTestRule=new ActivityTestRule<Login>(Login.class);
    private Login lActivity=null;
    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(Signup.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        lActivity=loginActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfignupActivityOnButtonClick(){
        assertNotNull(lActivity.findViewById(R.id.gotoRegister));
        onView(withId(R.id.gotoRegister)).perform(click());
        Activity Signup=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(Signup);
        Signup.finish();
    }

    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }
}