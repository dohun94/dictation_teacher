package com.blackdog.dictation_teacher.Activity.base;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.blackdog.dictation_teacher.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity.java";

//    private FragmentManager fragmentManager;
//    private ContextMenuDialogFragment mMenuDialogFragment;

    protected
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    protected
    @Nullable
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    protected void bindViews() {
        ButterKnife.bind(this);
//        fragmentManager = getSupportFragmentManager();
        setupToolbar();
//        initMenuFragment();
    }

    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

//    private void initMenuFragment() {
//        MenuParams menuParams = new MenuParams();
//        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
//        menuParams.setMenuObjects(getMenuObjects());
//        menuParams.setClosableOutside(false);
//        menuParams.setAnimationDuration(140);
//        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
//        mMenuDialogFragment.setItemClickListener(this);
//        mMenuDialogFragment.setItemLongClickListener(this);
//    }
//
//    private List<MenuObject> getMenuObjects() {
//        // You can use any [resource, bitmap, drawable, color] as image:
//        // item.setResource(...)
//        // item.setBitmap(...)
//        // item.setDrawable(...)
//        // item.setColor(...)
//        // You can set image ScaleType:
//        // item.setScaleType(ScaleType.FIT_XY)
//        // You can use any [resource, drawable, color] as background:
//        // item.setBgResource(...)
//        // item.setBgDrawable(...)
//        // item.setBgColor(...)
//        // You can use any [color] as text color:
//        // item.setTextColor(...)
//        // You can set any [color] as divider color:
//        // item.setDividerColor(...)
//
//        List<MenuObject> menuObjects = new ArrayList<>();
//
//        MenuObject close = new MenuObject();
//        close.setResource(R.drawable.icn_close);
//
//        MenuObject send = new MenuObject("내 정보 관리");
//        send.setResource(R.drawable.icn_1);
//
//        MenuObject like = new MenuObject("존나 카리스마 있어");
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
//        like.setBitmap(b);
//
//        MenuObject addFr = new MenuObject("내 선생님 관리");
//        BitmapDrawable bd = new BitmapDrawable(getResources(),
//                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
//        addFr.setDrawable(bd);
//
//        MenuObject addFav = new MenuObject("내 성적 관리");
//        addFav.setResource(R.drawable.icn_4);
//
//        MenuObject block = new MenuObject("로그아웃");
//        block.setResource(R.drawable.icn_5);
//
//        menuObjects.add(close);
//        menuObjects.add(send);
//        menuObjects.add(like);
//        menuObjects.add(addFr);
//        menuObjects.add(addFav);
//        menuObjects.add(block);
//        return menuObjects;
//    }

    protected void setupToolbar() {
        //BaseActivity만 쓰려면 해당 액티비티의 레이아웃에 toolbar 추가
        //<include layout="@layout/toolbar" />

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

//    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {
//        invalidateOptionsMenu();
//        String backStackName = fragment.getClass().getName();
//        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
//        if (!fragmentPopped) {
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.add(containerId, fragment, backStackName)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            if (addToBackStack)
//                transaction.addToBackStack(backStackName);
//            transaction.commit();
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(final Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.context_menu:
//                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
//                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
//                }
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onBackPressed() {
//        if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
//            mMenuDialogFragment.dismiss();
//        } else {
//            finish();
//        }
//    }
//
//    @Override
//    public void onMenuItemClick(View clickedView, int position) {
//        if(position == 0){
//
//        }
//        else if(position == 1){
//
//        }
//        else if(position == 2){
//
//        }
//        else if(position == 3){
//
//        }
//        else if(position == 4){
//        }
//
//        else if(position == 5){
//
//        }
//    }
//
//    @Override
//    public void onMenuItemLongClick(View clickedView, int position) {
//
//    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
