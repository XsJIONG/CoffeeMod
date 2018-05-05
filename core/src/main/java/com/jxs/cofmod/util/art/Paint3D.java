package com.jxs.cofmod.util.art;

import com.jxs.cofmod.util.art.Painter3D;
import com.jxs.cofmod.control.Modable;

public class Paint3D extends Modable {
	public float x;
	public float y;
	public float z;
	//坐标轴原点
	private float xz;
	private float yz;
	private float zz;

	private Painter3D q;

	public Paint3D(Object x, Object y, Object z, Painter3D painter) {
		if (painter == null) return;
		this.x = toFloat(x); xz = this.x;
		this.y = toFloat(y); yz = this.y;
		this.z = toFloat(z); zz = this.z;
		q = painter;
	}

	public void line(final Object qx, final Object qy, final Object qz, final Object xx, final Object yy, final Object zz, final Object length) {
		int len=toInt(length);
		float xone=Math.abs(toFloat(qx) - toFloat(xx)) / len;
		float yone=Math.abs(toFloat(qy) - toFloat(yy)) / len;
		float zone=Math.abs(toFloat(qz) - toFloat(zz)) / len;
		float xmin=Math.min(toFloat(qx), toFloat(xx));
		float ymin=Math.min(toFloat(qy), toFloat(yy));
		float zmin=Math.min(toFloat(qz), toFloat(zz));
		for (int i=0;i < len;i++) q.paintPos(xmin + xone * i, ymin + yone * i, zmin + zone * i);
	}

	public void lineTo(final Object xx, final Object yy, final Object zz, final Object len) {
		line(x, y, z, xx, yy, zz, len);
		x = toFloat(xx);
		y = toFloat(yy);
		z = toFloat(zz);
	}

	public void rlineTo(Object xx, Object yy, Object zz, Object len) {
		line(xz, yz, zz, xx, yy, zz, len);
	}

	public void moveTo(Object qx, Object qy, Object qz) {
		x = toFloat(qx);
		y = toFloat(qy);
		z = toFloat(qz);
	}

	public void moveToOrigin() {
		x = xz; y = yz; z = zz;
	}

	public void drawArc(final Object y_xl, final Object y_zl, final Object y_start, final Object y_degress, final Object y_density) {
		float xl=toFloat(y_xl);
		float zl=toFloat(y_zl);
		float start=toFloat(y_start);
		float degress=toFloat(y_degress);
		float density=toFloat(y_density);
		if (start > degress)
			for (float n=degress;n <= start;n += density)
				q.paintPos((float) (x + (Math.cos(toDegress(n)) * xl)), y, (float) (z + (Math.sin(toDegress(n)) * zl)));
		else
			for (float n=start;n <= degress;n += density)
				q.paintPos((float) (x + (Math.cos(toDegress(n)) * xl)), y, (float) (z + (Math.sin(toDegress(n)) * zl)));
	}

	public void drawCircle(Object y_xl, Object y_zl, Object y_density) {
		drawArc(y_xl, y_zl, 0, 360, y_density);
	}

	public double toDegress(float deg) {
		return deg * Math.PI / 180;
	}

	public void drawBall(final Object y_radius, final Object y_density) {
		float radius=toFloat(y_radius);
		float density=toFloat(y_density);
		float yy=y;
		for (float n=0;n <= 90;n += density) {
			float temp=(float) (Math.sin(toDegress(n)) * radius);
			y = yy + temp;
			drawCircle((float) (Math.cos(toDegress(n)) * radius), (float) (Math.cos(toDegress(n)) * radius), density);
			y = yy - temp;
			drawCircle((float) (Math.cos(toDegress(n)) * radius), (float) (Math.cos(toDegress(n)) * radius), density);
		}
		/*Paint3D p=new Paint3D(0, 0, 0, new Painter3D() {
		 @Override
		 public void paintPos(float x, float z, float y) {
		 drawCircle(x,
		 }
		 });
		 p.drawArc(xl, yl, 90, -90, density);*/
	}
}
