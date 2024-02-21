package ge.tnet.superapp.compose_preview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ge.tnet.superapp.compose_preview.R
import ge.tnet.superapp.compose_preview.component.state.ProductData
import ge.tnet.superapp.compose_preview.ui.theme.AppTheme

@Composable
fun SimpleCardComponent(
    modifier: Modifier = Modifier,
    state: ProductData,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.component.cardBackgroundColor,
        ),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        
        if (state.expand) {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ImageContent(
                    imageSize = state.imageSize,
                    imageBackgroundColor = AppTheme.colors.component.imageBackgroundColor,
                    expand = true,
                )
                TextContent(
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                        vertical = 16.dp
                    ),
                    title = state.title,
                    description = state.description,
                )
                Spacer(modifier = Modifier.height(48.dp))
                ButtonComponent()
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row {
                    ImageContent(
                        imageSize = state.imageSize,
                        imageBackgroundColor = AppTheme.colors.component.imageBackgroundColor,
                        expand = false,
                    )
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    TextContent(
                        modifier = Modifier,
                        title = state.title,
                        description = state.description,
                    )
                }
                
                Spacer(Modifier.weight(1f))
                
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    tint = AppTheme.colors.component.textColor,
                )
            }
        }
    }
}

@Composable
private fun ImageContent(
    imageSize: Dp,
    imageBackgroundColor: Color,
    expand: Boolean,
) {
    Box(
        modifier = Modifier
            .let {
                if (expand) {
                    it
                        .fillMaxWidth()
                        .height(imageSize)
                        .clip(RoundedCornerShape(24.dp))
                } else {
                    it
                        .size(imageSize)
                        .clip(CircleShape)
                    
                }
            }
            .background(imageBackgroundColor)
    
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_image_cplaceholder),
            contentDescription = null,
            modifier = Modifier
                .padding(if (expand) 24.dp else 8.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun TextContent(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            color = AppTheme.colors.component.textColor,
            fontSize = 20.sp,
        )
        
        Text(
            text = description,
            color = AppTheme.colors.component.textColor,
            //fontWeight = FontWeight(20),
        )
    }
}

@Composable
private fun ButtonComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xff336DF2),
                        Color(0xff96B2F4)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Action",
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}
