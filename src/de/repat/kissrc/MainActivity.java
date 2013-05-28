package de.repat.kissrc;

import java.util.Locale;

import de.repat.kissrc.enums.ModeEnum;
import de.repat.kissrc.enums.RoomEnum;
import de.repat.kissrc.networkstuff.LightConnection;
import de.repat.kissrc.networkstuff.SettingsStrings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.GestureDetector.OnDoubleTapListener;

public class MainActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 7 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
            case 0:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.LOUNGE);
                return getString(R.string.Lounge).toUpperCase(l);
            case 1:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.KITCHENCOOKING);
                return getString(R.string.KitchenCooking).toUpperCase(l);
            case 2:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.KITCHENMAIN);
                return getString(R.string.KitchenMain).toUpperCase(l);
            case 3:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.DINING);
                return getString(R.string.Dining).toUpperCase(l);
            case 4:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.CORRIDOR);
                return getString(R.string.Corridor).toUpperCase(l);
            case 5:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.SLEEPING);
                return getString(R.string.Sleeping).toUpperCase(l);
            case 6:
                CurrentRoom.getInstance().setRoomEnum(RoomEnum.BATHROOM);
                return getString(R.string.Bathroom).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment implements OnGestureListener, OnDoubleTapListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";
        GestureDetector detector;

        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
            // TextView dummyTextView = (TextView)
            // rootView.findViewById(R.id.section_label);
            // ListView dummyTextView = (ListView)
            // rootView.findViewById(R.id.listView1);
            // dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            // dummyTextView.setAdapter(new ArrayAdapter<String>(getActivity(),
            // android.R.layout.simple_list_item_1,
            // new String[] { "1", "1", "1", "1", "1", "1", "1" }));
            detector = new GestureDetector(this.getActivity(), this);
            detector.setOnDoubleTapListener(this);

            rootView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return detector.onTouchEvent(event);
                }
            });

            return rootView;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("---onDown----", e.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("---onFling---", e1.toString() + e2.toString());
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

            // int initialColor = 0xff0000ff;
            // AmbilWarnaDialog dialog = new
            // AmbilWarnaDialog(getActivity().getApplicationContext(),
            // initialColor,
            // new OnAmbilWarnaListener() {
            // @Override
            // public void onOk(AmbilWarnaDialog dialog, int color) {
            // // set Color
            // }
            //
            // @Override
            // public void onCancel(AmbilWarnaDialog dialog) {
            // // cancel was selected by the user
            // }
            // });
            //
            // dialog.show();
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("---onScroll---", e1.toString() + e2.toString());
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d("---onShowPress---", e.toString());
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("---onSingleTapUp---", e.toString());
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Mode.getInstance().next();
            Log.d("NewMode", Mode.getInstance().getLCWMode().toString());
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("---onDoubleTapEvent---", e.toString());
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            if (Mode.getInstance().getLCWMode() == ModeEnum.LIGHTS) {
                processLights();
            } else if (Mode.getInstance().getLCWMode() == ModeEnum.CURTAINS) {
                processCurtains();
            } else if (Mode.getInstance().getLCWMode() == ModeEnum.WINDOWS) {
                processWindows();
            }
            return false;
        }

        private void processLights() {
            switch (CurrentRoom.getInstance().getRoomEnum()) {
            case LOUNGE:
                LightConnection.getInstance().execute(SettingsStrings.KITCHENCOLOR,
                        CurrentRoom.getInstance().getColor().getRed(), CurrentRoom.getInstance().getColor().getGreen(),
                        CurrentRoom.getInstance().getColor().getBlue(), "0");

            case KITCHENCOOKING:

            case KITCHENMAIN:

            case DINING:

            case CORRIDOR:

            case SLEEPING:

            case BATHROOM:

            }

        }

        private void processCurtains() {
        }

        private void processWindows() {
        }

    }

}
