package com.rpap.taskmaster.activities;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.rpap.taskmaster.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class mainRecycleViewTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainRecycleViewTest() {
        ViewInteraction recyclerView = onView(
allOf(withId(R.id.mainActivityRecyclerViewTasks),
withParent(allOf(withContentDescription("Navigate To User Settings"),
withParent(withId(android.R.id.content)))),
isDisplayed()));
        recyclerView.check(matches(isDisplayed()));
        
        ViewInteraction materialButton = onView(
allOf(withId(R.id.mainActivityAddTaskButton), withText("ADD TASK"),
childAtPosition(
allOf(withContentDescription("Navigate To User Settings"),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        materialButton.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.addTaskActivityTaskTitleInput),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
4),
isDisplayed()));
        appCompatEditText.perform(replaceText("newstuff"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.addTaskActivityTaskDescriptionInput),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatEditText2.perform(replaceText("stuff stuff"), closeSoftKeyboard());
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.taskStatusSpinner),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
6),
isDisplayed()));
        appCompatSpinner.perform(click());
        
        DataInteraction materialTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(2);
        materialTextView.perform(click());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.addTaskActivityTaskDescriptionInput), withText("stuff stuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());
        
        ViewInteraction materialButton2 = onView(
allOf(withId(R.id.addTaskActivityAddTaskButton), withText("Add Task"), withContentDescription("Add Task Button"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        materialButton2.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.addTaskActivityTaskTitleInput), withText("newstuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
4),
isDisplayed()));
        appCompatEditText4.perform(replaceText("morenewstuff"));
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.addTaskActivityTaskTitleInput), withText("morenewstuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
4),
isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.addTaskActivityTaskTitleInput), withText("morenewstuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
4),
isDisplayed()));
        appCompatEditText6.perform(click());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.addTaskActivityTaskDescriptionInput), withText("stuff stuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatEditText7.perform(replaceText("stuff stuff stuff stuff"));
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.addTaskActivityTaskDescriptionInput), withText("stuff stuff stuff stuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatSpinner2 = onView(
allOf(withId(R.id.taskStatusSpinner),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
6),
isDisplayed()));
        appCompatSpinner2.perform(click());
        
        DataInteraction materialTextView2 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(3);
        materialTextView2.perform(click());
        
        ViewInteraction appCompatEditText9 = onView(
allOf(withId(R.id.addTaskActivityTaskDescriptionInput), withText("stuff stuff stuff stuff"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatEditText9.perform(pressImeActionButton());
        
        ViewInteraction materialButton3 = onView(
allOf(withId(R.id.addTaskActivityAddTaskButton), withText("Add Task"), withContentDescription("Add Task Button"),
childAtPosition(
allOf(withId(R.id.add),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        materialButton3.perform(click());
        
        pressBack();
        
        ViewInteraction recyclerView2 = onView(
allOf(withId(R.id.mainActivityRecyclerViewTasks),
childAtPosition(
withContentDescription("Navigate To User Settings"),
5)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));
        
        pressBack();
        
        ViewInteraction recyclerView3 = onView(
allOf(withId(R.id.mainActivityRecyclerViewTasks),
childAtPosition(
withContentDescription("Navigate To User Settings"),
5)));
        recyclerView3.perform(actionOnItemAtPosition(1, click()));
        
        pressBack();
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
