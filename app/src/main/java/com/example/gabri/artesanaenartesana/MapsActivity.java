package com.example.gabri.artesanaenartesana;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng España = new LatLng( 40.415230, -3.707322 );

    //BARES
    private static final LatLng LaBirroteca = new LatLng( 40.481235, -3.3664592000000084 );
    private static final LatLng FoggBar = new LatLng( 40.4123367, -3.697964700000057 );
    private static final LatLng BirraYPaz = new LatLng( 40.4196382, -3.678222099999971 );
    private static final LatLng BeerHouse = new LatLng( 40.4305865, -3.7017166000000543 );
    private static final LatLng PezTortilla = new LatLng( 40.4242214, -3.7064434999999776 );
    private static final LatLng Irreale = new LatLng( 40.4288186, -3.704603899999938 );
    private static final LatLng Cervecissimus = new LatLng( 40.4288186, -3.704603899999938 );
    private static final LatLng BFourBeer = new LatLng( 40.4469775, -3.6676985000000286 );
    private static final LatLng Troade = new LatLng( 40.4371996, -3.6454387999999653 );
    private static final LatLng LaMalteria = new LatLng( 40.31779299999999, -3.8768654000000424 );
    //TIENDAS
    private static final LatLng LabirraTorium = new LatLng( 40.4337876, -3.7085465000000113 );
    private static final LatLng TheBeerGarden = new LatLng( 40.43357, -3.699889999999982 );
    private static final LatLng LaBuenaCerveza = new LatLng( 40.4220964, -3.6990954999999985 );
    private static final LatLng MasQueCervezas = new LatLng( 40.4128505, -3.6994498999999905 );
    private static final LatLng BeHoppy = new LatLng( 40.4109348, -3.694125299999996 );
    private static final LatLng TiendaCerveza = new LatLng( 40.4105946, -3.7080736000000343 );
    private static final LatLng MaisonBelge = new LatLng( 40.4040895, -3.696666100000016 );
    private static final LatLng Cervezas = new LatLng( 40.3857954, -3.7044730000000072 );


    private Marker birroteca;
    private Marker fogBar;
    private Marker birraPaz;
    private Marker bHouse;
    private Marker pTortilla;
    private Marker cIrreale;
    private Marker cCervecissimus;
    private Marker Bfour;
    private Marker cTroade;
    private Marker malteria;
    //TIENDAS
    private Marker Labirratorium;
    private Marker BuenaCerveza;
    private Marker masQcervezas;
    private Marker BHoppy;
    private Marker TCerveza;
    private Marker MBelge;
    private Marker cervezas;
    private Marker Beergarden;

    private Marker marcador;
    double lat = 0.0;
    double lng = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maps );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( España, 12 ) );
        mMap.getUiSettings().setZoomControlsEnabled( true );
        //BARES
        birroteca = mMap.addMarker( new MarkerOptions().position( LaBirroteca ).title( "La Birroteca" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        fogBar = mMap.addMarker( new MarkerOptions().position( FoggBar ).title( "Fogg Bar" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        birraPaz = mMap.addMarker( new MarkerOptions().position( BirraYPaz ).title( "Birra Y Paz" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        bHouse = mMap.addMarker( new MarkerOptions().position( BeerHouse ).title( "Beer House" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        pTortilla = mMap.addMarker( new MarkerOptions().position( PezTortilla ).title( "Pez Tortilla" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        cIrreale = mMap.addMarker( new MarkerOptions().position( Irreale ).title( "Irreale" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        cCervecissimus = mMap.addMarker( new MarkerOptions().position( Cervecissimus ).title( "Cervecissimus" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        Bfour = mMap.addMarker( new MarkerOptions().position( BFourBeer ).title( "B Four Beer" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        cTroade = mMap.addMarker( new MarkerOptions().position( Troade ).title( "Troade" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        malteria = mMap.addMarker( new MarkerOptions().position( LaMalteria ).title( "La Malteria" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        //TIENDAS
        Labirratorium = mMap.addMarker( new MarkerOptions().position( LabirraTorium ).title( "Labirratorium" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        Beergarden = mMap.addMarker( new MarkerOptions().position( TheBeerGarden ).title( "The Beer Garden" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        BuenaCerveza = mMap.addMarker( new MarkerOptions().position( LaBuenaCerveza ).title( "La Buena Cerveza" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        masQcervezas = mMap.addMarker( new MarkerOptions().position( MasQueCervezas ).title( "Mas Que Cervezas" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        BHoppy = mMap.addMarker( new MarkerOptions().position( BeHoppy ).title( "Be Hoppy" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        TCerveza = mMap.addMarker( new MarkerOptions().position( TiendaCerveza ).title( "La Tienda de la Cerveza" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        MBelge = mMap.addMarker( new MarkerOptions().position( MaisonBelge ).title( "La Maison Belge" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );
        cervezas = mMap.addMarker( new MarkerOptions().position( Cervezas ).title( "+De Cien Cervezas" ).icon( BitmapDescriptorFactory.fromResource( R.mipmap.llena ) ) );

    }

    private void agregarMarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng( lat, lng );
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom( coordenadas, 20 );
        if (marcador != null) marcador.remove();
        marcador = mMap.addMarker( new MarkerOptions().position( coordenadas ).title( "Mi posicion" ) );
        mMap.animateCamera( miUbicacion );
    }

    private void actulizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcador( lat, lng );

        }
    }

    //activar los servicios del gps cuando esten apagados
    public void activarGPS() {
        LocationManager mlocManager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
        final boolean gpsEnabled = mlocManager.isProviderEnabled( LocationManager.GPS_PROVIDER );
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS );
            startActivity( settingsIntent );
        }

    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actulizarUbicacion( location );
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {
            Toast.makeText( getApplicationContext(), "Active GPS", Toast.LENGTH_LONG ).show();
            activarGPS();

        }
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled( true );
        LocationManager locationManager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
        Location location = locationManager.getLastKnownLocation( LocationManager.GPS_PROVIDER );
        actulizarUbicacion( location );
        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 10000, 0, locationListener );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
