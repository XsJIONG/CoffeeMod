package com.jxs.cofmod.util;

public class Location {
    public int x;
    public int y;
    public int z;

    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Location)) return false;
		Location l=(Location) obj;
		return l.x == this.x && l.y == this.y && l.z == this.z;
	}
}
