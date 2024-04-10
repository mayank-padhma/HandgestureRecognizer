package com.google.mediapipe.examples.gesturerecognizer

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizerResult
import kotlin.math.max

class OverlayView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private var results: GestureRecognizerResult? = null

    private var scaleFactor: Float = 1f
    private var imageWidth: Int = 1
    private var imageHeight: Int = 1

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        results?.let { gestureRecognizerResult ->
            // Check the type of gesture and draw corresponding image
            if (gestureRecognizerResult.gestures().isNotEmpty()){
                Log.d("asdf", gestureRecognizerResult.gestures().first()[0].categoryName().toString())
                val imageResId = when(gestureRecognizerResult.gestures().first()[0].categoryName().toString()){
                    "Victory" -> R.drawable.image1
                    "Thumb_Up" -> R.drawable.image2
                    "Thumb_Down" -> R.drawable.image3
                    "Open_Palm" -> R.drawable.image4
                    else -> null
                }
                imageResId?.let { resourceId ->
                    // Load the image resource
                    val bitmap = BitmapFactory.decodeResource(resources, resourceId)
                    // Calculate the scaling factor
                    val scaleWidth = imageWidth * scaleFactor
                    val scaleHeight = imageHeight * scaleFactor

                    // Calculate the position of the image based on the coordinates of the detected gesture
                    val gestureX = gestureRecognizerResult.landmarks().first().first().x()
                    val gestureY = gestureRecognizerResult.landmarks().first().first().y()
                    val imageX = gestureX * scaleWidth - bitmap.width / 2
                    val imageY = gestureY * scaleHeight - bitmap.height / 2
                    // Draw the image at its actual size and position
                    canvas.drawBitmap(bitmap, imageX, imageY, null)
                }
            }
        }
    }

    fun setResults(
        gestureRecognizerResult: GestureRecognizerResult,
        imageHeight: Int,
        imageWidth: Int,
    ) {
        results = gestureRecognizerResult

        this.imageHeight = imageHeight
        this.imageWidth = imageWidth

        // PreviewView is in FILL_START mode. So we need to scale up the
        // landmarks to match with the size that the captured images will be
        // displayed.
        scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
        invalidate()
    }
}
