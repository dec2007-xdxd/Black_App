package com.example.appmaps

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.appmaps.ui.theme.AppMapsTheme

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppMapsTheme {
                ViewContainer()
            }
        }
    }
}

@Composable
fun ViewContainer() {

    val context = LocalContext.current

    var mostrarVentana by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = Color(0xFFFAF8FF),

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    mostrarVentana = true
                },
                containerColor = Color(0xFF6422B8),
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp
                )
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFAF8FF)),

            contentPadding = PaddingValues(bottom = 90.dp)
        ) {

            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.portada),
                        contentDescription = "Portada",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(start = 18.dp, top = 20.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color(0xDD292536))
                            .padding(
                                horizontal = 15.dp,
                                vertical = 10.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "UPP",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.width(9.dp))

                        Text(
                            text = "Universidad Politécnica\nde Pachuca",
                            color = Color.White,
                            fontSize = 12.sp,
                            lineHeight = 15.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 18.dp)
                            .size(138.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
                            .clip(CircleShape)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.perfil),
                            contentDescription = "Foto de perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 18.dp,
                            end = 18.dp,
                            top = 15.dp,
                            bottom = 24.dp
                        )
                ) {

                    Text(
                        text = "DIEGO OMAR ESPINOZA CUEVAS",
                        color = Color(0xFF111B38),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 27.sp
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "Ingeniería en TIID | Desarrollador de Software",
                        color = Color(0xFF6422B8),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "dec2007@micorreo.upp.edu.mx",
                        color = Color(0xFF667085),
                        fontSize = 13.sp
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 18.dp,
                            end = 18.dp,
                            bottom = 26.dp
                        )
                ) {

                    Text(
                        text = "About",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF111B38)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "¡Hola! Soy Omar, actualmente estoy " +
                                "estudiando Ingeniería en Tecnologías " +
                                "de la Información e Innovación Digital " +
                                "en la Universidad Politécnica de Pachuca. " +
                                "Me apasiona desarrollar software para " +
                                "solucionar problemas y también me gusta " +
                                "crear aplicaciones por diversión.",
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = Color(0xFF596579)
                    )
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 18.dp,
                            end = 18.dp,
                            bottom = 25.dp
                        )
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "</> HABILIDADES",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF111B38)
                        )


                    }

                    Spacer(modifier = Modifier.height(17.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    ) {

                        Row(
                            modifier = Modifier.horizontalScroll(
                                rememberScrollState()
                            ),
                            horizontalArrangement = Arrangement.spacedBy(9.dp)
                        ) {

                            // C++
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.cpp),
                                    contentDescription = "C++",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "C++",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.csharp),
                                    contentDescription = "C#",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "C#",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.java),
                                    contentDescription = "Java",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "Java",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.php),
                                    contentDescription = "PHP",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "PHP",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.javascript),
                                    contentDescription = "JavaScript",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "JavaScript",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.html),
                                    contentDescription = "HTML",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "HTML",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.css),
                                    contentDescription = "CSS",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "CSS",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.sqlserver),
                                    contentDescription = "SQL Server",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "SQL Server",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.mysql),
                                    contentDescription = "MySQL",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "MySQL",
                                    color = Color(0xFF111B38)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(Color(0xFFF0E7FC))
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.oracle),
                                    contentDescription = "Oracle Database",
                                    modifier = Modifier.size(26.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(7.dp))
                                Text(
                                    text = "Oracle Database",
                                    color = Color(0xFF111B38)
                                )
                            }
                        }
                    }
                }
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 18.dp,
                            end = 18.dp,
                            bottom = 25.dp
                        )
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(270.dp)
                            .clip(RoundedCornerShape(22.dp))
                    ) {
                        MyGoogleMaps()
                    }
                }
            }
        }
    }

    if (mostrarVentana) {

        AlertDialog(
            onDismissRequest = {
                mostrarVentana = false
            },

            containerColor = Color(0xFFFAF8FF),

            title = {
                Text(
                    text = "Más sobre mí",
                    color = Color(0xFF111B38),
                    fontWeight = FontWeight.Bold
                )
            },

            text = {
                Column {

                    Text(
                        text = "Diego Omar Espinoza Cuevas",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6422B8)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Universidad Politécnica de Pachuca",
                        color = Color(0xFF596579)
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = "Ingeniería en TIID",
                        color = Color(0xFF596579)
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = "Me apasiona desarrollar software " +
                                "para resolver problemas y divertirme.",
                        color = Color(0xFF596579)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "¡Gracias por visitar mi portafolio!",
                        color = Color(0xFF6422B8),
                        fontWeight = FontWeight.Bold
                    )
                }
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Gracias por visitar mi portafolio :D",
                            Toast.LENGTH_SHORT
                        ).show()

                        mostrarVentana = false
                    }
                ) {
                    Text(
                        text = "Cerrar",
                        color = Color(0xFF6422B8)
                    )
                }
            }
        )
    }
}

@Composable
fun MyGoogleMaps() {

    val upp = LatLng(19.98007, -98.68530)

    val properties by remember {
        mutableStateOf(
            MapProperties(
                mapType = MapType.NORMAL
            )
        )
    }

    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                zoomControlsEnabled = false
            )
        )
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            upp,
            16f
        )
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    ) {

        Marker(
            position = upp,
            title = "Universidad Politécnica de Pachuca",
            snippet = "Aquí estudio Ingeniería en TIID"
        )
    }
}
