package com.jumax9.mypersonalnewton.objects;

import java.util.Date;
import java.util.GregorianCalendar;

public class Planet {
	protected String name;
	protected double orbDist, orbPer, relPh, mass;
	// To convert from AU to m
	protected double factor = 1.496E11;

	public Planet(String name, double orbDist, double orbPer, double relPh, double mass) {
		this.name = name;
		this.orbDist = orbDist;
		this.orbPer = orbPer;
		this.relPh = relPh;
		this.mass = mass;
	}

	public String name() {
		return this.name;
	}

	public double mass() {
		// kg
		double masa, solarMass;
		solarMass = 1.988435E30;
		masa = this.mass * solarMass;
		return masa;
	}

	public double orbitalDistance() {
		// au
		return this.orbDist;
	}

	public double orbitalFrequency() {
		return 1 / this.orbPer;
	}

	public double relativePhase() {
		return this.relPh;
	}

	public double distanceFromEarth() {
		double x, y, dist;
		// Returns distance between planet P and Earth today
		// dia = Days since 4-Mar-2014
		if (this.name == "La luna") {
			//double horas = 24;
			// Distance between Moon and Earth
			// distance between moon and earth is around 59 times
			// radius of earth, so the error is important here
			dist = 378949000;
			return dist ;
		}
		double pT, dT, wT;
		double dia; 
		// We get the days difference since 4-Mar-2014
		try {
			/** The date at 4-Mar-2014 */
			Date d1 = new GregorianCalendar(2014, 3, 4, 12, 00).getTime();
			/** Today's date */
			Date today = new Date();
			// Get msec from each, and subtract.
			long diff = today.getTime() - d1.getTime();
			dia = diff/(1000 * 60 * 60 * 24);
		} catch (Exception e) {
			dia = 1;
		}
		// Mean distance Earth-Sun
		dT = 1.00013973f;
		pT = 365.25646f; // orbital period
		wT = 1 / pT;
		x = dT * Math.cos(wT * dia) - this.orbitalDistance() * Math.cos(this.orbitalFrequency() * dia + this.relativePhase());
		y = dT * Math.sin(wT * dia) - this.orbitalDistance() * Math.sin(this.orbitalFrequency() * dia + this.relativePhase());
		dist = Math.sqrt(x * x + y * y);
		return dist * factor;
	}

}
