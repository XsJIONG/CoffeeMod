package com.jxs.cofmod.ui;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.util.*;
import android.widget.*;
import com.jxs.cofmod.util.*;

public class VEditText extends EditText implements UI.OnThemeChangeListener {
	public VEditText(Context cx) {
		this(cx, null);
	}
	public VEditText(Context cx, AttributeSet attr) {
		super(cx, attr);
		init();
	}
	private void init() {
		rSetUnderLineColor(UI.getThemeColor());
		UI.registThemeChangedListener(this, this);
	}
	public void setUnderLineColor(int color) {
		rSetUnderLineColor(color);
		_SettedColor = true;
	}
	private void rSetUnderLineColor(int color) {
		Drawable d=getBackground();
		if (d != null) d.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
	}
	private boolean _SettedColor=false;
	@Override
	public void onThemeChange(String key) {
		if (!key.equals(UI.THEME_UI_COLOR)) return;
		if (!_SettedColor) rSetUnderLineColor(UI.getThemeColor());
	}
	@Override
	protected void onDetachedFromWindow() {
		UI.removeThemeChangedListener(this);
	}
}

