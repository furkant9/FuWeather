package com.furkantazegullu.weather.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.furkantazegullu.weather.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by user on 7.08.2016.
 */
public class FragmentGMap extends Fragment implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    Double latitude, longitude;
    String cityName;
    Marker myMarker;
    SharedPreferences sharedPreferences;
    Integer cityId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmaps, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        cityName = getArguments().getString("cityname");
        latitude = getArguments().getDouble("latitude");
        longitude = getArguments().getDouble("longitude");
        cityId=getArguments().getInt("cityid");
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setOnMarkerClickListener(this);
        LatLng pinPoint = new LatLng(latitude, longitude);
        myMarker=googleMap.addMarker(new MarkerOptions().position(pinPoint).title(cityName).visible(true));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pinPoint, 13));

    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        if(marker.equals(myMarker)){
            if (cityName != null && cityId != null) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("currentcityname", cityName);
                editor.putInt("currentcityid", cityId);
                editor.apply();
                Toast.makeText(getContext(),cityName+" Şehirine Ayarlandı!",Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,new FragmentHome(),"visible_fragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        }
        return true;
    }
}
