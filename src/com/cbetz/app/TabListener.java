package com.cbetz.app;

import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class TabListener<T extends SherlockFragment> implements
		com.actionbarsherlock.app.ActionBar.TabListener {
	private final SherlockFragmentActivity mActivity;
	private final String mTag;
	private final Class<T> mClass;

	public TabListener(SherlockFragmentActivity activity, String tag,
			Class<T> clz) {
		mActivity = activity;
		mTag = tag;
		mClass = clz;
	}

	/* The following are each of the ActionBar.TabListener callbacks */

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		SherlockFragment preInitializedFragment = (SherlockFragment) mActivity
				.getSupportFragmentManager().findFragmentByTag(mTag);

		// Check if the fragment is already initialized
		if (preInitializedFragment == null) {
			// If not, instantiate and add it to the activity
			SherlockFragment mFragment = (SherlockFragment) SherlockFragment
					.instantiate(mActivity, mClass.getName());
			ft.add(android.R.id.content, mFragment, mTag);
		} else {
			ft.attach(preInitializedFragment);
		}
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		SherlockFragment preInitializedFragment = (SherlockFragment) mActivity
				.getSupportFragmentManager().findFragmentByTag(mTag);

		if (preInitializedFragment != null) {
			// Detach the fragment, because another one is being attached
			ft.detach(preInitializedFragment);
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
