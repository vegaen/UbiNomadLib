package no.ntnu.ubinomad.lib.helpers;

import android.content.Context;
import android.util.Log;
import no.ntnu.ubinomad.lib.Provider;
import no.ntnu.ubinomad.lib.interfaces.AggregatorPlace;
import no.ntnu.ubinomad.lib.interfaces.RawPlace;
import no.ntnu.ubinomad.lib.models.AbstractBaseModel;

public class PlaceHelper {
	
	private static final String TAG = "PlaceHelper";

	public static RawPlace getRawPlaceFromAggregator(Context context, AggregatorPlace aggregatorPlace, Provider provider){
		if (aggregatorPlace ==  null) {
			return null;
		}
		
		((AbstractBaseModel<AggregatorPlace>)aggregatorPlace).setContext(context);
		if (aggregatorPlace.getRawPlaces().size() == 0){
			Log.d(TAG, "No Raw Places");
		}
		
		Log.d(TAG, "RawPlaces: " + aggregatorPlace.getRawPlaces().size());
		
		for(RawPlace place : aggregatorPlace.getRawPlaces()){
			Log.d(TAG, place.getProvider().toString());
			if (place.getProvider() == provider){
				return place;
			}
		}
		Log.d(TAG, provider.toString() + " is not maped in " + aggregatorPlace.toString());
		return null;
	}

}
