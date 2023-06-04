package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose.ui.theme.JetpackComposeTheme

class ActivityList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    displayList()
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun displayList() {
    // on below line we arecreating a simple list
    // of strings and adding different programming
    // languages in it.
    val languages = listOf(
        "C++", "C", "C#", "Java", "Kotlin", "Dart", "Python", "Javascript", "SpringBoot",
        "XML", "Dart", "Node JS", "Typescript", "Dot Net", "GoLang", "MongoDb",
    )
    // on below line we are
    // creating a simple column
    Column(
        // inside this column we are specifying modifier
        // to specify max width and max height
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        // on below line we are specifying horizontal alignment
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are creating a simple text
        // view for displaying heading for our application
        Text(
            text = "Simple ListView Example",
            // in modifier we are specifying padding
            // for our text from all sides.
            modifier = Modifier.padding(15.dp),
            // on below line we are specifying
            // style for our text
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )
        // on below line we are calling lazy column
        // for displaying listview.
        LazyColumn {
            // on below line we are populating
            // items for listview.
            items(languages.size) { language ->
                // on below line we are specifying ui for each item of list view.
                // we are specifying a simple text for each item of our list view.
                Text(text = languages[language],
                    // on below line we are specifying
                    // modifier for our text view.
                    modifier = Modifier.padding(15.dp))
                // on below line we are specifying
                // divider for each list item
                Divider()
            }
        }
    }
}