package com.example.artspaceshalza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceshalza.ui.theme.ArtspaceshalzaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceshalzaTheme {
                ArtSpaceApp()
            }
        }
    }
}

data class Gallery(
    val title: String,
    val location: String,
    val description: String,
    val image: Int
)

@Composable
fun ArtSpaceApp() {

    var currentPage by remember { mutableIntStateOf(0) }

    val cream = Color(0xFFF5F0E6)
    val blue = Color(0xFF7185B5)
    val black = Color(0xFF333333)

    val galleryList = listOf(

        Gallery(
            "Museum Affandi",
            "Yogyakarta, Indonesia",
            "Museum Affandi merupakan salah satu tempat wisata seni terkenal di Yogyakarta. Pengunjung dapat melihat berbagai lukisan karya Affandi, mengenal kehidupan sang pelukis, serta menikmati keunikan bangunan museum.",
            R.drawable.museumaffandi
        ),

        Gallery(
            "Cemeti Institute",
            "Yogyakarta, Indonesia",
            "Cemeti Institute merupakan tempat wisata seni yang menarik untuk dikunjungi. Tempat ini memiliki suasana kreatif dan menampilkan berbagai karya seni modern dari seniman Indonesia maupun luar negeri.",
            R.drawable.institut_cemeti
        ),

        Gallery(
            "Langgeng Art Foundation",
            "Yogyakarta, Indonesia",
            "Langgeng Art Foundation merupakan tempat yang cocok dikunjungi bagi pecinta seni. Pengunjung dapat menikmati berbagai karya seni, melihat pameran menarik, dan mengenal perkembangan seni di Yogyakarta.",
            R.drawable.langgeng_art_foundation
        ),

        Gallery(
            "Taman Budaya Yogyakarta",
            "Yogyakarta, Indonesia",
            "Taman Budaya Yogyakarta merupakan salah satu tempat wisata budaya yang sering dikunjungi. Tempat ini memiliki berbagai kegiatan menarik seperti pertunjukan tari, musik, teater, dan pameran budaya.",
            R.drawable.taman_budaya_yogyakarta
        ),

        Gallery(
            "Jogja National Museum",
            "Yogyakarta, Indonesia",
            "Jogja National Museum merupakan tempat wisata yang memiliki bangunan bersejarah dan suasana yang unik. Pengunjung dapat menjelajahi area museum, menikmati berbagai kegiatan seni, serta mengenal budaya dan kreativitas di Yogyakarta.",
            R.drawable.jojga_national_museum
        )
    )

    Scaffold(
        containerColor = cream
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(cream)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Gallery Yogyakarta",
                textAlign = TextAlign.Center,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 50.dp)
            )

            Image(
                painter = painterResource(
                    id = galleryList[currentPage].image
                ),
                contentDescription = galleryList[currentPage].title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = galleryList[currentPage].title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Normal,
                color = black
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = galleryList[currentPage].location,
                fontSize = 15.sp,
                color = black
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = galleryList[currentPage].description,
                fontSize = 15.sp,
                lineHeight = 23.sp,
                color = black
            )

            Spacer(modifier = Modifier.height(35.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = {
                        if (currentPage > 0) currentPage--
                    },
                    enabled = currentPage > 0,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blue
                    )
                ) {
                    Text("Previous")
                }

                Button(
                    onClick = {
                        if (currentPage < galleryList.lastIndex) currentPage++
                    },
                    enabled = currentPage < galleryList.lastIndex,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blue
                    )
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtspaceshalzaTheme {
        ArtSpaceApp()
    }
}