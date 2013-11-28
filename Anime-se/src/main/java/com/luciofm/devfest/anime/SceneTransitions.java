package com.luciofm.devfest.anime;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.transition.support.ChangeBounds;
import android.transition.support.Scene;
import android.transition.support.Transition;
import android.transition.support.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class SceneTransitions extends Fragment implements View.OnClickListener {
	private ViewGroup mContainer;
	private TransitionManager mTxManager;

	private Scene mScene1;
	private Scene mScene2;
	private Scene mScene3;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_part2, container, false);
		mContainer = (ViewGroup) view.findViewById(R.id.container);
		mTxManager = new TransitionManager();
		mScene1 = Scene.getSceneForLayout(mContainer, R.layout.grid1, getActivity());
		mScene1.setEnterAction(new Runnable() {
			@Override
			public void run() {
				mScene1.getSceneRoot().findViewById(R.id.item2).setOnClickListener(SceneTransitions.this);
				mScene1.getSceneRoot().findViewById(R.id.item3).setOnClickListener(SceneTransitions.this);
			}
		});
		mScene2 = Scene.getSceneForLayout(mContainer, R.layout.grid2, getActivity());
		mScene2.setEnterAction(new Runnable() {
			@Override
			public void run() {
				mScene2.getSceneRoot().findViewById(R.id.item1).setOnClickListener(SceneTransitions.this);
				mScene2.getSceneRoot().findViewById(R.id.item3).setOnClickListener(SceneTransitions.this);
			}
		});
		mScene3 = Scene.getSceneForLayout(mContainer, R.layout.grid3, getActivity());
		mScene3.setEnterAction(new Runnable() {
			@Override
			public void run() {
				mScene3.getSceneRoot().findViewById(R.id.item1).setOnClickListener(SceneTransitions.this);
				mScene3.getSceneRoot().findViewById(R.id.item2).setOnClickListener(SceneTransitions.this);
			}
		});
		Transition transition = new ChangeBounds();
		mTxManager.setTransition(mScene1, mScene2, transition);
		mTxManager.setTransition(mScene1, mScene3, transition);
		mTxManager.setTransition(mScene2, mScene1, transition);
		mTxManager.setTransition(mScene2, mScene3, transition);
		mTxManager.setTransition(mScene3, mScene1, transition);
		mTxManager.setTransition(mScene3, mScene2, transition);
		mScene1.enter();
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.item1:
				mTxManager.transitionTo(mScene1);
				break;
			case R.id.item2:
				mTxManager.transitionTo(mScene2);
				break;
			case R.id.item3:
				mTxManager.transitionTo(mScene3);
				break;
		}

	}
}
