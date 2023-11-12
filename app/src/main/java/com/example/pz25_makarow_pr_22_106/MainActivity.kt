package com.example.pz25_makarow_pr_22_106

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pz25_makarow_pr_22_106.ui.theme.Pz25_makarow_pr_22_106Theme
import java.io.IOException

private lateinit var soundPool: SoundPool
private var catSound: Int = 0
private var chickenSound: Int = 0
private var cowSound: Int = 0
private var dogSound: Int = 0
private var duckSound: Int = 0
private var sheepSound: Int = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(this)
        setContent {
            Pz25_makarow_pr_22_106Theme {
                InitInterface()

            }
        }
    }
}


@Composable
fun InitInterface()
{
    Column(modifier = Modifier.fillMaxSize().background(Color(red = 132,green = 228 ,blue = 255)), verticalArrangement = Arrangement.SpaceAround )
    {
        Row(Modifier.padding(20.dp).fillMaxWidth())
        {
            Image(
                painter = painterResource(id = R.drawable.cow),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(cowSound,1f,1f,0,0,1f)
                })
            Image(
                painter = painterResource(id = R.drawable.chicken),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(chickenSound,1f,1f,0,0,1f)
            })

        }
        Row(Modifier.padding(20.dp).fillMaxWidth())
        {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(catSound,1f,1f,0,0,1f)
                })
            Image(
                painter = painterResource(id = R.drawable.duck),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(duckSound,1f,1f,0,0,1f)
                })

        }
        Row(Modifier.padding(20.dp).fillMaxWidth())
        {
            Image(
                painter = painterResource(id = R.drawable.sheep),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(sheepSound,1f,1f,0,0,1f)
                })
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = "Cow_img",
                modifier = Modifier.size(200.dp, 150.dp).clickable {
                    soundPool.autoPause()
                    soundPool.play(dogSound,1f,1f,0,0,1f)
                })

        }
    }

}

fun init(context: Context)
{
    val attributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .build()
    soundPool = SoundPool.Builder()
        .setMaxStreams(3)
        .setAudioAttributes(attributes)
        .build()

    //assetManager = context.assets
    catSound = soundPool.load(context,R.raw.cat,1)
    chickenSound = soundPool.load(context,R.raw.chicken,1)
    cowSound = soundPool.load(context,R.raw.cow,1)
    dogSound = soundPool.load(context,R.raw.dog,1)
    duckSound = soundPool.load(context,R.raw.duck,1)
    sheepSound = soundPool.load(context,R.raw.sheep,1)
}
