package taiwan.no1.turbodisco

import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions

@ExperimentalGetImage
class AnalyzeImageAnalyzer(
    private val listener: (List<ImageLabel>) -> Unit,
) : ImageAnalysis.Analyzer {
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            // Pass image to an ML Kit Vision API
            // ...
            ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS).apply {
                process(image)
                    .addOnSuccessListener(listener)
                    .addOnFailureListener(::println)
                    .addOnCompleteListener { imageProxy.close() }
            }
        }
    }
}
