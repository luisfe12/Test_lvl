package com.luisfe.lvl_test.ui.peofilephoto

import android.app.Activity
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

fun generateUri(activity: Activity, nameImage: String): Uri {
    return FileProvider.getUriForFile(
        Objects.requireNonNull(activity),
        "com.luisfe.lvl_test.provider",
        createFileCompose(activity, nameImage = nameImage)
    )
}

fun createFileCompose(activity: Activity, nameImage: String): File {
    val name = nameImage.ifEmpty { SimpleDateFormat("yyyyMMdd_hhmmss").format(Date()) }
    return File.createTempFile(name, ".jpg", activity.externalCacheDir)
}


fun selectedOptionBottomBar(
    index: Int,
    cameraLaunchAction: () -> Unit,
    galleryLaunchAction: () -> Unit
) {
    when (index) {
        0 -> {
            //todo nothing
        }

        1 -> {
            cameraLaunchAction()
        }

        2 -> {
            galleryLaunchAction()
        }

        3 -> {
           //todo delete image
        }
    }
}