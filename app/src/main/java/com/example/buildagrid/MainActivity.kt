package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildGrid()
                }
            }
        }
    }
}
@Composable
fun BuildGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
//        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),

    ) {
        items(DataSource.topics) { topic ->
            Grid(topic)
        }
    }
}



@Composable
fun Grid(gridElement: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(8.dp)
    ){
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(gridElement.imageId),
                contentDescription = stringResource(gridElement.stringId),
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
//           horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(gridElement.stringId),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
//               fontSize = .sp,
//               modifier = Modifier.weight(1f)
                )
                Row(
//               modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.raw_githubusercontent_com_android_compose_samples_main_owl_app_src_main_res_drawable_ic_grain),
                        contentDescription = "grains",
                        modifier = Modifier.background(Color.Black)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = gridElement.count.toString(),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BuildGridPreview() {
    BuildGrid()
}
