package com.jxs.cofmod.ui;

import android.content.*;
import android.view.*;

public abstract class VFragment {
	Context cx;
	public VFragment(Context cx) {
		this.cx = cx;
	}
	public abstract View getView();
	public abstract Object getTag();
	public void onAttach() {}
	public void onDettach() {}
	public Context getContext() {
		return cx;
	}
}

