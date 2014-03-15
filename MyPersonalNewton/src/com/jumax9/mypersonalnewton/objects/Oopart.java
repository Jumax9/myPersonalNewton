package com.jumax9.mypersonalnewton.objects;

public class Oopart {
	protected String name;
	protected float latitude, longitude, height;
	protected double mass;
	protected double Rt = 6378000; // m

	public Oopart(String name, float latitude, float longitude, float height, double mass) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
		// if it's an object of known mass, height 0 and you can use the mass
		// if it's a mountain, mass = 0, and it'll be computed from its height
		this.mass = mass;
	}

	public String name() {
		return this.name;
	}

	public double distanceFromMe(double[] myPosition) {
		// distance (straight line) between the object and MyPosition (metres)
		double myLongitude = myPosition[0];
		double myLatitude = myPosition[1];
		double myLat, myLon, lat, lon, x, y;
		myLat = Math.toRadians(myLatitude);
		myLon = Math.toRadians(myLongitude);
		lat = Math.toRadians(this.latitude);
		lon = Math.toRadians(this.longitude);
		x = Rt * Math.sin(myLon - lon);
		y = Rt * Math.sin(myLat - lat);
		double distance = Math.hypot(x, y);
		// double distance = Math.sqrt(x * x + y * y);
		return distance;
	}

	public double distanceOverSurface(double[] myPosition) {
		// distance over earth surface between the object and MyPosition (kilometres)
		double straightDistance = distanceFromMe(myPosition);
		double dist;
		dist = 2 * Rt * Math.asin(straightDistance / (2 * Rt));
		return dist*(1E-3);
	}

	public double mass() {
		// We're going to use mountains whose mass is calculated
		// assuming a conical shape from its height
		// the radius is = height/2 because of reasons
		// assumed granite density
		double density = 2600;// kg/m^3
		double volume = volume();
		if (this.mass == 0) {
			return volume * density;
		} else {
			return this.mass;
		}
	}

	public double volume() {
		// volume in m^3
		double volumen;
		volumen = Math.PI * Math.pow(this.height, 3) / 12;
		return volumen;
	}

}
