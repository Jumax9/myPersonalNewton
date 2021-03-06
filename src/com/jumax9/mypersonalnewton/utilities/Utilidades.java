package com.jumax9.mypersonalnewton.utilities;

import com.jumax9.mypersonalnewton.objects.Oopart;
import com.jumax9.mypersonalnewton.objects.Ooparts;
import com.jumax9.mypersonalnewton.objects.Planet;
import com.jumax9.mypersonalnewton.objects.Planetes;

import android.content.Context;

public class Utilidades {
	static String gravedad;
	static double dist, mass;
	static Planet p;

	public static String calculation(float altitud) {
		// Computes gravity at a certain altitude above sea level
		float rT, rNew, g0, coef, g;
		rT = 6300000f;
		rNew = rT + altitud;
		g0 = 9.8f;
		coef = (rT * rT) / (rNew * rNew);
		g = g0 * coef;
		gravedad = "En comparación con la gravedad de la Tierra a esta altura (" + altitud + " m) sobre el nivel del mar que es de " + String.format("%1.5f", g) + " m/s^2 ";
		return gravedad;
	}

	public static String planetGravity(String planet) {
		// Returns gravity pull from an object of mass mass at a distance dist
		double gra;
		// G = Newtonian Gravitatonial Constant
		// factor from au/s^2 to m/s^2
		p = datosPlanet(planet);
		gra = gravedadMS(p.mass(), p.distanceFromEarth());
		gravedad = p.name() + " ejerce sobre ti una gravedad de " + String.format("%6.3E", gra) + " m/s^2 ";
		return gravedad;
	}

	public static Planet datosPlanet(String planet) {
		// Get first character of string planet
		// That character (usally a number) defines the planet
		char planeta;
		planeta = planet.charAt(0);
		p = Planetes.getPlanet(planeta);
		return p;
	}

	public static String oopartGravity(Context c, String objeto) {
		double[] myPosition = ElHippyEse.myPosition(c);
		// String name = "Dólmenes de Menga";
		// double mass = 7E8; // kg, assuming every one of the 32 dolmenes weights as much as the heavier one
		// float latitude = 37.023503f;
		// float longitude = -4.547165f;
		// Oopart menga = new Oopart(name, latitude, longitude,56f, mass);
		// String name = "el Mulhacen";
		// float height = 3479f; // m
		// float latitude = 37.061671f;
		// float longitude = -3.317767f;
		// Oopart mulh = new Oopart(name,latitude,longitude,height,0);
		Oopart oopart = Ooparts.eleccion(objeto);
		double gra = gravedadMS(oopart.mass(), oopart.distanceFromMe(myPosition));
		return "La gravedad que ejerce " + oopart.name() + " sobre ti (a una distancia de" + String.format("%6.0f", oopart.distanceOverSurface(myPosition)) + "km) es de " + String.format("%6.3E", gra) + " m/s^2";
	}

	public static double gravedadMS(double mass, double distance) {
		// returns gravity for a given mass and distance in m/s^2
		double gra, G;
		G = 6.67384E-11;
		gra = G * mass / (distance * distance);
		return gra;

	}

}
